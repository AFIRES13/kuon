package com.Character;
import com.GameUI.app;


// import java.awt.List;
import java.util.ArrayList;
import java.util.List;
import com.Item.Item;
import com.Monsters.Monster;

public abstract class Character {
    private String nama;
    private int baseHealth;
    private int bonusHealth;
    private int baseAttack;
    private int bonusAttack=0;
    private int baseDefense;
    private int bonusDefense;
    private int maxHealth;
    private int exp;
    private int maxExp=10;
    private int level=1;
    private boolean stunStatus;
    private List<Item> inventory=new ArrayList<>();
    private String isi;
    private int mana;
    private int maxMana;
    private int energy;
    private int maxEnergy;
    
    //konstruktor
    public Character(String nama, int baseHealth, int baseAttack, int baseDefense){
        this.nama=nama;
        this.baseHealth=baseHealth;
        this.maxHealth=baseHealth;
        this.baseAttack=baseAttack;
        this.baseDefense=baseDefense;
        this.stunStatus=false;
    }

    //getter

    public String getName(){
        return nama;
    }
    public int getHealth(){
        return baseHealth+bonusHealth;
    }
    public int getMaxHp(){
        return maxHealth;
    }
    public int getAttack(){
        return baseAttack+bonusAttack;
    }
    public int getDefense(){
        return baseDefense+bonusDefense;
    }
    public boolean getStunStatus(){
        return stunStatus;
    }
    public int getLevel(){
        return level;
    }
    public int getBonusAttack() {
        return bonusAttack;
    }
    
    public List<Item> getInventory(){
        return inventory;
    }
    public String getIsi(){
        return isi;
    }
    public int getMana(){
        return mana;
    }
    public int getMaxMana(){
        return maxMana;
    }
    public int getEnergy() {
        return energy;
    }
    
    public int getMaxEnergy() {
        return maxEnergy;
    }
    
    
    //setter
    
    public void setBonusAttack(int bonus) {
        this.bonusAttack = bonus;
    }
    public void setBonusDefense(int bonus){
        this.bonusDefense=bonus;
    }
    public void setBonusHealth(int bonus){
        this.bonusHealth=bonus;
    }
    public void setStunStatus(boolean value){
        this.stunStatus=value;
    }
    public void setName(String name){
        this.nama=name;
    }

    //method

    public void tampilkan(){
        System.out.println("Nama : "+nama);
        System.out.println("Level : "+level);
        System.out.println("Exp : "+exp+"/"+maxExp);
        System.out.println("HP : "+getHealth()+"/"+maxHealth);
        System.out.println("att : "+getAttack());
        System.out.println("def : "+getDefense());
    }
    public void terSerang(int damage) {
        baseHealth-=damage;
        if (baseHealth<0) {
            baseHealth=0;
        }
    }
    public boolean hidup(){
        return baseHealth>0;
    }
    public boolean mati(){
        return baseHealth<=0;
    }
    public abstract void serang(Monster target);

    public void levelUp(){
        level++;
        maxExp+=10;
        maxHealth+=(level*5);
        baseHealth=maxHealth;
        baseAttack+=(level*3);
        baseDefense+=(level*2);
//        battleNotif.showMessageDialog(this,"kamu naik level");
        System.out.println("\n\b=====LEVEL UP=====");
        System.out.println(getName()+" Naik ke level "+level);
        System.out.println("HP meningkat jadi : "+maxHealth);
        System.out.println("ATT naik menjadi : "+baseAttack);
        System.out.println("DEF naik menjadi : "+baseDefense);

    }
    private String stat="Max hp = "+this.getMaxHp()+"\nDefense = "+this.getDefense()+"\nAttack = "+this.getAttack()+"\nl";
    
    public String showStatus(){
        return stat;
    }

    public void claimExp(Monster target){
        if (target.mati()) {
            exp+=target.getExpDrop();
            System.out.println(getName()+" Mendapatkan "+target.getExpDrop()+" exp");
            while (exp>=maxExp) {
                exp-=maxExp;
                levelUp();
            }
        }
    }
    
    public void heal(int regen){
        {
            if (regen < 0) {
                System.out.println("Jumlah penyembuhan tidak bisa negatif.");
                return;
            }
            
            baseHealth += regen; // Tambahkan jumlah penyembuhan ke kesehatan
            if (baseHealth > maxHealth) {
                baseHealth = maxHealth; // Pastikan kesehatan tidak melebihi batas maksimum
            }
            
            System.out.println(getName() + " telah disembuhkan sebesar " + regen );
        }

    }
    public void show(){
        System.out.println("\nNama : "+nama);
        System.out.println("Level : "+level);
        System.out.println("HP : "+getHealth()+"/"+maxHealth);
    }
    public void use(Item item){
        item.use(this);
    }
    public void addItem(Item item){
        inventory.add(item);
        System.out.println("\n"+item.getName()+" Telah di tambahkan");
    }
    public void showInventory(){
        System.out.println("=====Inventory=====");
        if (inventory.isEmpty()) {
            isi="Inventory kosong";
            System.out.println(isi);
        }else{
            for(int i=0;i<inventory.size();i++){
                isi=(i+1)+"."+inventory.get(i).getName()+"\n";
                System.out.println(isi);
            }
        }
    }
    public void useItem(int index) {
        if (index < 0 || index >= inventory.size()) {
            System.out.println("Index item tidak valid.");
            return;
        }

        Item item = inventory.remove(index);
        item.use(this);
        System.out.println("Menggunakan " + item.getName());
    }
    public abstract String getRole();
    public void takeExp(Monster target){
        exp+=target.getExpDrop();
            System.out.println(getName()+" Mendapatkan "+target.getExpDrop()+" exp");
            while (exp>=maxExp) {
                exp-=maxExp;
                levelUp();
            }
    }
}
