package Personagens.Monstros;

import Personagens.Player;
import Personagens.Personagem;

/**
 * Classe abstrata Monstro
 * Base para todos os monstros do jogo.
 * Herda de Personagem (herança).
 * Utiliza o padrão Strategy para ataque (AtaqueStrategy).
 */
public abstract class Monstro extends Personagem {
    // Experiência concedida ao derrotar o monstro
    protected int experiencia;
    // Tipo do monstro
    protected String tipo;
    // Estratégia de ataque (padrão Strategy)
    protected AtaqueStrategy ataqueStrategy;

    /**
     * Construtor do Monstro. Inicializa atributos e estratégia de ataque.
     */
    public Monstro(String nome, String tipo, int hp, int dano, int experiencia) {
        super(nome, hp, dano);
        this.tipo = tipo;
        this.experiencia = experiencia;
        this.ataqueStrategy = new AtaqueSimples(); // Estratégia padrão
    }

    /**
     * Define a estratégia de ataque do monstro (padrão Strategy).
     */
    public void setAtaqueStrategy(AtaqueStrategy strategy) {
        this.ataqueStrategy = strategy;
    }

    /**
     * Executa o ataque usando a estratégia definida (padrão Strategy).
     */
    @Override
    public void atacar(Personagem alvo) {
        if (alvo instanceof Player) {
            ataqueStrategy.executarAtaque(this, (Player) alvo);
        }
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
