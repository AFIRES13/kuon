package com.Monsters;
import com.Character.Character;
import com.Item.Equipment.Weapon;
import com.Item.Equipment.Armor;

public class goblinKing extends bosMonster{
    public goblinKing(){
        super("Goblin king",500,40,20,50);
    }
    public void skill(Character target){
        System.out.println(target.getName());
    }


    Weapon Sword=new Weapon("Steel ", "Pedang yang terbuat dari besi", 10);
    Armor chestPlate=new Armor("Chest plate", "Armor yamg terbuat dari baja", 50, 7);
    @Override
    public void itemDrop(Character target){
        target.addItem(Sword);
        target.addItem(chestPlate);
    }
}