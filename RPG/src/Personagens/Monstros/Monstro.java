package Personagens.Monstros;

import Personagens.Player;
import Personagens.Personagem;

public abstract class Monstro extends Personagem {
    protected int experiencia;
    protected String tipo;

    public Monstro(String nome, String tipo, int hp, int dano, int experiencia) {
        super(nome, hp, dano);
        this.tipo = tipo;
        this.experiencia = experiencia;
    }

    public int getMonsterHP() {
        return getHp();
    }

    public void levarDMG(int dano) {
        receberDano(dano);
    }

    @Override
    public void atacar(Personagem alvo) {
        int danoAtaque = getDano();
        alvo.receberDano(danoAtaque);
        System.out.println(getNome() + " atacou causando " + danoAtaque + " de dano!");
    }

    public void atacar(Player player) {
        atacar((Personagem) player);
    }

    public int getExperiencia() {
        return experiencia;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public abstract void printStats();
}
