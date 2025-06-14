package com.Character;

import com.Monsters.Monster;
import com.GameUI.app;

public class RoleWarrior extends Character {
    private String type;
    private int baseStrength;
    private int bonusStregth=0;
    private int rageStrength=0;
    private int rageDuration;
    private int energy=20;
    private int maxEnergy;
    




    public RoleWarrior(String nama){
        super(nama, 100, 10, 5);
        this.baseStrength=5;
        this.type="Warrior";
        this.maxEnergy=energy;
    }
    @Override
    public int getDefense() {
        return super.getDefense() + getStrength();
    }
    
    public int getStrength(){
        return baseStrength+bonusStregth+rageStrength;
    }
    public void setBonusStregth(int bonus){
        this.bonusStregth=bonus;
    }
    
    @Override
    public void tampilkan() {
        System.out.println("\nClass : "+type);
        super.tampilkan();
        System.out.println("Strength : " + getStrength() + " (Base: " + baseStrength + ", Bonus: " + bonusStregth + ", Rage: " + rageStrength + ")");
        System.out.println("Energy : "+energy+"/"+maxEnergy);
    }
    public void rageSkill(int turnSekarang,Monster target){
        if (rageDuration > 0) {
            System.out.println("Saat ini sedang dalam mode rage");
        } else if (energy < 20) {
            System.out.println("Energy tidak cukup untuk mengaktifkan rage");
        } else {
            rageStrength=baseStrength;
            System.out.println(getName() + " Mengaktifkan mode rage!");
            System.out.println("Strength sekarang = "+getStrength());
            rageDuration = turnSekarang + 3;
            energy -= 20;
            target.setRageStatus(true);;

        }
    }
    public void durasiSkill(int turnSekarang,Monster target){
        if (rageDuration>0 && turnSekarang>=rageDuration) {
            System.out.println("Durasi rage telah selesai");
            rageStrength=0;
            rageDuration=0;
            target.setRageStatus(false);
        }
    }
    public void resetRage(Monster target){
        target.setRageStatus(false);
        rageDuration=0;
    }
    @Override
    public void serang(Monster target) {
        System.out.println("\n" + getName() + " menyerang " + target.getName());
        int damage = getAttack() + getStrength() - target.getDefense();
        if (damage < 0){ damage = 0;}
        target.terSerang(damage);
        System.out.println("Damage yang dihasilkan sebesar " + damage);
    }
    public void regenEnergy (int amount){
        energy+=amount;
        if (energy>20) {
            energy=20;
        }
    }
    @Override
    public void terSerang(int damage){

        super.terSerang(damage);
    }
    @Override
    public void levelUp(){
        super.levelUp();
        baseStrength+=2;
        System.out.println("Strength naik menjadi : "+baseStrength);
    }
    @Override
    public void claimExp(Monster target){
        super.claimExp(target);
    }
    @Override
    public void show(){
        super.show();
        System.out.println("Energy : "+energy+"/"+maxEnergy);
    }
    @Override
    public String getRole(){
        return this.type;
    }
}
