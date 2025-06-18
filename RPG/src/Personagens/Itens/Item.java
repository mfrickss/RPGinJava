package Personagens.Itens;

import java.io.Serializable;

/**
 * Classe abstrata Item
 * Base para todos os itens do jogo.
 * Implementa Serializable (serialização).
 * Serve de superclasse para Arma, pocaoCura, pocaoMana, Magia (herança).
 */
public abstract class Item implements Serializable {
    // Identificador de versão para serialização
    private static final long serialVersionUID = 1L;
    
    // Nome do item
    protected String nome;
    // Descrição do item
    protected String descricao;
    // Valor do item (preço)
    protected int valor;

    /**
     * Construtor do Item. Inicializa atributos básicos.
     */
    public Item(String nome, String descricao, int valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    // Getters
    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public int getValor() {
        return valor;
    }

    /**
     * Usa o item (polimorfismo).
     */
    public abstract void usar(Personagens.Player player);

    /**
     * Retorna a representação textual do item.
     */
    @Override
    public String toString(){
        return nome + " - " + descricao + " - " + "(Valor: " + valor + " moedas)";
    }
}
