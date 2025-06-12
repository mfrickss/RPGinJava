package Personagens.Itens;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected String nome;
    protected String descricao;
    protected int valor;


    public Item(String nome, String descricao, int valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public int getValor() {
        return valor;
    }

    public abstract void usar(Personagens.Player player);

    @Override
    public String toString(){
        return nome + " - " + descricao + " - " + "(Valor: " + valor + " moedas)";
    }
}
