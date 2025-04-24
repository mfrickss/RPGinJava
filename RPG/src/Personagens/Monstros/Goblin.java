package Personagens.Monstros;

import java.util.concurrent.ThreadLocalRandom;
import Personagens.Player;

public class Goblin extends Monstro {
    private int lvl;

    public Goblin() {
        lvl = ThreadLocalRandom.current().nextInt(1, 4); // Nível entre 1 e 3

        if (lvl == 1) {
            monsterHP = 20;
        } else if (lvl == 2) {
            monsterHP = 30;
        } else {
            monsterHP = 40;
        }
    }

    public int calcularDano() {
        if (lvl == 1) {
            return ThreadLocalRandom.current().nextInt(3, 6); // 3–5
        } else if (lvl == 2) {
            return ThreadLocalRandom.current().nextInt(6, 9); // 6–8
        } else {
            return ThreadLocalRandom.current().nextInt(9, 12); // 9–11
        }
    }

    @Override
    public void atacar(Player player) {
        int dano = calcularDano();
        System.out.println("O Goblin causou " + dano + " de dano!");
        player.levarDMG(dano);
    }

    @Override
    public void printStats() {
        System.out.println("Goblin - HP: " + monsterHP + ", Nível: " + lvl);
    }
}
