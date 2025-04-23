package Personagens.Monstros;

import java.util.Random;

public class Goblin extends Monstro {
    public Goblin() {
        Random random = new Random();
        int lvl = random.nextInt(3) + 1;

        if (lvl == 1) {
            monsterHP = 20;
            monsterDMG = 2;
        } else if (lvl == 2) {
            monsterHP = 30;
            monsterDMG = 3;
        } else {
            monsterHP = 40;
            monsterDMG = 4;
        }
    }

    @Override
    public void printStats() {
        System.out.println("Goblin - HP: " + monsterHP + ", Dano: " + monsterDMG);
    }
}