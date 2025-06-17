package com.Character;

import com.Monsters.Monster;

public class RoleMage extends Character{
    private String type;
    private int mana;
    private int stunDuration;
    private int maxMana;
    private boolean isStunning=false;

    public RoleMage(String nama){
        super(nama, 100, 20, 5);
        this.type="Mage";
        this.mana=30;
        this.maxMana=mana;
}
public int getStunDuration(){
    return stunDuration;
}
public int getMana(){
    return mana;
}
public int getMaxMana(){
    return maxMana;
}
public void setMana(int mana){
    this.mana=mana;
}

@Override
public void serang(Monster target){
int damage = getAttack()-target.getDefense();
if (damage < 0) damage = 0;
target.terSerang(damage);

}
public void stunSkill(int turnSekarang, Monster target){
    if (this.mana >= 20) {
        this.mana -= 20;
        this.stunDuration = turnSekarang + 2+getLevel(); 
        target.setStunStatus(true);
        this.isStunning = true; 
       
    } else {
       
        setSkillStatus("mana tidak cucup");
    }
}
public void efekStun(int turnSekarang,Monster target){
    if (isStunning) {
        if (turnSekarang < stunDuration) {
            target.setStunStatus(true);
            System.out.println(target.getName() + " terstun");
        } else {
            target.setStunStatus(false);
            isStunning = false; 
            System.out.println(target.getName() + " Lepas dari stun");
        }
    }
    }
    
    public String showStatus(){
        return "Max hp / hp = " + getMaxHp()+"/"+this.getHealth() +
               "\nDefense = " + getDefense() +
               "\nAttack = " + getAttack() +
               "\nMax mana = " + getMaxMana() +
               "\nDurasi stun musuh = " + (2 + getLevel()) + " turn";
    }
public void regenMana(int amount){
    mana+=amount;
    if (mana>maxMana) {
        mana=maxMana;
    }
}
public void resetStun(){
    this.stunDuration=0;
    this.isStunning=false;
}
@Override
public void levelUp(){
    super.levelUp();
    
    mana=maxMana;
    
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