package Personagens.Monstros;

import Personagens.Player;

public abstract class Monstro {
    protected int monsterHP;

    public int getMonsterHP() {
        return monsterHP;
    }

    public void levarDMG(int dano) {
        monsterHP -= dano;
        if (monsterHP < 0) {
            monsterHP = 0;
        }
    }
    //POLIMORFISMO
    public abstract void atacar(Player player);

    public abstract void printStats();
}
