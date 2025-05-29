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
public void setMana(int mana){
    this.mana=mana;
}
@Override
public void tampilkan(){
    System.out.println("\nClass : "+type);
    super.tampilkan();
    System.out.println("Mana : "+mana+"/"+maxMana);
}
@Override
public void serang(Monster target){
System.out.println("\n" + getName() + " menyerang " + target.getName());
int damage = getAttack()-target.getDefense();
if (damage < 0) damage = 0;
target.terSerang(damage);
System.out.println("Damage yang dihasilkan sebesar " + (damage));
}
public void stunSkill(int turnSekarang, Monster target){
    if (this.mana >= 20) {
        this.mana -= 20;
        this.stunDuration = turnSekarang + 3; 
        target.setStunStatus(true);
        this.isStunning = true; 
        System.out.println(target.getName() + " terkena stun");
    } else {
        System.out.println("Mana tidak cukup untuk menggunakan skill stun");
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
    maxMana+=5;
    mana=maxMana;
    System.out.println("Mana naik menjadi : "+maxMana);
}
@Override
public void claimExp(Monster target){
    super.claimExp(target);
}
@Override
public void show(){
    super.show();
    System.out.println("Mana : "+mana+"/"+maxMana);
}
@Override
public String getRole(){
    return this.type;
}
}