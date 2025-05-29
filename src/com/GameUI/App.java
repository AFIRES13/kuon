package com.GameUI;

import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.Character.Character;
import com.Character.RoleMage;
import com.Character.RolePiercer;
import com.Character.RoleWarrior;

public class App {
    public static void main(String[] args) {
        JFrame scene1=new JFrame("kuon");
        scene1.setVisible(true);
        scene1.setSize(1024,720);
        scene1.setLayout(null);
        scene1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1=new JLabel("pilih role");
        label1.setBounds(50,30,100,20);
        scene1.add(label1);

        JComboBox selectRole=new JComboBox<>();
        selectRole.addItem("Warrior");
        selectRole.addItem("Piercer");
        selectRole.addItem("Mage");
        selectRole.setBounds(50,50,100,40);
        scene1.add(selectRole);

        JButton roleAcc=new JButton("Accept");
        roleAcc.setBounds(50,90,100,20);
        
        scene1.add(roleAcc);
        
        roleAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            Character player=null;
                String playerRole = (String) selectRole.getSelectedItem();
                switch (playerRole) {
                    case "Warrior":
                        player=new RoleWarrior(playerRole);
                        break;
                    case "Piercer":
                        player= new RolePiercer(playerRole);
                        break;
                    case "Mage":
                        player=new RoleWarrior(playerRole);
                        break;
                    
                }
                
                player.tampilkan();
                
            }
        });

        

    }
}
