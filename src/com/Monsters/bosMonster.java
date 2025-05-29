package com.Monsters;

import com.Character.Character;

public abstract class bosMonster extends Monster{
    private String type;
    public bosMonster(String nama, int health, int attack,int defense,int expDrop){
        super(nama, health, attack, defense, expDrop);
        this.type="Bos monster";
        
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
    
}
