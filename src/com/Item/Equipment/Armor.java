package com.Item.Equipment;

import com.Character.Character;

public class Armor extends Equipment{
    private int bonusHealth;
    private int bonusDefense;


    public Armor(String nama, String deskripsi,int bonusHealth, int bonusDefense){
        super(nama,deskripsi);
        this.bonusDefense=bonusDefense;
        this.bonusHealth=bonusHealth;
    }
    @Override
    public void use(Character target){
        target.setBonusDefense(bonusDefense);
        target.setBonusHealth(bonusHealth);
        System.out.println("\n"+target.getName()+" Menggunakan "+getName());
        System.out.println("Def "+target.getName()+" bertambah "+bonusDefense);
        System.out.println("HP "+target.getName()+" bertambah "+bonusHealth);
    }
}