package com.Item.Equipment;

public class Staff extends Weapon{
    private int bonusManaRegen;
    private int bonusStunDuration;
    
    public Staff(String nama, int bonusAttack, int bonusManaRegen, int bonusStunDuration){
        super(nama+" Staff", "Weapon khusus mage", 10);
        this.bonusManaRegen=bonusManaRegen;
        this.bonusStunDuration=bonusStunDuration;
    }
    public int getBonusMR(){
        return bonusManaRegen;
    }
    public int getBonusStunDuration(){
        return bonusStunDuration;
    }
}
