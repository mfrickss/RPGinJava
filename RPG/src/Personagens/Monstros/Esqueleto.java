package Personagens.Monstros;

import java.util.Random;

public class Esqueleto extends Monstro {
    public Esqueleto() {
        Random random = new Random();
        int lvl = random.nextInt(3) + 1;

        if (lvl == 1) {
            monsterHP = 40;
            monsterDMG = 4;
        } else if (lvl == 2) {
            monsterHP = 50;
            monsterDMG = 5;
        } else {
            monsterHP = 60;
            monsterDMG = 6;
        }
    }

    @Override
    public void printStats() {
        System.out.println("Esqueleto - HP: " + monsterHP + ", Dano: " + monsterDMG);
    }
}