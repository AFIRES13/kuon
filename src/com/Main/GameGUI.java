package com.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.Character.*;
import com.Character.Character;
import com.Monsters.*;
import com.Item.Consumable.*;

public class GameGUI extends JFrame {

    private JTextArea logArea;
    private JButton attackButton, skillButton, inventoryButton, nextWaveButton;
    private JLabel playerStatus, monsterStatus, waveLabel;
    private Character player;
    private Monster monster;
    private int wave = 1, turn = 1;

    public GameGUI() {
        setTitle("Wave Battle RPG");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setupUI();
        startGame();
    }

    private void setupUI() {
        JPanel topPanel = new JPanel(new GridLayout(1, 3));
        playerStatus = new JLabel("Player Status");
        monsterStatus = new JLabel("Monster Status");
        waveLabel = new JLabel("Wave: 1");
        topPanel.add(playerStatus);
        topPanel.add(waveLabel);
        topPanel.add(monsterStatus);
        add(topPanel, BorderLayout.NORTH);

        logArea = new JTextArea();
        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        attackButton = new JButton("Attack");
        skillButton = new JButton("Skill");
        inventoryButton = new JButton("Inventory");
        nextWaveButton = new JButton("Next Wave");
        nextWaveButton.setEnabled(false);

        buttonPanel.add(attackButton);
        buttonPanel.add(skillButton);
        buttonPanel.add(inventoryButton);
        buttonPanel.add(nextWaveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        attackButton.addActionListener(e -> handleAttack());
        skillButton.addActionListener(e -> handleSkill());
        inventoryButton.addActionListener(e -> handleInventory());
        nextWaveButton.addActionListener(e -> nextWave());
    }

    private void startGame() {
        String name = JOptionPane.showInputDialog(this, "Masukkan nama pemain:");
        String[] options = {"Warrior", "Piercer", "Mage"};
        int choice = JOptionPane.showOptionDialog(this, "Pilih role:", "Role",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0 -> player = new RoleWarrior(name);
            case 1 -> player = new RolePiercer(name);
            case 2 -> player = new RoleMage(name);
            default -> System.exit(0);
        }

        for (int i = 0; i < 5; i++) {
            player.addItem(new HealingPotion());
        }

        spawnMonster();
    }

    private void spawnMonster() {
        monster = (wave == 6) ? new goblinKing() : new Goblin(wave);
        log("Wave " + wave + " - " + monster.getName() + " muncul!");
        updateStatus();
    }

    private void updateStatus() {
        playerStatus.setText("<html>" + player.getName() + "<br>HP: " + player.getHealth() + "</html>");
        monsterStatus.setText("<html>" + monster.getName() + "<br>HP: " + monster.getHealth() + "</html>");
        waveLabel.setText("Wave: " + wave + " Turn: " + turn);
    }

    private void handleAttack() {
        log("== Turn " + turn + " ==");
        player.serang(monster);
        afterPlayerMove();
    }

    private void handleSkill() {
        if (player instanceof RoleWarrior warrior) {
            warrior.rageSkill(turn,monster);
        } else if (player instanceof RolePiercer piercer) {
            piercer.poisonSkill(turn, monster);
        } else if (player instanceof RoleMage mage) {
            mage.stunSkill(turn, monster);
        }
        afterPlayerMove();
    }

    private void handleInventory() {
        String[] itemList = player.getInventory().stream().map(Object::toString).toArray(String[]::new);
        String selectedItem = (String) JOptionPane.showInputDialog(this, "Pilih item:", "Inventory",
                JOptionPane.PLAIN_MESSAGE, null, itemList, itemList[0]);
        if (selectedItem != null) {
            int index = java.util.Arrays.asList(itemList).indexOf(selectedItem);
            player.useItem(index);
            log(player.getName() + " menggunakan " + selectedItem);
        }
        updateStatus();
    }

    private void afterPlayerMove() {
        applySkillEffects();
        if (monster.hidup()) {
            if (!monster.getStunStatus()) {
                monster.serang(player);
                log(monster.getName() + " menyerang " + player.getName());
            } else {
                log(monster.getName() + " terkena stun dan tidak bisa menyerang");
            }
        }

        updateStatus();

        if (!player.hidup()) {
            log(player.getName() + " telah mati. GAME OVER.");
            disableButtons();
        } else if (!monster.hidup()) {
            log(player.getName() + " mengalahkan " + monster.getName());
            player.claimExp(monster);
            monster.itemDrop(player);
            nextWaveButton.setEnabled(true);
            disableButtons();
        }

        turn++;
    }

    private void applySkillEffects() {
        if (player instanceof RolePiercer piercer) {
            piercer.poisonDamage(turn, monster);
        } else if (player instanceof RoleWarrior warrior) {
            warrior.durasiSkill(turn,monster);
        } else if (player instanceof RoleMage mage) {
            if (mage.getStunDuration() >= turn) {
                mage.efekStun(turn, monster);
            } else if (monster.getStunStatus()) {
                log(monster.getName() + " lepas dari stun");
                monster.setStunStatus(false);
            }
            mage.regenMana(5);
        }
    }

    private void nextWave() {
        wave++;
        turn = 1;
        nextWaveButton.setEnabled(false);
        enableButtons();
        spawnMonster();
    }

    private void disableButtons() {
        attackButton.setEnabled(false);
        skillButton.setEnabled(false);
        inventoryButton.setEnabled(false);
    }

    private void enableButtons() {
        attackButton.setEnabled(true);
        skillButton.setEnabled(true);
        inventoryButton.setEnabled(true);
    }

    private void log(String message) {
        logArea.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameGUI().setVisible(true));
    }
}
