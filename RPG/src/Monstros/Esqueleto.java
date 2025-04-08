package Monstros;

import java.util.Random;

public class Esqueleto extends Monstro {
    public Esqueleto() {
        Random random = new Random();
        int lvl = random.nextInt(3) + 1;

        if (lvl == 1) {
            hp = 40;
            dmg = 4;
        } else if (lvl == 2) {
            hp = 50;
            dmg = 5;
        } else {
            hp = 60;
            dmg = 6;
        }
    }

    @Override
    public void printStats() {
        System.out.println("Esqueleto - HP: " + hp + ", Dano: " + dmg);
    }
}