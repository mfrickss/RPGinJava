package Monstros;

import java.util.Random;

public class Orc extends Monstro {
    public Orc() {
        Random random = new Random();
        int lvl = random.nextInt(3) + 1;

        if (lvl == 1) {
            hp = 70;
            dmg = 7;
        } else if (lvl == 2) {
            hp = 90;
            dmg = 9;
        } else {
            hp = 110;
            dmg = 11;
        }
    }

    @Override
    public void printStats() {
        System.out.println("Orc - HP: " + hp + ", Dano: " + dmg);
    }
}