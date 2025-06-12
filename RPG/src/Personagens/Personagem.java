// 1. Classes e Atributos (classe abstrata base)
// 2. Relacionamentos (herança)
// 7. Serialização
package Personagens;

import java.io.Serializable;

/**
 * Classe abstrata base para todos os personagens do jogo
 * Define atributos e comportamentos comuns
 */
public abstract class Personagem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected String nome;
    protected int hp;
    protected int hpMaximo;
    protected int dano;
    protected boolean vivo;

    public Personagem(String nome, int hp, int dano) {
        this.nome = nome;
        this.hp = hp;
        this.hpMaximo = hp;
        this.dano = dano;
        this.vivo = true;
    }

    // Métodos abstratos (polimorfismo)
    public abstract void atacar(Personagem alvo);
    public abstract void printStats();

    // Métodos concretos
    public void receberDano(int dano) {
        this.hp -= dano;
        if (this.hp <= 0) {
            this.hp = 0;
            this.vivo = false;
        }
    }

    public void curar(int cura) {
        this.hp += cura;
        if (this.hp > this.hpMaximo) {
            this.hp = this.hpMaximo;
        }
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public int getHp() { return hp; }
    public int getHpMaximo() { return hpMaximo; }
    public int getDano() { return dano; }
    public boolean isVivo() { return vivo; }
    
    protected void setHp(int hp) { this.hp = hp; }
    protected void setDano(int dano) { this.dano = dano; }
} 