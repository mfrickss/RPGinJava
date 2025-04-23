package Personagens.Itens;

import Personagens.Player;

public class pocaoCura extends Item{
    private int quantidadeCura;

    public pocaoCura(String nome, String descricao, int valor, int quantidadeCura){
        super(nome, descricao, valor);
        this.quantidadeCura = quantidadeCura;
    }

    @Override
    public void usar(Player player) {
        player.recuperarHP(quantidadeCura);
        System.out.printf("Você usou %s e curou $d de HP.", nome, quantidadeCura);
    }
}
