package Personagens.Monstros;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import Personagens.Player;

public class Esqueleto extends Monstro {
    private int lvl;

    public Esqueleto() {
        Random random = new Random();
        lvl = random.nextInt(3) + 1;

        if (lvl == 1) {
            monsterHP = 30;
        } else if (lvl == 2) {
            monsterHP = 40;
        } else {
            monsterHP = 50;
        }
    }

    public int calcularDano() {
        if (lvl == 1) {
            return ThreadLocalRandom.current().nextInt(6,  10);
        } else if (lvl == 2) {
            return ThreadLocalRandom.current().nextInt(9, 13);
        } else {
            return ThreadLocalRandom.current().nextInt(12, 16);
        }
    }

    public void atacar(Player player) {
        int dano = calcularDano();
        System.out.println("O Esqueleto causou " + dano + " de dano!");
        player.levarDMG(dano);
    }

    @Override
    public void printStats() {
        System.out.println("Esqueleto - HP: " + monsterHP + ", Nível: " + lvl);
    }
}
