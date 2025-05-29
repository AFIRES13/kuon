package com.Item.Equipment;

import com.Character.Character;
import com.Character.RoleWarrior;

public class Sword extends Weapon{
    private int bonusStregth;
    public Sword(String nama,int bonusAttack,int bonusStregth){
        super(nama+"Sword", "Senjata khusus role warior", bonusAttack);
        this.bonusStregth=bonusStregth;
    }
    public int getBonusStrength(){
        return bonusStregth;
    }
    @Override
    public void use(Character target) {
        if (target instanceof RoleWarrior) {
            super.use(target); // panggil use() dari Weapon untuk apply bonus
            ((RoleWarrior)target).setBonusStregth(bonusStregth); 
        } else {
            System.out.println(target.getName() + " bukan Warrior maka tidak mendapatkan bonus spesial stat");
            super.use(target);
        }
    }
}
