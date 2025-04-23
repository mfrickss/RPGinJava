package Personagens.Itens;

import Personagens.Player;

public class pocaoMana extends Item{
    private int quantidadeMana;

    public pocaoMana(String nome, String descricao, int valor, int quantidadeMana){
        super(nome, descricao, valor);
        this.quantidadeMana = quantidadeMana;
    }

    @Override
    public void usar(Player player) {
        player.recuperarMana(quantidadeMana);
        System.out.printf("Você usou %s e curou $d de HP.", nome, quantidadeMana);
    }
}
