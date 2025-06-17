package com.Character;

import com.Monsters.Monster;

public class RolePiercer extends Character{
    private String type;
    private int penetration;
    private int poisonDuration=0;
    private int poison=5;


    public RolePiercer(String nama){
        super(nama, 100, 15, 5);
        this.type="Piercer";
        this.penetration=10;
    }
    
    public void poisonSkill(int turnSekarang,Monster target){
        if (poisonDuration>0) {
            setSkillStatus("musuh sudah terkena racun");
        }else{
            
            poisonDuration=turnSekarang+1+getLevel();
            target.terSerang(poison);
           
            target.setKeracunan(true);
        }    
    }
    public void poisonDamage(int turnSekarang,Monster target){
        if (poisonDuration == 0) return; 

        if (turnSekarang <= poisonDuration) {
            target.terSerang(poison);
            System.out.println(target.getName()+" terkena "+poison+" damage dari keracunan");
        } else {
            setSkillStatus("");
            poisonDuration = 0;
            target.setKeracunan(false);
        }
    }
    @Override
    public void serang(Monster target){
        
        if (target.getDefense()<penetration) {
            int curentDamage=getAttack()+penetration-target.getDefense();
            target.terSerang(curentDamage);
        }else{
            target.terSerang(getAttack()-(target.getDefense()-penetration));
        }
    }
    @Override
    public void levelUp(){
        super.levelUp();
        penetration+=3;
        poison+=5;
    }
    @Override
    public void claimExp(Monster target){
        super.claimExp(target);
    }
    
    public void resetPoisonStatus(){
        poisonDuration=0;
    }
    @Override
    public String getRole(){
        return this.type;
    }
    public String showStatus(){
        return "Max hp / hp = " + getMaxHp()+"/"+this.getHealth() +
               "\nDefense = " + getDefense() +
               "\nAttack = " + getAttack() +
               "\nPenetration " + penetration +
               "\nPoison Damage = " + poison +
               "\n";
    }
}