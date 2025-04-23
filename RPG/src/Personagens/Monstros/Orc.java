package Personagens.Monstros;

import java.util.Random;

public class Orc extends Monstro {
    public Orc() {
        Random random = new Random();
        int lvl = random.nextInt(3) + 1;

        if (lvl == 1) {
            monsterHP = 70;
            monsterDMG = 7;
        } else if (lvl == 2) {
            monsterHP = 90;
            monsterDMG = 9;
        } else {
            monsterHP = 110;
            monsterDMG = 11;
        }
    }

    @Override
    public void printStats() {
        System.out.println("Orc - HP: " + monsterHP + ", Dano: " + monsterDMG);
    }
}