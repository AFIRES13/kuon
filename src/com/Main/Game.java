package com.Main;

import java.util.*;
import com.Character.Character;
import com.Character.RoleMage;
import com.Character.RolePiercer;
import com.Character.RoleWarrior;
import com.Monsters.Goblin;
import com.Monsters.Monster;
import com.Monsters.bosMonster;
import com.Monsters.goblinKing;
//import com.Item.Item;
import com.Item.Consumable.*;
//import com.Item.Equipment.Sword;



public class Game {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Masukan nama Pemain : ");
        String namaPlayer=scanner.nextLine();

        
        System.out.println("Silahkan pilih role yang ingin di mainkan");
        System.out.println("Role Warrior(W) Role Piercer(P) Role Mage(M)");
        System.out.print("Masukan kode role : ");
        String playerRole=scanner.nextLine();



        Character player=null;
        

        switch (playerRole.toUpperCase()) {
            case "W":
                player=new RoleWarrior(namaPlayer);
                break;
            case "P":
                player=new RolePiercer(namaPlayer);
                break;
            case"M":
                player=new RoleMage(namaPlayer);
                break;
            

        
            default:
                System.out.println("Salah input kode role");
                scanner.close();
                break;
        }

        //menambahkan item healing potion kepada player
        for (int i=0; i<5; i++) {
            player.addItem(new HealingPotion());
        }
        
        int wave=1;
        while (player.hidup()) {
            System.out.println("\n\b=======Wave-"+wave+"=======");
            
            //spawn monster tergantung wave 
            
            Monster monster;
            if (wave==6) {
                monster=new goblinKing();
            }else {
                monster=new Goblin(wave);
            }
            
            //reset efek sill role character

            if (player instanceof RoleMage) {
                ((RoleMage) player).resetStun();
            }else if (player instanceof RolePiercer) {
                ((RolePiercer) player).resetPoisonStatus();
            }
            
            // pemberitahuan monster spawn
            
            if (monster instanceof bosMonster) {
                System.out.println("Boss monster "+monster.getName()+" telah muncul");
            }else{
                System.out.println(monster.getName()+" Telah muncul");
            }

            player.tampilkan();
            monster.tampilkan();

            //looping battle turn base 

            int turn=1;
            while (player.hidup()&&monster.hidup()) {
                
                System.out.println("\n\b=====Wave ke-"+wave+"Turn ke-"+turn+"=====");
                System.out.println("\nNext move ");
                System.out.println("Serang = a");
                System.out.println("Skill = s");
                System.out.println("Inventory = d");
                System.out.print("Your move :");
                String gerakan=scanner.nextLine();
                System.out.println("");

                //player move 
                System.out.println("=====Battle Log=====");
    
                switch (gerakan.toLowerCase()) {
                    case "a":
                        player.serang(monster);
                        
                        break;
                    case "s":
                        if (player instanceof RoleWarrior) {
                            ((RoleWarrior)player).rageSkill(turn);
                        }else if (player instanceof RolePiercer) {
                            ((RolePiercer)player).poisonSkill(turn, monster);
                        }else if (player instanceof RoleMage) {
                            ((RoleMage)player).stunSkill(turn, monster);
                       
                        }else{
                            System.out.println("skill tidak tersedia ");
                        }
                        break;
                        case "d":
                        // Tampilkan Inventory
                        player.showInventory();
                        System.out.print("Pilih item untuk digunakan (masukkan nomor): ");
                        int itemIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        player.useItem(itemIndex);
                        break;
                    default:
                        System.out.println("Move tidak tersedia");
                        break;
    
                    }
                    
                    //efek yg di hasilkan oleh skill

                    if (player instanceof RoleWarrior) {
                        ((RoleWarrior)player).durasiSkill(turn);
                    }else if (player instanceof RolePiercer) {
                        ((RolePiercer)player).poisonDamage(turn, monster);
                    }else if (player instanceof RoleMage) {
                        RoleMage mage = (RoleMage) player;
                        if (mage.getStunDuration() >= turn) {
                            mage.efekStun(turn, monster);
                        } else {
                            if (monster.getStunStatus()) {
                                System.out.println(monster.getName() + " Lepas dari stun");
                                monster.setStunStatus(false);
                            }
                        }
                    }
                    
                    //monster menyerang player
                    
                    if (monster.hidup()) {
                        if (monster.getStunStatus()) {
                        }else{
                            if (monster instanceof goblinKing) {
                                monster.serang(player);
                            }else{
                                monster.serang(player);
                            }
                        }
                        
                    }else{
                        System.out.println(player.getName()+" Berhasil mengalahkan "+monster.getName());
                    }
                    
                    player.tampilkan();
                    monster.show();
                    
                    //pasif dari setiap role
                    
                    if (player instanceof RoleMage) {
                        ((RoleMage)player).regenMana(5);
                    }else if (player instanceof RoleWarrior) {
                    ((RoleWarrior)player).regenEnergy(5);
                }
     

                turn++;// akhir dari looping battle 
            }
            
            // memastikan player atau monster masih hidup atau tidak
            
            if (player.mati()) {
                System.out.println("\n" + player.getName() + " Telah mati");
                break;
            }
            
            System.out.println("\n" + monster.getName() + " Telah mati");
            player.claimExp(monster);
            monster.itemDrop(player);
            
            System.out.print("\nLanjut ke wave berikutnya? (y/n): ");
            String lanjut = scanner.nextLine();
            if (!lanjut.equalsIgnoreCase("y")) {
                break;
            }
        
            wave++;// akhir dari wave (ketika player atau monster mati)
        
        }System.out.println("\nGAME OVER");
        System.out.println("Kamu telah mati");
    scanner.close();
    }
}
