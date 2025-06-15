package com.Character;

import com.Monsters.Monster;

public class RolePiercer extends Character{
    private String type;
    private int penetration;
    private int poisonDuration=0;
    private int poison=5;


    public RolePiercer(String nama){
        super(nama, 100, 15, 5);
        this.type="Piercer";
        this.penetration=10;
    }
    @Override
    public void tampilkan() {
        System.out.println("\nClass : "+type);
        super.tampilkan();
        System.out.println("Piercing : "+penetration);
    }
    public void poisonSkill(int turnSekarang,Monster target){
        if (poisonDuration>0) {
            System.out.println("\nMusuh sudah terkena racun");
        }else{
            System.out.println(target.getName()+" Terkena racun");
            poisonDuration=turnSekarang+1+getLevel();
            target.terSerang(poison);
            System.out.println(target.getName()+" terkena "+poison+" damage dari keracunan");
            target.setKeracunan(true);
        }    
    }
    public void poisonDamage(int turnSekarang,Monster target){
        if (poisonDuration == 0) return; 

        if (turnSekarang <= poisonDuration) {
            target.terSerang(poison);
            System.out.println(target.getName()+" terkena "+poison+" damage dari keracunan");
        } else {
            System.out.println("Durasi racun berakhir");
            poisonDuration = 0;
            target.setKeracunan(false);
        }
    }
    @Override
    public void serang(Monster target){
        System.out.println("\n"+getName()+ " menyerang " + target.getName());
        if (target.getDefense()<penetration) {
            int curentDamage=getAttack()+penetration-target.getDefense();
            target.terSerang(curentDamage);
            System.out.println(getName()+" Menimbulkan damage sebesar "+curentDamage);
        }else{
            target.terSerang(getAttack()-(target.getDefense()-penetration));
            System.out.println(getName()+" Menimbulkan damage sebesar "+(getAttack()-(target.getDefense()-penetration)));
        }
    }
    @Override
    public void levelUp(){
        super.levelUp();
        penetration+=3;
        poison+=5;
        System.out.println("Piercing naik menjadi : "+penetration);
    }
    @Override
    public void claimExp(Monster target){
        super.claimExp(target);
    }
    @Override
    public void show(){
        super.show();
    }
    public void resetPoisonStatus(){
        poisonDuration=0;
    }
    @Override
    public String getRole(){
        return this.type;
    }
    public String showStatus(){
        return "Max hp = " + getMaxHp() +
               "\nDefense = " + getDefense() +
               "\nAttack = " + getAttack() +
               "\nPenetration " + penetration +
               "\nPoison Damage = " + poison +
               "\n";
    }
}