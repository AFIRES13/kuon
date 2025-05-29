package com.Monsters;

public class Goblin extends Mobs{
    public Goblin(int wave) {
        super(
            "Goblin " + wave,
            scaleHp(wave),
            scaleAttack(wave),
            scaleDefense(wave),
            scaleExp(wave)
        );
    }

    private static int scaleHp(int wave) {
        return 50 + (wave * 50);
    }

    private static int scaleAttack(int wave) {
        return 10 + (wave * 5);
    }

    private static int scaleDefense(int wave) {
        return 0 + (wave * 5);
    }

    private static int scaleExp(int wave) {
        return 10 + (wave * 5);
    }

        

    }
