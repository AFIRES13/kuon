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
    public int getEnergy() {
        return energy;
    }
    
    public int getMaxEnergy() {
        return maxEnergy;
    }
    
    
    
    public String showStatus(){
        return "Max hp / hp = " + getMaxHp()+"/"+this.getHealth() +
               "\nDefense = " + getDefense() +
               "\nAttack = " + getAttack() +
               "\nStrength " + getStrength() +
               "\nEnergy = " + energy;
    }
    
    
    public void rageSkill(int turnSekarang,Monster target){
        if (rageDuration > 0) {
            
            setSkillStatus("masih dalam mode rage");
        } else if (energy < 20) {
            
            setSkillStatus("Energy tidak cukup untuk rage");
        } else {
            rageStrength=baseStrength;
            rageDuration = turnSekarang + 3;
            energy -= 20;
            target.setRageStatus(true);
            setSkillStatus("");
            

        }
    }
    public void durasiSkill(int turnSekarang,Monster target){
        if (rageDuration>0 && turnSekarang>=rageDuration) {
            
            rageStrength=0;
            rageDuration=0;
            target.setRageStatus(false);
            setSkillStatus("");
        }
    }
    public void resetRage(Monster target){
        target.setRageStatus(false);
        rageDuration=0;
        setSkillStatus("");
    }
    @Override
    public void serang(Monster target) {
        
        int damage = getAttack() + getStrength() - target.getDefense();
        if (damage < 0){ damage = 0;}
        target.terSerang(damage);
        
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
       
    }
    @Override
    public void claimExp(Monster target){
        super.claimExp(target);
    }
    
    @Override
    public String getRole(){
        return this.type;
    }
}
