package com.GameUI;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.Character.Character;
import com.Character.RoleMage;
import com.Character.RolePiercer;
import com.Character.RoleWarrior;
import com.Monsters.Goblin;
import com.Monsters.Monster;
import com.Monsters.bosMonster;
import com.Monsters.goblinKing;
import com.Item.Item;
import com.Item.Consumable.*;
import com.Item.Equipment.Sword;
import javax.swing.DefaultListModel;


public class app extends javax.swing.JFrame {

    /**
     * Creates new form app
     */
    int wave = 1;
    int turn = 1;
    boolean playerTurn = true;
    Character player=null;
    Monster monster=new Goblin(turn);
    
    public app() {
        initComponents();
        roleSelect.setVisible(false);
        errorRole.setVisible(false);
        battlePanel.setVisible(false);
        
    }
    
    
    
    private void generateMonster(int wave) {
    if (wave ==5) {
        monster = new goblinKing();
    } else {
        monster = new Goblin(wave); // atau jenis monster lain
    }

    namaAreaMonster.setText(monster.getName());
    nameBoxEnemy.setText(monster.getName());
    hpBarMonster.setText(Integer.toString(monster.getHealth()));
    hpBarEnemy.setMaximum(monster.getMaxHp());
    hpBarEnemy.setValue(monster.getHealth());
    if (player instanceof RoleMage) {
                ((RoleMage) player).resetStun();
            }else if (player instanceof RolePiercer) {
                ((RolePiercer) player).resetPoisonStatus();
            }
}
    private void monsterMati(){
        int levelAwal=player.getLevel();
        battleNotif.showMessageDialog(this,monster.getName() +" telah mati");
        
        wave++;
        monster.itemDrop(player);
        player.takeExp(monster);
        int level=player.getLevel();
        levelPane.setText(Integer.toString(level));
        levelInd.setText(Integer.toString(level));
        int darah = player.getHealth();
        hpBar1.setMaximum(player.getMaxHp());
        hpBar1.setValue(player.getHealth());
        hpBar.setText(Integer.toString(darah));
        turnPanel.setText(Integer.toString(turn));
        enemyStatus.setText("");
        updateInventoryList();
    }

private void checkBattleStatus() {
    if (monster.getHealth() <= 0) {
        monsterMati();
        turn=1;
        turnPanel.setText(Integer.toString(turn));
        
        generateMonster(wave);
        if (player instanceof RoleMage) {
                ((RoleMage) player).resetStun();
            }else if (player instanceof RolePiercer) {
                ((RolePiercer) player).resetPoisonStatus();
            }else if (player instanceof RoleWarrior) {
                ((RoleWarrior) player).resetRage(monster);
        }
        
    } else if (player.getHealth() <= 0) {
        battleNotif.showMessageDialog(this, "Game Over!");
        battlePanel.setVisible(false);
        mainMenu.setVisible(true);
        latarUtama.setVisible(true);
        playButton.setVisible(true);
        quitButton.setVisible(true);
    }
}
private void updateInventoryList() {
    if (player != null) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Item item : player.getInventory()) {
            model.addElement(item.getName());
        }
        inventory.setModel(model); // pastikan JList ini ada di GUI
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        battlePanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        namaArea = new javax.swing.JTextArea();
        nameBox = new javax.swing.JLabel();
        nameBoxEnemy = new javax.swing.JLabel();
        hpBar1 = new javax.swing.JProgressBar();
        hpBarEnemy = new javax.swing.JProgressBar();
        levelInd = new javax.swing.JLabel();
        roleArea = new javax.swing.JTextArea();
        hpBar = new javax.swing.JTextArea();
        namaAreaMonster = new javax.swing.JTextArea();
        hpBarMonster = new javax.swing.JTextArea();
        attackButton = new javax.swing.JButton();
        skillButton = new javax.swing.JButton();
        battleNotif = new javax.swing.JOptionPane();
        inventoryButton = new javax.swing.JButton();
        turnPanel = new javax.swing.JTextPane();
        levelPane = new javax.swing.JTextPane();
        enemyStatus = new javax.swing.JTextArea();
        playerStatus = new javax.swing.JTextPane();
        inventory = new javax.swing.JList<>();
        useButton = new javax.swing.JButton();
        hero = new javax.swing.JLabel();
        battleMap = new javax.swing.JLabel();
        roleSelect = new javax.swing.JPanel();
        inputNama = new javax.swing.JTextField();
        menuBack = new javax.swing.JButton();
        roleBox = new javax.swing.JComboBox<>();
        startButton = new javax.swing.JButton();
        errorRole = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        latarUtama = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        battlePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitButton.setBackground(new java.awt.Color(255, 0, 0));
        exitButton.setText("x");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        battlePanel.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        namaArea.setColumns(20);
        namaArea.setRows(5);
        battlePanel.add(namaArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, -1, -1));

        nameBox.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        nameBox.setForeground(new java.awt.Color(0, 0, 0));
        nameBox.setText("jLabel2");
        battlePanel.add(nameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 170, 40));

        nameBoxEnemy.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        nameBoxEnemy.setForeground(new java.awt.Color(255, 255, 255));
        nameBoxEnemy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameBoxEnemy.setText("jLabel2");
        battlePanel.add(nameBoxEnemy, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 170, 40));

        hpBar1.setForeground(new java.awt.Color(244, 9, 9));
        hpBar1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hpBar1StateChanged(evt);
            }
        });
        battlePanel.add(hpBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 210, 20));

        hpBarEnemy.setForeground(new java.awt.Color(244, 9, 9));
        hpBarEnemy.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hpBarEnemyStateChanged(evt);
            }
        });
        battlePanel.add(hpBarEnemy, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 210, 20));

        levelInd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        levelInd.setForeground(new java.awt.Color(255, 255, 255));
        levelInd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        levelInd.setText("1");
        battlePanel.add(levelInd, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 176, 40, 30));

        roleArea.setColumns(20);
        roleArea.setRows(5);
        battlePanel.add(roleArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        hpBar.setColumns(20);
        hpBar.setRows(5);
        battlePanel.add(hpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, -1, -1));

        namaAreaMonster.setColumns(20);
        namaAreaMonster.setRows(5);
        namaAreaMonster.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                namaAreaMonsterAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        battlePanel.add(namaAreaMonster, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 630, -1, -1));

        hpBarMonster.setColumns(20);
        hpBarMonster.setRows(5);
        hpBarMonster.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                hpBarMonsterAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        battlePanel.add(hpBarMonster, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 540, -1, -1));

        attackButton.setText("ATTACK");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });
        battlePanel.add(attackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, -1, 30));

        skillButton.setText("SKILL");
        skillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skillButtonActionPerformed(evt);
            }
        });
        battlePanel.add(skillButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, -1, -1));

        battleNotif.setToolTipText("");
        battleNotif.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                battleNotifAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        battlePanel.add(battleNotif, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        inventoryButton.setText("INVENTORY");
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryButtonActionPerformed(evt);
            }
        });
        battlePanel.add(inventoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, -1, -1));

        turnPanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                turnPanelAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        battlePanel.add(turnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 20, -1));

        levelPane.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                levelPaneAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        battlePanel.add(levelPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        enemyStatus.setColumns(20);
        enemyStatus.setRows(5);
        enemyStatus.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                enemyStatusAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        battlePanel.add(enemyStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, -1, -1));
        battlePanel.add(playerStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 640, 230, 40));

        inventory.setBackground(new java.awt.Color(51, 51, 51));
        inventory.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        inventory.setForeground(new java.awt.Color(255, 255, 255));
        inventory.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        inventory.setToolTipText("");
        battlePanel.add(inventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 100, -1));

        useButton.setText("USE");
        useButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useButtonActionPerformed(evt);
            }
        });
        battlePanel.add(useButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 60, 30));

        hero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/wAtt.gif"))); // NOI18N
        battlePanel.add(hero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 70, 70));

        battleMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/mapnya di rename goblok.png"))); // NOI18N
        battlePanel.add(battleMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(battlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 720));

        roleSelect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputNama.setBackground(new java.awt.Color(255, 255, 255));
        inputNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputNama.setText("Masukan Nama");
        inputNama.setToolTipText("");
        inputNama.setAutoscrolls(false);
        inputNama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputNamaFocusGained(evt);
            }
        });
        inputNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamaActionPerformed(evt);
            }
        });
        roleSelect.add(inputNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 230, 30));

        menuBack.setBackground(new java.awt.Color(255, 0, 0));
        menuBack.setText("BACK");
        menuBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBackActionPerformed(evt);
            }
        });
        roleSelect.add(menuBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 640, 110, 60));

        roleBox.setBackground(new java.awt.Color(153, 51, 0));
        roleBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Role", "Warrior", "Piercer", "Mage" }));
        roleBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        roleBox.setFocusTraversalPolicyProvider(true);
        roleBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleBoxActionPerformed(evt);
            }
        });
        roleSelect.add(roleBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 356, 220, 60));

        startButton.setBackground(new java.awt.Color(153, 51, 0));
        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        roleSelect.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 120, 50));

        errorRole.setBackground(new java.awt.Color(255, 0, 0));
        errorRole.setForeground(new java.awt.Color(255, 255, 255));
        errorRole.setText("Silahkan Pilih Role");
        errorRole.setToolTipText("");
        roleSelect.add(errorRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 230, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/resize 720 blured.png"))); // NOI18N
        jLabel1.setToolTipText("");
        roleSelect.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(roleSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainMenu.setBackground(new java.awt.Color(153, 153, 153));
        mainMenu.setForeground(new java.awt.Color(0, 0, 0));
        mainMenu.setPreferredSize(new java.awt.Dimension(1024, 720));
        mainMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        playButton.setBackground(new java.awt.Color(145, 81, 5));
        playButton.setText("PLAY");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        mainMenu.add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 170, 60));

        quitButton.setBackground(new java.awt.Color(119, 57, 0));
        quitButton.setText("QUIT");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        mainMenu.add(quitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 170, 60));

        latarUtama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/resize 720.png"))); // NOI18N
        mainMenu.add(latarUtama, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(mainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, -1, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        // TODO add your handling code here:
        latarUtama.setVisible(false);
        mainMenu.setVisible(false);
        menuBack.setVisible(true);
        roleSelect.setVisible(true);
    }//GEN-LAST:event_playButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_quitButtonActionPerformed

    private void menuBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBackActionPerformed
        // TODO add your handling code here:
        mainMenu.setVisible(true);
        latarUtama.setVisible(true);
        roleSelect.setVisible(false);
        menuBack.setVisible(false);
    }//GEN-LAST:event_menuBackActionPerformed

    private void inputNamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputNamaFocusGained
        // TODO add your handling code here:
        String name= inputNama.getText();
        if(name.equals("Masukan Nama")){
            inputNama.setText("");
        }
    }//GEN-LAST:event_inputNamaFocusGained

    private void roleBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleBoxActionPerformed
        // TODO add your handling code here:
                
                        String playerRole = (String) roleBox.getSelectedItem();
                switch (playerRole) {
                    case "Warrior":
                        player=new RoleWarrior(inputNama.getText());
                        errorRole.setVisible(false);

                        break;
                    case "Piercer":
                        player= new RolePiercer(inputNama.getText());
                        errorRole.setVisible(false);

                        break;
                    case "Mage":
                        player=new RoleMage(inputNama.getText());
                        errorRole.setVisible(false);

                        break;
                    case "Pilih Role":
                        errorRole.setText("Tolong Pilih Role");
                        errorRole.setVisible(true);
                        break;
                    
                }
    }//GEN-LAST:event_roleBoxActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        inventory.setVisible(false);
        useButton.setVisible(false);
        String role=(String)roleBox.getSelectedItem();
        String nama=inputNama.getText();
        
        if (nama.equals("Masukan Nama")) {
            errorRole.setText("Silahkan Masukan Nama");
            errorRole.setVisible(true);           
        }else{
            if (role.equals("Pilih Role")) {
                errorRole.setVisible(true);
                errorRole.setText("Silahkan Pilih Role");
            }else{
            int darah=player.getHealth();
            battlePanel.setVisible(true);
            exitButton.setVisible(true);
            namaArea.setText(player.getName());
            nameBox.setText(player.getName());
            nameBoxEnemy.setVisible(true);
            nameBoxEnemy.setText(monster.getName());
            hpBarEnemy.setVisible(true);
            hpBarEnemy.setMaximum(monster.getMaxHp());
            hpBarEnemy.setValue(monster.getHealth());
            roleArea.setText(player.getRole());
            levelInd.setVisible(true);
            hpBar.setText(Integer.toString(darah));
            hpBar1.setMaximum(player.getMaxHp());
            hpBar1.setValue(player.getHealth());
            roleSelect.setVisible(false);
            mainMenu.setVisible(false);
            playButton.setVisible(false);
            quitButton.setVisible(false);
            battleNotif.setVisible(false);
            turnPanel.setText(Integer.toString(turn));
            for (int i=0; i<5; i++) {
                player.addItem(new HealingPotion());
            }
            updateInventoryList();
            }
        
        }
        
        
       
    }//GEN-LAST:event_startButtonActionPerformed

    private void inputNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamaActionPerformed
        // TODO add your handling code here:
        player.setName(inputNama.getText());
    }//GEN-LAST:event_inputNamaActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        mainMenu.setVisible(true);
        battlePanel.setVisible(false);
        quitButton.setVisible(true);
        playButton.setVisible(true);
        latarUtama.setVisible(true);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void hpBarMonsterAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_hpBarMonsterAncestorAdded
        // TODO add your handling code here:
        int darah=monster.getHealth();
        hpBarMonster.setText(Integer.toString(darah));
    }//GEN-LAST:event_hpBarMonsterAncestorAdded

    private void namaAreaMonsterAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_namaAreaMonsterAncestorAdded
        // TODO add your handling code here:
        namaAreaMonster.setText(monster.getName());
    }//GEN-LAST:event_namaAreaMonsterAncestorAdded

    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackButtonActionPerformed

        
        if (playerTurn) {
        player.serang(monster);
        hpBarMonster.setText(Integer.toString(monster.getHealth()));
        hpBarEnemy.setMaximum(monster.getMaxHp());
    hpBarEnemy.setValue(monster.getHealth());
        
        int level=player.getLevel();
        levelPane.setText(Integer.toString(level));
        levelInd.setText(Integer.toString(level));
        playerTurn = false;
        checkBattleStatus();
        
        // Delay sedikit agar UI tidak membeku (opsional, bisa pakai Swing Timer)
        Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        // Panggil efek stun di sini
        if (player instanceof RoleMage) {
            ((RoleMage) player).efekStun(turn, monster);
        }else if (player instanceof RolePiercer) {
            ((RolePiercer)player).poisonDamage(turn, monster);
        }else if (player instanceof RoleWarrior) {
            ((RoleWarrior)player).durasiSkill(turn,monster);
        }

        if (monster.getStunStatus()) {
            enemyStatus.setText(monster.getName()+" terkena stun!");
        }else if (monster.getKeracunan()) {
            enemyStatus.setText(monster.getName()+" terkena Racun!");
        }else if (monster.getRageStatus()) {
            playerStatus.setText("sedang mode rage");
            
        }else if (!monster.getRageStatus()) {
            monster.serang(player);
            hpBar.setText(String.valueOf(player.getHealth()));
            hpBar1.setMaximum(player.getMaxHp());
            hpBar1.setValue(player.getHealth());
            playerStatus.setText("");
        }  else {
            monster.serang(player);
            hpBar.setText(String.valueOf(player.getHealth()));
            hpBar1.setMaximum(player.getMaxHp());
            System.out.println(player.getMaxHp() +"/"+ player.getHealth());
            hpBar1.setValue(player.getHealth());
            enemyStatus.setText(""); // Clear jika tidak kena stun
        }
        
        hpBar1.setMaximum(player.getMaxHp());
        hpBar1.setValue(player.getHealth());
        turn++;
        if (player instanceof RoleMage) {
            ((RoleMage)player).regenMana(5);
        }else if (player instanceof RoleWarrior) {
            ((RoleWarrior)player).regenEnergy(5);
                }
        turnPanel.setText(String.valueOf(turn));
        checkBattleStatus();
        playerTurn = true;
        ((Timer) e.getSource()).stop();
    }
});
        timer.setRepeats(false);
        timer.start();
    }
    }//GEN-LAST:event_attackButtonActionPerformed

    private void skillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skillButtonActionPerformed
        // TODO add your handling code here:
        if (playerTurn) {
    if (player instanceof RoleWarrior){
        ((RoleWarrior)player).rageSkill(turn,monster);
        
    } else if(player instanceof RolePiercer){
        ((RolePiercer)player).poisonSkill(turn, monster);
    } else if(player instanceof RoleMage){
        ((RoleMage)player).stunSkill(turn, monster);
    }

    hpBarMonster.setText(Integer.toString(monster.getHealth()));
    hpBarEnemy.setMaximum(monster.getMaxHp());
    hpBarEnemy.setValue(monster.getHealth());
    playerTurn = false;
    checkBattleStatus();

    Timer timer = new Timer(1000, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (monster.getStunStatus()) {
            enemyStatus.setText(monster.getName()+" terkena stun!");
            monster.setStunStatus(false); // stun hanya berlaku 1 giliran
        }else if (monster.getKeracunan()) {
            enemyStatus.setText(monster.getName()+" terkena racun");
            hpBarMonster.setText(Integer.toString(monster.getHealth()));
            monster.serang(player);
            hpBar.setText(Integer.toString(player.getHealth()));
        }else if (monster.getRageStatus()) {
            playerStatus.setText("sedang mode rage");
            monster.serang(player);
            hpBar.setText(Integer.toString(player.getHealth()));
            hpBar1.setMaximum(player.getMaxHp());
            hpBar1.setValue(player.getHealth());
        }else {
            monster.serang(player);
            hpBar.setText(Integer.toString(player.getHealth()));
            hpBar1.setMaximum(player.getMaxHp());
            hpBar1.setValue(player.getHealth());
        }
        turn++;
        
        
        
        if (player instanceof RoleMage) {
                        ((RoleMage)player).regenMana(5);
                    }else if (player instanceof RoleWarrior) {
                    ((RoleWarrior)player).regenEnergy(5);
                }
        turnPanel.setText(Integer.toString(turn));
        checkBattleStatus();
        playerTurn = true;
        ((Timer)e.getSource()).stop(); // hanya sekali
    }
});

    timer.setRepeats(false);
    timer.start();
    }
    }//GEN-LAST:event_skillButtonActionPerformed

    private void battleNotifAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_battleNotifAncestorAdded
        // TODO add your handling code here:
        int level=player.getLevel();
        levelPane.setText(Integer.toString(level));
        levelInd.setText(Integer.toString(level));
        int darah = player.getHealth();
        hpBar.setText(Integer.toString(darah));
    }//GEN-LAST:event_battleNotifAncestorAdded

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        // TODO add your handling code here:
        inventory.setVisible(true);
        useButton.setVisible(true);
        inventoryButton.setVisible(false);
    }//GEN-LAST:event_inventoryButtonActionPerformed

    private void levelPaneAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_levelPaneAncestorAdded
        // TODO add your handling code here:
        int level=player.getLevel();
        levelPane.setText(Integer.toString(level));
        levelInd.setText(Integer.toString(level));
    }//GEN-LAST:event_levelPaneAncestorAdded

    private void turnPanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_turnPanelAncestorAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_turnPanelAncestorAdded

    private void enemyStatusAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_enemyStatusAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_enemyStatusAncestorAdded

    private void useButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useButtonActionPerformed
        // TODO add your handling code here:
          int selectedIndex = inventory.getSelectedIndex();
    if (selectedIndex != -1 && player != null) {
        Item selectedItem = player.getInventory().get(selectedIndex);
        player.use(selectedItem); // pakai item
        player.getInventory().remove(selectedIndex); // hapus dari list
        updateInventoryList(); 
        hpBar.setText(Integer.toString(player.getHealth()));
        useButton.setVisible(false);
        inventory.setVisible(false);
        inventoryButton.setVisible(true);
        
        playerTurn = false;
        checkBattleStatus();
        
        Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        if (monster.getStunStatus()) {
            enemyStatus.setText(monster.getName()+" terkena stun!");
            monster.setStunStatus(false); // stun hanya berlaku 1 giliran
        }else if (monster.getKeracunan()) {
            enemyStatus.setText(monster.getName()+" terkena racun");
            hpBarMonster.setText(Integer.toString(monster.getHealth()));
            monster.serang(player);
            hpBar.setText(Integer.toString(player.getHealth()));
        }else if (monster.getRageStatus()) {
            playerStatus.setText("sedang mode rage");
            monster.serang(player);
            hpBar.setText(Integer.toString(player.getHealth()));
            hpBar1.setMaximum(player.getMaxHp());
            hpBar1.setValue(player.getHealth());
        }else {
            monster.serang(player);
            hpBar.setText(Integer.toString(player.getHealth()));
            hpBar1.setMaximum(player.getMaxHp());
            hpBar1.setValue(player.getHealth());
        }
        turn++;
        
        
        
        if (player instanceof RoleMage) {
                        ((RoleMage)player).regenMana(5);
                    }else if (player instanceof RoleWarrior) {
                    ((RoleWarrior)player).regenEnergy(5);
                }
        turnPanel.setText(Integer.toString(turn));
        checkBattleStatus();
        playerTurn = true;
        ((Timer)e.getSource()).stop(); // hanya sekali
    }
});
        timer.setRepeats(false);
        timer.start();
        
    }else{
        useButton.setVisible(false);
        inventory.setVisible(false);
        inventoryButton.setVisible(true);
    }
    
    
    }//GEN-LAST:event_useButtonActionPerformed

    private void hpBar1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hpBar1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_hpBar1StateChanged

    private void hpBarEnemyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hpBarEnemyStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_hpBarEnemyStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new app().setVisible(true);
                
            }
                            

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attackButton;
    private javax.swing.JLabel battleMap;
    private javax.swing.JOptionPane battleNotif;
    private javax.swing.JPanel battlePanel;
    private javax.swing.JTextArea enemyStatus;
    private javax.swing.JTextPane errorRole;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel hero;
    private javax.swing.JTextArea hpBar;
    private javax.swing.JProgressBar hpBar1;
    private javax.swing.JProgressBar hpBarEnemy;
    private javax.swing.JTextArea hpBarMonster;
    private javax.swing.JTextField inputNama;
    private javax.swing.JList<String> inventory;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel latarUtama;
    private javax.swing.JLabel levelInd;
    private javax.swing.JTextPane levelPane;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JButton menuBack;
    private javax.swing.JTextArea namaArea;
    private javax.swing.JTextArea namaAreaMonster;
    private javax.swing.JLabel nameBox;
    private javax.swing.JLabel nameBoxEnemy;
    private javax.swing.JButton playButton;
    private javax.swing.JTextPane playerStatus;
    private javax.swing.JButton quitButton;
    private javax.swing.JTextArea roleArea;
    private javax.swing.JComboBox<String> roleBox;
    private javax.swing.JPanel roleSelect;
    private javax.swing.JButton skillButton;
    private javax.swing.JButton startButton;
    private javax.swing.JTextPane turnPanel;
    private javax.swing.JButton useButton;
    // End of variables declaration//GEN-END:variables
}
