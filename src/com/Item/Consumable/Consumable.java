package com.Item.Consumable;

import com.Character.Character;
import com.Item.Item;

public abstract class Consumable extends Item{
    public Consumable(String nama, String deskripsi){
        super(nama, deskripsi);
     }
    public abstract void use(Character target);
}
