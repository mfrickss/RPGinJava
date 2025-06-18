package model.Monstros;

import java.util.concurrent.ThreadLocalRandom;
import model.Player;
import model.Personagem;

public class Orc extends Monstro {
    private int lvl;

    public Orc() {
        super("Orc", "Humanoide Selvagem", 0, 0, 20);
        this.lvl = ThreadLocalRandom.current().nextInt(1, 4);
        
        int hp, dano;
        if (lvl == 1) {
            hp = 50;
            dano = 8;
        } else if (lvl == 2) {
            hp = 60;
            dano = 10;
        } else {
            hp = 70;
            dano = 12;
        }
        
        setHp(hp);
        setDano(dano);
    }

    public int calcularDano() {
        if (lvl == 1) {
            return ThreadLocalRandom.current().nextInt(6, 10);
        } else if (lvl == 2) {
            return ThreadLocalRandom.current().nextInt(9, 13);
        } else {
            return ThreadLocalRandom.current().nextInt(12, 16);
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
