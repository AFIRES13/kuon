package com.Item;

import com.Character.Character;

public abstract class Item {
    private String nama;
    private String deskripsi;

    public Item(String nama, String deskripsi){
        this.nama=nama;
        this.deskripsi=deskripsi;
    }
    public String getName(){
        return nama;
    }
    public String getDeskripsi(){
        return deskripsi;
    }
    public abstract void use(Character target);
}