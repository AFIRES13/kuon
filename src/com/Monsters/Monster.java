package com.Monsters;

import com.Character.Character;

public abstract class Monster {
    private String nama;
    private int health;
    private int attack;
    private int defense;
    private int expDrop;
    private boolean stunStatus;
    private int maxHealth;
    private boolean keracunan;
    private int stunCounter=0;
    private int stunDuration=0;
    private boolean rageStatus=false;

    public Monster(String nama, int health, int attack, int defense,int expDrop){
        this.nama=nama;
        this.health=health;
        this.maxHealth=health;
        this.attack=attack;
        this.defense=defense;
        this.expDrop=expDrop;
        this.stunStatus=false;
        this.keracunan=false;
    }
    public String getName(){
        return nama;
    }
    public int getHealth(){
        return health;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public boolean getStunStatus(){
        return stunStatus;
    }
    public boolean getKeracunan(){
        return keracunan;
    }
    public int getExpDrop(){
        return expDrop;
    }
    public int getStunCounter(){
        return stunCounter;
    }
    public int getMaxHp(){
        return maxHealth;
    }
    public void setStunCounter(int count){
        this.stunCounter=count;
    }
    public void setStunStatus(boolean value){
        this.stunStatus=value;
    }
    public void setKeracunan(boolean value){
        this.keracunan=value;
        if (value) {
            this.stunCounter=3;
        }else{
            this.stunCounter=0;
        }
    }
    

    public boolean getRageStatus(){
        return rageStatus;
    }
    public void setRageStatus(boolean rage){
        this.rageStatus=rage;
    }
    
    public void decreaseStunCounter() {
    if (stunCounter > 0) {
        stunCounter--;
        if (stunCounter == 0) {
            stunStatus = false;
            }
        }
    }
    public String showStatus(){
        return "Max hp = " + getMaxHp() +
               "\nDefense = " + getDefense() +
               "\nAttack = " + getAttack() +
               "\n"
               
               ;
    }
    public void tampilkan(){
        System.out.println("Nama : "+nama);
        System.out.println("HP : "+health);
        System.out.println("att : "+attack);
        System.out.println("def : "+defense);
    }
    public void terSerang(int damage) {
        health-=damage;
        if (health<0) {
            health=0;
        }
    }

    public boolean hidup(){
        return health>0;
    }
    public boolean mati(){
        return health<=0;
    }
    public abstract void serang(Character target);


    public void show(){
        System.out.println("\nNama : "+nama);
        System.out.println("HP : "+health+"/"+maxHealth);
    }
    public abstract void itemDrop(Character target);
    public boolean isStunned() {
        return stunDuration > 0;
    }
    
    public void applyStun(int duration) {
        this.stunDuration = duration;
    }
    
    public void updateStun() {
        if (stunDuration > 0) {
            stunDuration--;
        }
    }
}
