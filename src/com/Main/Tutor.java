package com.Main;

import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.Character.Character;
import com.Character.RoleMage;
import com.Character.RolePiercer;
import com.Character.RoleWarrior;


public class Tutor {
    public static void main(String[] args) {
        JFrame form =new JFrame("Gw gk tau ini apa");
        form.setVisible(true);
        form.setSize(1024,720);
        form.setLayout(null);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label1= new JLabel("ini apa lagi?");
        label1.setBounds(100,100,100,100);
        form.add(label1);
        
        JButton button=new JButton("press");
        button.setBounds(10,10,100,30);
        form.add(button);

        JTextField inputNama=new JTextField();
        inputNama.setBounds(50,50,200,30);
        form.add(inputNama);
        inputNama.setVisible(true);

        JButton button2=new JButton();
        button2.setBounds(50, 100, 100, 30);
        form.add(button2);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label1.setText("Tombol ditekan!");
                
            }
        });
        inputNama.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kuon= inputNama.getText(); // Mengambil teks dari JTextField
                RoleWarrior player=new RoleWarrior(kuon);
                player.tampilkan();
                
            }
        });
    }
}
