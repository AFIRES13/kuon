package com.Item.Equipment;

import com.Character.Character;

public class Weapon extends Equipment{
    private int bonusAttack;
    
    public Weapon(String nama, String deskripsi,int bonusAttack){
        super(nama,deskripsi);
        this.bonusAttack=bonusAttack;
    }
    public int getBonusAttack(){
        return bonusAttack;
    }
    @Override
    public void use(Character target){
        target.setBonusAttack(bonusAttack);
        System.out.println("\n"+target.getName()+" Menggunakan "+getName());
        System.out.println("Att "+target.getName()+" bertambah "+bonusAttack);
    }
}
