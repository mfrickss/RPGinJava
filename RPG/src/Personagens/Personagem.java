// 1. Classes e Atributos (classe abstrata base)
// 2. Relacionamentos (herança)
// 7. Serialização
package Personagens;

import java.io.Serializable;

/**
 * Classe abstrata Personagem
 * Base para todos os personagens do jogo.
 * Implementa Serializable (serialização).
 * Serve de superclasse para Player e Monstro (herança).
 */
public abstract class Personagem implements Serializable {
    // Identificador de versão para serialização
    private static final long serialVersionUID = 1L;
    
    // Nome do personagem
    protected String nome;
    // Pontos de vida atuais
    protected int hp;
    // Pontos de vida máximos
    protected int hpMaximo;
    // Dano base do personagem
    protected int dano;
    // Status de vida
    protected boolean vivo;

    /**
     * Construtor do Personagem. Inicializa atributos básicos.
     */
    public Personagem(String nome, int hp, int dano) {
        this.nome = nome;
        this.hp = hp;
        this.hpMaximo = hp;
        this.dano = dano;
        this.vivo = true;
    }

    /**
     * Ataca outro personagem (polimorfismo).
     */
    public abstract void atacar(Personagem alvo);

    /**
     * Imprime as estatísticas do personagem.
     */
    public abstract void printStats();

    /**
     * Aplica dano ao personagem.
     */
    public void receberDano(int dano) {
        this.hp -= dano;
        if (this.hp <= 0) {
            this.hp = 0;
            this.vivo = false;
        }
    }

    /**
     * Cura o personagem.
     */
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