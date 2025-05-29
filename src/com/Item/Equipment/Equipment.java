package com.Item.Equipment;

import com.Character.Character;
import com.Item.Item;


public abstract class Equipment extends Item{

    public Equipment(String nama, String deskripsi){
       super(nama, deskripsi);
    }
    public abstract void use(Character target);
}
