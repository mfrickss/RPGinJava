package model.Monstros;

import java.util.concurrent.ThreadLocalRandom;
import model.Player;
import model.Personagem;

public class Goblin extends Monstro {
    private int lvl;

    public Goblin() {
        super("Goblin", "Criatura Pequena", 0, 0, 10);
        this.lvl = ThreadLocalRandom.current().nextInt(1, 4);
        
        int hp, dano;
        if (lvl == 1) {
            hp = 20;
            dano = 4;
        } else if (lvl == 2) {
            hp = 30;
            dano = 7;
        } else {
            hp = 40;
            dano = 10;
        }
        
        setHp(hp);
        setDano(dano);
        this.ataqueStrategy = new AtaqueSimples();
    }

    public int calcularDano() {
        if (lvl == 1) {
            return ThreadLocalRandom.current().nextInt(3, 6);
        } else if (lvl == 2) {
            return ThreadLocalRandom.current().nextInt(6, 9);
        } else {
            return ThreadLocalRandom.current().nextInt(9, 12);
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        super.atacar(alvo);
    }

    @Override
    public void printStats() {
        System.out.println(getNome() + " - HP: " + getHp() + ", Nível: " + lvl + ", Tipo: " + getTipo());
    }
}
