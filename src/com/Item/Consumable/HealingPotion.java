package com.Item.Consumable;

import com.Character.Character;

public class HealingPotion extends Consumable{
    private int healing;

    public HealingPotion(){
        super("Healing potion", "Menyembuhkan 30 HP");
        this.healing=30;
    }
    @Override
    public void use(Character target){
        System.out.println("Menggunakan Healing potion");
        target.heal(healing);
    }
}
