package Monstros;

import java.util.Random;

public class Goblin extends Monstro {
    public Goblin() {
        Random random = new Random();
        int lvl = random.nextInt(3) + 1;

        if (lvl == 1) {
            hp = 20;
            dmg = 2;
        } else if (lvl == 2) {
            hp = 30;
            dmg = 3;
        } else {
            hp = 40;
            dmg = 4;
        }
    }

    @Override
    public void printStats() {
        System.out.println("Goblin - HP: " + hp + ", Dano: " + dmg);
    }
}