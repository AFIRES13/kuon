package com.Main;

// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.Character.Character;
import com.Character.RoleMage;
import com.Character.RolePiercer;
import com.Character.RoleWarrior;
import com.Item.Equipment.Sword;
import com.Monsters.goblinKing;
import com.Monsters.Goblin;
import com.Monsters.Monster;
import com.Item.*;

public class Main {
    public static void main(String[] args) {
        Character player=new RoleMage("riiku");
        System.out.println(player.showStatus());
        

    //     Scanner scanner=new Scanner(System.in);
    //     // System.out.print("Masukan nama Pemain : ");
    //     // String namaPlayer=scanner.nextLine();

        
    //     // System.out.println("Silahkan pilih role yang ingin di mainkan");
    //     // System.out.println("Role Warrior(W) Role Piercer(P) Role Mage(M)");
    //     // System.out.print("Masukan kode role : ");
    //     // String playerRole=scanner.nextLine();



    //     // Character player=null;
        

    //     // switch (playerRole.toUpperCase()) {
    //     //     case "W":
    //     //         player=new RoleWarrior(namaPlayer);
    //     //         break;
    //     //     case "P":
    //     //         player=new RolePiercer(namaPlayer);
    //     //         break;
    //     //     case"M":
    //     //         player=new RoleMage(namaPlayer);
    //     //         break;
            

        
    //     //     default:
    //     //         System.out.println("Salah input kode role");
    //     //         scanner.close();
    //     //         break;
    //     // }
    //     // Monster monster=new goblinKing();

    //     // int turn=1;
    //     // while (player.hidup()&&monster.hidup()) {
            
    //     //     System.out.println("\n\b=====Turn ke-"+turn+"=====");
    //     //     System.out.println("\nNext move ");
    //     //     System.out.println("Serang = a");
    //     //     System.out.println("Skill = s");
    //     //     System.out.println("Inventory = d");
    //     //     System.out.print("Your move :");
    //     //     String gerakan=scanner.nextLine();
    //     //     System.out.println("");

    //     // switch (gerakan.toLowerCase()) {
    //     //     case "a":
    //     //         player.serang(monster);
                
    //     //         break;
    //     //     case "s":
    //     //         if (player instanceof RoleWarrior) {
    //     //             ((RoleWarrior)player).rageSkill(turn);
    //     //         }else if (player instanceof RolePiercer) {
    //     //             ((RolePiercer)player).poisonSkill(turn, monster);
    //     //         }else if (player instanceof RoleMage) {
    //     //             ((RoleMage)player).stunSkill(turn, monster);
               
    //     //         }else{
    //     //             System.out.println("skill tidak tersedia ");
    //     //         }
    //     //         break;
    //     //         case "d":
    //     //         // Tampilkan Inventory
    //     //         player.showInventory();
    //     //         System.out.print("Pilih item untuk digunakan (masukkan nomor): ");
    //     //         int itemIndex = Integer.parseInt(scanner.nextLine()) - 1;
    //     //         player.useItem(itemIndex);
    //     //         break;
    //     //     default:
    //     //         System.out.println("Move tidak tersedia");
    //     //         break;

    //     //     }
        
    //     // }
    //     int turn =1;
    //     Item pedang=new Sword("biji ", 10, 10);
    //     String namaPlayer="Riiku";
    //     Character player=new RoleWarrior(namaPlayer);
    //     Monster monster=new Goblin(turn);

    //     player.tampilkan();
    //     player.addItem(pedang);
    //     player.showInventory();
    //     System.out.print("Pilih item untuk digunakan (masukkan nomor): ");
    //     int itemIndex = Integer.parseInt(scanner.nextLine()) - 1;
    //     player.useItem(itemIndex);
    //     player.tampilkan();        
    //     monster.show();

    // scanner.close();}
}
}