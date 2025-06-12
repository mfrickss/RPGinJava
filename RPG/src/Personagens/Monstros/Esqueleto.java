package Personagens.Monstros;

import java.util.concurrent.ThreadLocalRandom;
import Personagens.Player;
import Personagens.Personagem;

public class Esqueleto extends Monstro {
    private int lvl;

    public Esqueleto() {
        super("Esqueleto", "Morto-Vivo", 0, 0, 15);
        this.lvl = ThreadLocalRandom.current().nextInt(1, 4);
        
        int hp, dano;
        if (lvl == 1) {
            hp = 30;
            dano = 6;
        } else if (lvl == 2) {
            hp = 40;
            dano = 8;
        } else {
            hp = 50;
            dano = 10;
        }
        
        setHp(hp);
        setDano(dano);
    }

    public int calcularDano() {
        if (lvl == 1) {
            return ThreadLocalRandom.current().nextInt(4, 7);
        } else if (lvl == 2) {
            return ThreadLocalRandom.current().nextInt(7, 10);
        } else {
            return ThreadLocalRandom.current().nextInt(10, 13);
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = calcularDano();
        alvo.receberDano(dano);
        System.out.println("O " + getNome() + " causou " + dano + " de dano!");
    }

    @Override
    public void printStats() {
        System.out.println(getNome() + " - HP: " + getHp() + ", Nível: " + lvl + ", Tipo: " + getTipo());
    }
}
