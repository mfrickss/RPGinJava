package Personagens.Monstros;

import java.util.concurrent.ThreadLocalRandom;
import Personagens.Player;

public class Orc extends Monstro {
    private int lvl;

    public Orc() {
        lvl = ThreadLocalRandom.current().nextInt(1, 4); // Nível entre 1 e 3

        if (lvl == 1) {
            monsterHP = 50;
        } else if (lvl == 2) {
            monsterHP = 60;
        } else {
            monsterHP = 70;
        }
    }

    public int calcularDano() {
        if (lvl == 1) {
            return ThreadLocalRandom.current().nextInt(8, 11); // 8–10
        } else if (lvl == 2) {
            return ThreadLocalRandom.current().nextInt(11, 14); // 11–13
        } else {
            return ThreadLocalRandom.current().nextInt(14, 17); // 14–16
        }
    }

    @Override
    public void atacar(Player player) {
        int dano = calcularDano();
        System.out.println("O Orc causou " + dano + " de dano!");
        player.levarDMG(dano);
    }

    @Override
    public void printStats() {
        System.out.println("Orc - HP: " + monsterHP + ", Nível: " + lvl);
    }
}
