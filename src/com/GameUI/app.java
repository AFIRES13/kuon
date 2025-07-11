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
import com.Monsters.fireDemon;
import com.Item.Item;
import com.Item.Consumable.*;
import com.Item.Equipment.Sword;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class app extends javax.swing.JFrame {

    /**
     * Creates new form app
     */
    int wave = 1;
    int turn = 1;
    boolean playerTurn = true;
    Character player=null;
    Monster monster=new Goblin(turn);
    ImageIcon playerIddle=null;
    ImageIcon playerAtt=null;
    ImageIcon playerSkill=null;
    ImageIcon monsterIddle=null;
    ImageIcon monsterAtt=null;
    ImageIcon playerEfek=null;
    ImageIcon playerHit=null;
    ImageIcon monsterPoisoned=null;
    ImageIcon monsterStuned=null;
    ImageIcon monsterHit=null;
    ImageIcon monsterAttPoisoned=null;
    ImageIcon monsterStunedHit=null;
    ImageIcon playerDeath=null;
    ImageIcon monsterPoisonedHit=null;
    ImageIcon monsterIcon=null;
    ImageIcon playerIcon=null;
    
    
    
    //gobllin assets
    ImageIcon goblinIddle=new ImageIcon(getClass().getResource("Goblin-IDLE.gif"));
    ImageIcon goblinAtt=new ImageIcon(getClass().getResource("Goblin-ATTACK.gif"));
    ImageIcon goblinPoisoned=new ImageIcon(getClass().getResource("Goblin-RACUN.gif"));
    ImageIcon goblinStuned=new ImageIcon(getClass().getResource("Goblin-STUN.png"));
    ImageIcon goblinHit=new ImageIcon(getClass().getResource("Goblin-HIT.gif"));
    ImageIcon goblinAttPoisoned=new ImageIcon(getClass().getResource("Goblin-RACUN-ATT.gif"));
    ImageIcon goblinStunedHit=new ImageIcon(getClass().getResource("Goblin-STUN-GETER.gif"));
    ImageIcon goblinPoisonedHit=new ImageIcon(getClass().getResource("Goblin-HIT-RACUN.gif"));
    ImageIcon goblinIcon=new ImageIcon(getClass().getResource("Goblin-ICON.gif"));
    
    //boss assets
    ImageIcon bossIddle=new ImageIcon(getClass().getResource("Boss-IDLE.gif"));
    ImageIcon bossAtt=new ImageIcon (getClass().getResource("Boss-ATTACK.gif"));
    ImageIcon bossHit=new ImageIcon(getClass().getResource("Boss-HIT.gif"));
    ImageIcon bossStuned=new ImageIcon(getClass().getResource("Boss-STUN-BEKU.png"));
    ImageIcon bossStunedHit=new ImageIcon(getClass().getResource("Boss-STUN-BEKU-GETER.gif"));
    ImageIcon bossPoisoned=new ImageIcon(getClass().getResource("Boss-IDLE-RACUN.gif"));
    ImageIcon bossPoisonedHit=new ImageIcon(getClass().getResource("Boss-HIT-RACUN.gif"));
    ImageIcon bossAttPoisoned=new ImageIcon(getClass().getResource("Boss-ATTACK-RACUN.gif"));
    ImageIcon bossIcon=new ImageIcon(getClass().getResource("Boss-PROFILE.gif"));
    
    //piercer assets
    ImageIcon piercerIddle=new ImageIcon(getClass().getResource("Piercer-IDLE.gif"));
    ImageIcon piercerAtt=new ImageIcon(getClass().getResource("Piercer-ATTACK.gif"));
    ImageIcon piercerSkill=new ImageIcon(getClass().getResource("Piercer-CAST.gif"));
    ImageIcon piercerEfek=new ImageIcon(getClass().getResource("Piercer-SPELL.gif"));
    ImageIcon piercerHit=new ImageIcon(getClass().getResource("Piercer-HIT.gif"));
    ImageIcon piercerDeath=new ImageIcon(getClass().getResource("Piercer-DEATH.gif"));
    ImageIcon piercerIcon=new ImageIcon(getClass().getResource("Piercer-PROFILE.gif"));
    //mage assets
    ImageIcon mageIddle=new ImageIcon (getClass().getResource("Mage-IDLE.gif"));
    ImageIcon mageAtt=new ImageIcon (getClass().getResource("Mage-ATTACK.gif"));
    ImageIcon mageSkill=new ImageIcon (getClass().getResource("Mage-SKILL.gif"));
    ImageIcon mageEfek=new ImageIcon (getClass().getResource("Mage-SPELL.gif"));
    ImageIcon mageHit=new ImageIcon (getClass().getResource("Mage-HIT.gif"));
    ImageIcon mageDeath=new ImageIcon(getClass().getResource("Mage-DEATH.gif"));
    ImageIcon mageIcon=new ImageIcon(getClass().getResource("Mage-PROFILE.gif"));
    //warrior assets
    ImageIcon warriorIddle=new ImageIcon (getClass().getResource("Warrior-IDLE.gif"));
    ImageIcon warriorAtt=new ImageIcon (getClass().getResource("Warrior-ATTACK.gif"));
    ImageIcon warriorSkill=new ImageIcon (getClass().getResource("Warrior-SKILL.gif"));
    ImageIcon warriorHit=new ImageIcon (getClass().getResource("Warrior-HIT.gif"));
    ImageIcon warriorAttSkill=new ImageIcon(getClass().getResource("Warrior-ATTACK-LIGHTNING.gif"));
    ImageIcon warriorIddleSkill=new ImageIcon(getClass().getResource("Warrior-IDLE-LIGHTNING.gif"));
    ImageIcon warriorHitSkill=new ImageIcon(getClass().getResource("Warrior-HIT-LIGHTING.gif"));
    ImageIcon warriorDeath=new ImageIcon(getClass().getResource("Warrior-DEATH.gif"));
    ImageIcon warriorIcon=new ImageIcon(getClass().getResource("Warrior-PROFILE.gif"));
    
    public app() {
        initComponents();
        aboutPanel.setVisible(false);
        exitButton2.setVisible(false);
        roleSelect.setVisible(false);
        errorRole.setVisible(false);
        battlePanel.setVisible(false);
        piercerDesc.setText("Piercer\n\nkarakter yg memiliki spesial stat berupa penetration yang mampu menembus defense lawan dan juga memiliki skill yang bisa memberikan racun kepada musuh");
        mageDesc.setText("Mage\n\nkarakter yang mampu membuat musuh tidak bergerak selama beberapa turn dengan skill nya");
        warriorDesc.setText("Warrior\n\nmerupakan karakter dengan stat spesial berupa stregth yang mempu meningkatkan attack beserta defense nya");
    }
    
    
    
    private void generateMonster(int wave) {
    if (wave ==5) {
        monster = new fireDemon();
        monsterIddle=bossIddle;
        monsterAtt=bossAtt;
        monsterStuned=bossStuned;
        monsterHit=bossHit;
        monsterStunedHit=bossStunedHit;
        monsterAttPoisoned=bossAttPoisoned;
        monsterPoisoned=bossPoisoned;
        monsterPoisonedHit=bossPoisonedHit;       
        monsterIcon=bossIcon;
    } else {
        monster = new Goblin(wave); 
        monsterIddle=goblinIddle;
        monsterAtt=goblinAtt;
        monsterPoisoned=goblinPoisoned;
        monsterStuned=goblinStuned;
        monsterHit=goblinHit;
        monsterPoisoned=goblinPoisoned;
        monsterAttPoisoned=goblinAttPoisoned;
        monsterStunedHit=goblinStunedHit;
        monsterPoisonedHit=goblinPoisonedHit;
        monsterIcon=goblinIcon;
    }
    
    nameBoxEnemy.setText(monster.getName());
    hpBarEnemy.setMaximum(monster.getMaxHp());
    hpBarEnemy.setValue(monster.getHealth());
    if (player instanceof RoleMage) {
                ((RoleMage) player).resetStun();
            }else if (player instanceof RolePiercer) {
                ((RolePiercer) player).resetPoisonStatus();
            }
}
    private void monsterMati(){
      
        battleNotif.showMessageDialog(this,monster.getName() +" telah mati");
        
        wave++;
        monster.itemDrop(player);
        player.takeExp(monster);
        int level=player.getLevel();
        playerChar.setIcon(playerIddle);
        levelInd.setText(Integer.toString(level));
        updateHpBar();
        updateSBar();
        turnNumber.setText(Integer.toString(turn));
        enemyStatus1.setText("");
        statBox.setText(player.showStatus());
        statBoxMonster.setText(monster.showStatus());
        iconMonster.setIcon(monsterIcon);
        updateInventoryList();
    }

private void checkBattleStatus() {
    if (monster.mati()) {
        monsterMati();
        turn=1;
        turnNumber.setText("TURN "+Integer.toString(turn));
        playerChar.setIcon(playerIddle);
        iconMonster.setIcon(monsterIcon);
        generateMonster(wave);
        if (player instanceof RoleMage) {
                ((RoleMage) player).resetStun();
            }else if (player instanceof RolePiercer) {
                ((RolePiercer) player).resetPoisonStatus();
            }else if (player instanceof RoleWarrior) {
                ((RoleWarrior) player).resetRage(monster);
        }
        
    } else if (player.mati()) {
        battleNotif.showMessageDialog(this, player.getName()+"Telah Mati, Game Over!");
        playerChar.setIcon(playerDeath);
        battlePanel.setVisible(false);
        mainMenu.setVisible(true);
        latarUtama.setVisible(true);
        playButton.setVisible(true);
        quitButton.setVisible(true);
        aboutButton.setVisible(true);
        resetGame();
        
    }
}
private void updateInventoryList() {
    if (player != null) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Item item : player.getInventory()) {
            model.addElement(item.getName());
        }
        inventory.setModel(model);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        battlePanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        nameBox = new javax.swing.JLabel();
        nameBoxEnemy = new javax.swing.JLabel();
        hpBar1 = new javax.swing.JProgressBar();
        hpBarEnemy = new javax.swing.JProgressBar();
        spesialBar = new javax.swing.JProgressBar();
        levelInd = new javax.swing.JLabel();
        iconPlayer = new javax.swing.JLabel();
        iconMonster = new javax.swing.JLabel();
        roleArea = new javax.swing.JLabel();
        attackButton = new javax.swing.JButton();
        skillButton = new javax.swing.JButton();
        battleNotif = new javax.swing.JOptionPane();
        inventoryButton = new javax.swing.JButton();
        useButton = new javax.swing.JButton();
        charArea1 = new javax.swing.JLabel();
        charArea = new javax.swing.JLabel();
        statBox = new javax.swing.JTextPane();
        statBoxMonster = new javax.swing.JTextPane();
        skillEfek = new javax.swing.JLabel();
        turnNumber = new javax.swing.JLabel();
        skilDesc = new javax.swing.JTextPane();
        inventoryScroll = new javax.swing.JScrollPane();
        inventory = new javax.swing.JList<>();
        enemyStatus2 = new javax.swing.JLabel();
        enemyStatus1 = new javax.swing.JLabel();
        playerStatus2 = new javax.swing.JLabel();
        playerStatus1 = new javax.swing.JLabel();
        monsterChar = new javax.swing.JLabel();
        playerChar = new javax.swing.JLabel();
        battleMap = new javax.swing.JLabel();
        roleSelect = new javax.swing.JPanel();
        inputNama = new javax.swing.JTextField();
        menuBack = new javax.swing.JButton();
        roleBox = new javax.swing.JComboBox<>();
        startButton = new javax.swing.JButton();
        warriorDesc = new javax.swing.JTextPane();
        piercerDesc = new javax.swing.JTextPane();
        mageDesc = new javax.swing.JTextPane();
        errorRole = new javax.swing.JTextPane();
        warriorArea = new javax.swing.JLabel();
        mageArea = new javax.swing.JLabel();
        piercerArea = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mainMenu = new javax.swing.JPanel();
        aboutPanel = new javax.swing.JLabel();
        exitButton2 = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        latarUtama = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 720));
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
        battlePanel.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        nameBox.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nameBox.setForeground(new java.awt.Color(0, 0, 0));
        nameBox.setText("jLabel2");
        battlePanel.add(nameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 170, 40));

        nameBoxEnemy.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nameBoxEnemy.setForeground(new java.awt.Color(255, 255, 255));
        nameBoxEnemy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameBoxEnemy.setText("jLabel2");
        battlePanel.add(nameBoxEnemy, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 540, 170, 40));

        hpBar1.setForeground(new java.awt.Color(237, 0, 0));
        hpBar1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hpBar1StateChanged(evt);
            }
        });
        battlePanel.add(hpBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 180, 30));

        hpBarEnemy.setForeground(new java.awt.Color(244, 9, 9));
        hpBarEnemy.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hpBarEnemyStateChanged(evt);
            }
        });
        battlePanel.add(hpBarEnemy, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 580, 210, 30));

        spesialBar.setForeground(new java.awt.Color(255, 255, 51));
        battlePanel.add(spesialBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 610, 120, 20));

        levelInd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        levelInd.setForeground(new java.awt.Color(255, 255, 255));
        levelInd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        levelInd.setText("1");
        battlePanel.add(levelInd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 590, 20, 20));

        iconPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/Goblin-ICON.gif"))); // NOI18N
        battlePanel.add(iconPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 40, -1));

        iconMonster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/Goblin-ICON.gif"))); // NOI18N
        battlePanel.add(iconMonster, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 570, 40, -1));

        roleArea.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        roleArea.setForeground(new java.awt.Color(0, 0, 0));
        roleArea.setText("jLabel2");
        battlePanel.add(roleArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 610, -1, 20));

        attackButton.setText("ATTACK");
        attackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackButtonActionPerformed(evt);
            }
        });
        battlePanel.add(attackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 650, 100, 30));

        skillButton.setText("SKILL");
        skillButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                skillButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                skillButtonMouseExited(evt);
            }
        });
        skillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skillButtonActionPerformed(evt);
            }
        });
        battlePanel.add(skillButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 610, 100, -1));

        battleNotif.setToolTipText("");
        battleNotif.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        battleNotif.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                battleNotifAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        battlePanel.add(battleNotif, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        inventoryButton.setText("INVENTORY");
        inventoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryButtonActionPerformed(evt);
            }
        });
        battlePanel.add(inventoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, -1, -1));

        useButton.setText("CANCEL");
        useButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useButtonActionPerformed(evt);
            }
        });
        battlePanel.add(useButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 660, 80, 30));

        charArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                charArea1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                charArea1MouseExited(evt);
            }
        });
        battlePanel.add(charArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 140, 150));

        charArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                charAreaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                charAreaMouseExited(evt);
            }
        });
        battlePanel.add(charArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 140, 150));

        statBox.setBackground(new java.awt.Color(30, 30, 30));
        statBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        statBox.setForeground(new java.awt.Color(255, 255, 255));
        statBox.setText("qsdw");
        battlePanel.add(statBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 200, 270));

        statBoxMonster.setBackground(new java.awt.Color(30, 30, 30));
        statBoxMonster.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        statBoxMonster.setForeground(new java.awt.Color(255, 255, 255));
        statBoxMonster.setText("qsdw");
        battlePanel.add(statBoxMonster, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 190, 270));

        skillEfek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/Mage-SPELL.gif"))); // NOI18N
        battlePanel.add(skillEfek, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, 340));

        turnNumber.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        turnNumber.setForeground(new java.awt.Color(255, 255, 51));
        turnNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turnNumber.setText("TURN 1");
        battlePanel.add(turnNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 240, 70));

        skilDesc.setBackground(new java.awt.Color(30, 30, 30));
        skilDesc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        skilDesc.setForeground(new java.awt.Color(255, 255, 255));
        battlePanel.add(skilDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 110, 150));

        inventory.setBackground(new java.awt.Color(51, 51, 51));
        inventory.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        inventory.setForeground(new java.awt.Color(255, 255, 255));
        inventory.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        inventory.setToolTipText("");
        inventory.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                inventoryValueChanged(evt);
            }
        });
        inventoryScroll.setViewportView(inventory);

        battlePanel.add(inventoryScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, -1, -1));

        enemyStatus2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        enemyStatus2.setForeground(new java.awt.Color(255, 255, 51));
        enemyStatus2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        battlePanel.add(enemyStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 390, 20));

        enemyStatus1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        enemyStatus1.setForeground(new java.awt.Color(255, 255, 51));
        enemyStatus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        battlePanel.add(enemyStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 390, -1));

        playerStatus2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        playerStatus2.setForeground(new java.awt.Color(255, 255, 51));
        playerStatus2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        battlePanel.add(playerStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 390, 20));

        playerStatus1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        playerStatus1.setForeground(new java.awt.Color(255, 255, 51));
        playerStatus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        battlePanel.add(playerStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 390, -1));

        monsterChar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/Boss-HIT.gif"))); // NOI18N
        monsterChar.setToolTipText("");
        battlePanel.add(monsterChar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 520, 520));

        playerChar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/Warrior-ATTACK-LIGHTNING.gif"))); // NOI18N
        battlePanel.add(playerChar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 670, -1));

        battleMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/map.png"))); // NOI18N
        battlePanel.add(battleMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(battlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 720));

        roleSelect.setName(""); // NOI18N
        roleSelect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputNama.setBackground(new java.awt.Color(255, 255, 255));
        inputNama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inputNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputNama.setText("Masukan Nama");
        inputNama.setToolTipText("");
        inputNama.setAutoscrolls(false);
        inputNama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputNamaFocusGained(evt);
            }
        });
        roleSelect.add(inputNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 230, 30));

        menuBack.setBackground(new java.awt.Color(255, 0, 0));
        menuBack.setText("BACK");
        menuBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBackActionPerformed(evt);
            }
        });
        roleSelect.add(menuBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 630, 110, 60));

        roleBox.setBackground(new java.awt.Color(153, 51, 0));
        roleBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roleBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Role", "Warrior", "Piercer", "Mage" }));
        roleBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        roleBox.setFocusTraversalPolicyProvider(true);
        roleBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleBoxActionPerformed(evt);
            }
        });
        roleSelect.add(roleBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 570, 220, 60));

        startButton.setBackground(new java.awt.Color(153, 51, 0));
        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        roleSelect.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 650, 120, 50));

        warriorDesc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roleSelect.add(warriorDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 150, 220));

        piercerDesc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        piercerDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                piercerDescMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                piercerDescMouseExited(evt);
            }
        });
        roleSelect.add(piercerDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 150, 220));

        mageDesc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roleSelect.add(mageDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, 150, 220));

        errorRole.setBackground(new java.awt.Color(255, 0, 0));
        errorRole.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        errorRole.setForeground(new java.awt.Color(255, 255, 255));
        errorRole.setText("Silahkan Pilih Role");
        errorRole.setToolTipText("");
        roleSelect.add(errorRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 230, 30));

        warriorArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                warriorAreaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                warriorAreaMouseExited(evt);
            }
        });
        roleSelect.add(warriorArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 110, 180));

        mageArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mageAreaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mageAreaMouseExited(evt);
            }
        });
        roleSelect.add(mageArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 110, 180));

        piercerArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                piercerAreaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                piercerAreaMouseExited(evt);
            }
        });
        roleSelect.add(piercerArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 110, 180));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/pilih role.gif"))); // NOI18N
        jLabel1.setToolTipText("");
        roleSelect.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(roleSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainMenu.setBackground(new java.awt.Color(153, 153, 153));
        mainMenu.setForeground(new java.awt.Color(0, 0, 0));
        mainMenu.setPreferredSize(new java.awt.Dimension(1024, 720));
        mainMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aboutPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/about.gif"))); // NOI18N
        mainMenu.add(aboutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        exitButton2.setBackground(new java.awt.Color(255, 0, 0));
        exitButton2.setForeground(new java.awt.Color(255, 255, 255));
        exitButton2.setText("X");
        exitButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton2ActionPerformed(evt);
            }
        });
        mainMenu.add(exitButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        playButton.setBackground(new java.awt.Color(145, 81, 5));
        playButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        playButton.setText("PLAY");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        mainMenu.add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 170, 60));

        aboutButton.setBackground(new java.awt.Color(119, 57, 0));
        aboutButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        aboutButton.setText("ABOUT");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });
        mainMenu.add(aboutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 170, 60));

        quitButton.setBackground(new java.awt.Color(119, 57, 0));
        quitButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        quitButton.setText("QUIT");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        mainMenu.add(quitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 170, 60));

        latarUtama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GameUI/tampilan depan (1024 x 720 px).gif"))); // NOI18N
        mainMenu.add(latarUtama, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

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
        mageDesc.setVisible(false);
        warriorDesc.setVisible(false);
        piercerDesc.setVisible(false);
        aboutButton.setVisible(false);
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
        aboutButton.setVisible(true);
        
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
                        spesialBar.setMaximum(player.getMaxEnergy());
                        spesialBar.setValue(player.getEnergy());
                        playerSkill=warriorSkill;
                        skilDesc.setText("RAGE\n\nmeningkatkan Strength 2x selama 3 turn");
                        playerHit=warriorHit;
                        errorRole.setVisible(false);
                        playerDeath=warriorDeath;
                        playerIcon=warriorIcon;
                        if (monster.getRageStatus()) {
                            playerIddle=warriorIddleSkill;
                            playerAtt=warriorAttSkill;
                            playerHit=warriorHitSkill;
                        }else{
                            playerAtt=warriorAtt;
                            playerIddle=warriorIddle;
                            playerHit=warriorHit;
                        }
                        
                        break;
                    case "Piercer":
                        player= new RolePiercer(inputNama.getText());
                        playerIddle=piercerIddle;
                        playerAtt=piercerAtt;
                        playerSkill=piercerSkill;
                        playerEfek=piercerEfek;
                        playerHit=piercerHit;
                        playerDeath=piercerDeath;
                        playerIcon=piercerIcon;
                        skilDesc.setText("POISON\n\nMenerapkan racun kepada musuh selama 3 turn");
                        errorRole.setVisible(false);
                        

                        break;
                    case "Mage":
                        player=new RoleMage(inputNama.getText());
                        playerIddle=mageIddle;
                        playerAtt=mageAtt;
                        spesialBar.setMaximum(player.getMaxMana());
                        spesialBar.setValue(player.getMana());
                        playerSkill=mageSkill;
                        playerDeath=mageDeath;
                        playerEfek=mageEfek;
                        playerHit=mageHit;
                        playerIcon=mageIcon;
                        skilDesc.setText("STUN\n\nMembuat musuh tidak bergerak selama turn tertentu\n\ndurasi turn = 2 + level");
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
                
                if (wave==1) {
                    monsterIddle=goblinIddle;
                    monsterAtt=goblinAtt;
                    monsterPoisoned=goblinPoisoned;
                    monsterStuned=goblinStuned;
                    monsterHit=goblinHit;
                    monsterAttPoisoned=goblinAttPoisoned;
                    monsterStunedHit=goblinStunedHit;
                    monsterPoisonedHit=goblinPoisonedHit;
                }
                if (role.equals("Piercer")) {
                    spesialBar.setVisible(false);
                }else if (role.equals("Pilih Role")) {
                    spesialBar.setVisible(false);
                }else{
                    spesialBar.setVisible(true);
                    spesialBar.setMaximum(player.getMaxMana());
                        spesialBar.setValue(player.getMana());
                }
                
                skillEfek.setVisible(false);
                skillEfek.setIcon(playerEfek);
                statBox.setText(player.showStatus());
                statBoxMonster.setText(monster.showStatus());
                statBoxMonster.setVisible(false);
                statBox.setVisible(false);
                skilDesc.setVisible(false);
                playerChar.setIcon(playerIddle);
                inventoryScroll.setVisible(false);
                playerChar.setVisible(true);
                monsterChar.setVisible(true);
                monsterChar.setIcon(monsterIddle);
                battlePanel.setVisible(true);
                exitButton.setVisible(true);
                nameBox.setText(player.getName());
                nameBoxEnemy.setVisible(true);
                nameBoxEnemy.setText(monster.getName());
                hpBarEnemy.setVisible(true);
                hpBarEnemy.setMaximum(monster.getMaxHp());
                hpBarEnemy.setValue(monster.getHealth());
                roleArea.setText(player.getRole());
                levelInd.setVisible(true);
                iconMonster.setVisible(true);
                roleSelect.setVisible(false);
                mainMenu.setVisible(false);
                playButton.setVisible(false);
                quitButton.setVisible(false);
                battleNotif.setVisible(false);
                iconPlayer.setVisible(true);
                iconPlayer.setIcon(playerIcon);
                updateHpBar();
                turnNumber.setText("TURN "+Integer.toString(turn));
                for (int i=0; i<5; i++) {
                    player.addItem(new HealingPotion());
                }
                updateInventoryList();
            }
        
        }
    }//GEN-LAST:event_startButtonActionPerformed
    private void warriorUpdtEfek(){
        if (monster.getRageStatus()) {
                            playerIddle=warriorIddleSkill;
                            playerAtt=warriorAttSkill;
                            playerHit=warriorHitSkill;
                        }else{
                            playerAtt=warriorAtt;
                            playerIddle=warriorIddle;
                            playerHit=warriorHit;
                        }
    }
    private void updateHpBar(){
        
        hpBar1.setBackground(Color.gray);
        hpBar1.setForeground(Color.red);
        hpBar1.setMaximum(player.getMaxHp());
        hpBar1.setValue(player.getHealth());
        
        
    }
    
    private void updateSBar(){
        
        spesialBar.setBackground(Color.gray);
        if (player instanceof RoleMage) {
            spesialBar.setMaximum(player.getMaxMana());
            spesialBar.setValue(player.getMana());
            spesialBar.setForeground(Color.blue);
        }else if (player instanceof RoleWarrior) {
            spesialBar.setMaximum(player.getMaxEnergy());
            spesialBar.setValue(player.getEnergy());
            spesialBar.setForeground(Color.yellow);
        }else{
            spesialBar.setVisible(false);
        }
    }
    
    
    private void monsterCounterAttack() {
    // Efek spesial per role
        if (player instanceof RoleWarrior) {
            warriorUpdtEfek();
        }
    if (player instanceof RoleMage) {
        ((RoleMage) player).efekStun(turn, monster);
    } else if (player instanceof RolePiercer) {
        ((RolePiercer) player).poisonDamage(turn, monster);
    } else if (player instanceof RoleWarrior) {
        ((RoleWarrior) player).durasiSkill(turn, monster);
    }

    if (monster.getStunStatus()) {
        enemyStatus1.setText(monster.getName() + " terkena stun!");
        monsterChar.setIcon(monsterStuned);
        playerChar.setIcon(playerIddle);
    } else {
        
        monster.serang(player);
        if (monster.getKeracunan()) {
            monsterChar.setIcon(monsterAttPoisoned);
        }else{
            monsterChar.setIcon(monsterAtt);
        }
        
        if (player.mati()) {
            playerChar.setIcon(playerDeath);
        }else{
            playerChar.setIcon(playerHit);
        }

        // Timer animasi balik ke idle
        Timer returnToIdle = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
//                monsterChar.setIcon(monsterIddle);
                if (monster.getKeracunan()) {
                    monsterChar.setIcon(monsterPoisoned);
                }else{
                    monsterChar.setIcon(monsterIddle);
                }
                updateHpBar();
                playerChar.setIcon(playerIddle);
                ((Timer) e2.getSource()).stop();
            }
        });
        statBox.setText(player.showStatus());
        statBoxMonster.setText(monster.showStatus());
        returnToIdle.setRepeats(false);
        returnToIdle.start();

        

        if (monster.getKeracunan()) {
            
            enemyStatus1.setText(monster.getName() + " terkena racun");
        } else {
            
            enemyStatus1.setText("");
        }

        playerStatus1.setText(monster.getRageStatus() ? "sedang mode rage" : "");
    }

    turn++;
    if (player instanceof RoleMage) {
        ((RoleMage) player).regenMana(5);
    } else if (player instanceof RoleWarrior) {
        ((RoleWarrior) player).regenEnergy(5);
    }

    turnNumber.setText("TURN "+String.valueOf(turn));
    checkBattleStatus();
    playerTurn = true;
}
    
    private void resetGame() {
    // Reset variabel game
    wave = 1;
    turn = 1;
    playerTurn = true;
    player = null;
    monster = new Goblin(turn);

    // Reset icon
    playerIddle = null;
    playerAtt = null;
    playerSkill = null;
    playerEfek = null;
    playerHit = null;
    monsterIddle = goblinIddle;
    monsterAtt = goblinAtt;

    // Reset tampilan GUI
    latarUtama.setVisible(true);
    mainMenu.setVisible(true);
    playButton.setVisible(true);
    quitButton.setVisible(true);
    roleSelect.setVisible(false);
    battlePanel.setVisible(false);
    battleNotif.setVisible(false);
    statBox.setText("");
    statBoxMonster.setText("");
    inventory.setVisible(false);
    inventoryScroll.setVisible(false);
    turnNumber.setText("1");
    levelInd.setText("1");
    spesialBar.setValue(0);
    nameBox.setText("");
    nameBoxEnemy.setText("");
    playerChar.setIcon(null);
    aboutButton.setVisible(true);
    monsterChar.setIcon(null);
    iconMonster.setVisible(false);
    monsterIcon=null;
    // Reset input
    inputNama.setText("Masukan Nama");
    roleBox.setSelectedIndex(0);
}
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_exitButtonActionPerformed

    
    
    private void attackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackButtonActionPerformed
        updateSBar();
        
        monsterChar.setVisible(true);
        if (playerTurn) {
        player.serang(monster);
        
        hpBarEnemy.setMaximum(monster.getMaxHp());
        hpBarEnemy.setValue(monster.getHealth());
        playerChar.setIcon(playerAtt);
            if (monster instanceof fireDemon) {
                monster.skill();
                enemyStatus2.setText(monster.getSkillStatus());
            }
            
        
            if (monster.getStunStatus()) {
                monsterChar.setIcon(monsterStunedHit);
            }else if (monster.getKeracunan()) {
                monsterChar.setIcon(monsterPoisonedHit);
            }
            else{
                monsterChar.setIcon(monsterHit);
            }
        int level=player.getLevel();
        levelInd.setText(Integer.toString(level));
        playerTurn = false;
        checkBattleStatus();
        iconMonster.setIcon(monsterIcon);
        // Delay sedikit agar UI tidak membeku (opsional, bisa pakai Swing Timer)
        Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        monsterCounterAttack();
        ((Timer) e.getSource()).stop();
    }
});
         if (player instanceof RoleWarrior) {
            warriorUpdtEfek();
        }
        statBoxMonster.setText(monster.showStatus());
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
        skillEfek.setVisible(true);
    } else if(player instanceof RoleMage){
        skillEfek.setVisible(true);
        monsterChar.setIcon(monsterStuned);
        ((RoleMage)player).stunSkill(turn, monster);
        
    }
    
    playerStatus2.setText(player.getStatus());
    playerStatus2.setVisible(true);
    Timer timer2=new Timer(5000,new ActionListener(){
       public void actionPerformed(ActionEvent e){
           playerStatus2.setVisible(false);
       } 
    });
    timer2.setRepeats(false);
    timer2.start();
    
    
    
    
    playerChar.setIcon(playerSkill);
    hpBarEnemy.setMaximum(monster.getMaxHp());
    hpBarEnemy.setValue(monster.getHealth());
    playerTurn = false;
    checkBattleStatus();

    Timer timer = new Timer(1000, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
                monsterCounterAttack();
                skillEfek.setVisible(false);
               ((Timer) e.getSource()).stop();
    }
});
     if (player instanceof RoleWarrior) {
            warriorUpdtEfek();
        }
    statBoxMonster.setText(monster.showStatus());
    updateSBar();
    timer.setRepeats(false);
    timer.start();
    }
    }//GEN-LAST:event_skillButtonActionPerformed

    private void battleNotifAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_battleNotifAncestorAdded
        // TODO add your handling code here:
        int level=player.getLevel();
        levelInd.setText(Integer.toString(level));
        int darah = player.getHealth();
    }//GEN-LAST:event_battleNotifAncestorAdded

    private void inventoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryButtonActionPerformed
        // TODO add your handling code here:
        inventory.setVisible(true);
        useButton.setVisible(true);
        inventoryButton.setVisible(false);
        inventoryScroll.setVisible(true);
    }//GEN-LAST:event_inventoryButtonActionPerformed

    private void useButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useButtonActionPerformed
        // TODO add your handling code here:
          int selectedIndex = inventory.getSelectedIndex();
          monsterChar.setVisible(true);
    if (selectedIndex != -1 && player != null) {
        Item selectedItem = player.getInventory().get(selectedIndex);
        player.use(selectedItem); // pakai item
        player.getInventory().remove(selectedIndex); // hapus dari list
        updateInventoryList(); 
        useButton.setVisible(false);
        inventory.setVisible(false);
        inventoryButton.setVisible(true);
        updateSBar();
        updateHpBar();
        inventoryScroll.setVisible(false);
        
        playerTurn = false;
        checkBattleStatus();
        
        Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        monsterCounterAttack();
        ((Timer) e.getSource()).stop();
    }
});
         if (player instanceof RoleWarrior) {
            warriorUpdtEfek();
        }
        updateSBar();
        timer.setRepeats(false);
        timer.start();
        
    }else{
        useButton.setVisible(false);
        inventory.setVisible(false);
        inventoryButton.setVisible(true);
        inventoryScroll.setVisible(false);
    }
    
    
    }//GEN-LAST:event_useButtonActionPerformed

    private void hpBar1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hpBar1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_hpBar1StateChanged

    private void hpBarEnemyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hpBarEnemyStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_hpBarEnemyStateChanged

    private void charAreaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charAreaMouseEntered
        // TODO add your handling code here:
        statBox.setVisible(true);
    }//GEN-LAST:event_charAreaMouseEntered

    private void charAreaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charAreaMouseExited
        // TODO add your handling code here:
        statBox.setVisible(false);
    }//GEN-LAST:event_charAreaMouseExited

    private void charArea1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charArea1MouseEntered
        // TODO add your handling code here:
        statBoxMonster.setVisible(true);
    }//GEN-LAST:event_charArea1MouseEntered

    private void charArea1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_charArea1MouseExited
        // TODO add your handling code here:
        statBoxMonster.setVisible(false);
    }//GEN-LAST:event_charArea1MouseExited

    private void skillButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skillButtonMouseEntered
        // TODO add your handling code here:
        skilDesc.setVisible(true);
    }//GEN-LAST:event_skillButtonMouseEntered

    private void skillButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skillButtonMouseExited
        // TODO add your handling code here:
        skilDesc.setVisible(false);
    }//GEN-LAST:event_skillButtonMouseExited

    private void piercerDescMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piercerDescMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_piercerDescMouseEntered

    private void piercerDescMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piercerDescMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_piercerDescMouseExited

    private void piercerAreaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piercerAreaMouseEntered
        // TODO add your handling code here:
        piercerDesc.setVisible(true);
    }//GEN-LAST:event_piercerAreaMouseEntered

    private void piercerAreaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piercerAreaMouseExited
        // TODO add your handling code here:
        piercerDesc.setVisible(false);
    }//GEN-LAST:event_piercerAreaMouseExited

    private void warriorAreaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warriorAreaMouseEntered
        // TODO add your handling code here:
        warriorDesc.setVisible(true);
    }//GEN-LAST:event_warriorAreaMouseEntered

    private void warriorAreaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warriorAreaMouseExited
        // TODO add your handling code here:
        warriorDesc.setVisible(false);
    }//GEN-LAST:event_warriorAreaMouseExited

    private void mageAreaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mageAreaMouseEntered
        // TODO add your handling code here:
        mageDesc.setVisible(true);
    }//GEN-LAST:event_mageAreaMouseEntered

    private void mageAreaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mageAreaMouseExited
        // TODO add your handling code here:
        mageDesc.setVisible(false);
    }//GEN-LAST:event_mageAreaMouseExited

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        aboutPanel.setVisible(true);
        exitButton2.setVisible(true);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void inventoryValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_inventoryValueChanged
        // TODO add your handling code here
        if (inventory.getSelectedIndex() != -1) {
                useButton.setText("USE");
            } 
    }//GEN-LAST:event_inventoryValueChanged

    private void exitButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButton2ActionPerformed
        // TODO add your handling code here:
        aboutPanel.setVisible(false);
        exitButton2.setVisible(false);
    }//GEN-LAST:event_exitButton2ActionPerformed

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
    private javax.swing.JButton aboutButton;
    private javax.swing.JLabel aboutPanel;
    private javax.swing.JButton attackButton;
    private javax.swing.JLabel battleMap;
    private javax.swing.JOptionPane battleNotif;
    private javax.swing.JPanel battlePanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel charArea;
    private javax.swing.JLabel charArea1;
    private javax.swing.JLabel enemyStatus1;
    private javax.swing.JLabel enemyStatus2;
    private javax.swing.JTextPane errorRole;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exitButton2;
    private javax.swing.JProgressBar hpBar1;
    private javax.swing.JProgressBar hpBarEnemy;
    private javax.swing.JLabel iconMonster;
    private javax.swing.JLabel iconPlayer;
    private javax.swing.JTextField inputNama;
    private javax.swing.JList<String> inventory;
    private javax.swing.JButton inventoryButton;
    private javax.swing.JScrollPane inventoryScroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel latarUtama;
    private javax.swing.JLabel levelInd;
    private javax.swing.JLabel mageArea;
    private javax.swing.JTextPane mageDesc;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JButton menuBack;
    private javax.swing.JLabel monsterChar;
    private javax.swing.JLabel nameBox;
    private javax.swing.JLabel nameBoxEnemy;
    private javax.swing.JLabel piercerArea;
    private javax.swing.JTextPane piercerDesc;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel playerChar;
    private javax.swing.JLabel playerStatus1;
    private javax.swing.JLabel playerStatus2;
    private javax.swing.JButton quitButton;
    private javax.swing.JLabel roleArea;
    private javax.swing.JComboBox<String> roleBox;
    private javax.swing.JPanel roleSelect;
    private javax.swing.JTextPane skilDesc;
    private javax.swing.JButton skillButton;
    private javax.swing.JLabel skillEfek;
    private javax.swing.JProgressBar spesialBar;
    private javax.swing.JButton startButton;
    private javax.swing.JTextPane statBox;
    private javax.swing.JTextPane statBoxMonster;
    private javax.swing.JLabel turnNumber;
    private javax.swing.JButton useButton;
    private javax.swing.JLabel warriorArea;
    private javax.swing.JTextPane warriorDesc;
    // End of variables declaration//GEN-END:variables
}
