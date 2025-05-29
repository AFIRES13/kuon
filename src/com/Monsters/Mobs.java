package com.Monsters;

import com.Character.Character;
import com.Item.Consumable.*;

public class Mobs extends Monster{
    private String type;
    public Mobs(String nama, int health, int attack,int defense,int expDrop){
        super(nama, health, attack, defense, expDrop);
        this.type="Monster";
        
    }
    @Override
    public void tampilkan(){
        System.out.println("\nClass : "+type);
        super.tampilkan();

    }
    @Override
    public void serang(Character target){
    System.out.println("\n" + getName() + " menyerang " + target.getName());
    int damage = getAttack()-target.getDefense();
    if (damage < 0) damage = 0;
    target.terSerang(damage);
    System.out.println("Damage yang dihasilkan sebesar " + (damage));
    }
    public void itemDrop(Character target){
        target.addItem(new HealingPotion());
    }
}
