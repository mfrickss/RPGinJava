package Personagens.Itens;
import Personagens.Player;

public class Arma extends Item{

    private int DMG;

    public Arma(String nome, String descricao, int valor, int DMG){
        super(nome, descricao, valor);
        this.DMG = DMG;
    }

    public int getDMG() {
        return DMG;
    }

    @Override
    public void usar(Player player) {
    }

    @Override
    public String toString(){
        return nome + " (Dano: " + DMG + ")";
    }
}
