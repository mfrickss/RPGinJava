package model.Itens;
import model.Player;

public class Magia extends Item{

    private int DMG;

    public Magia(String nome, String descricao, int valor, int DMG){
        super(nome, descricao, valor);
        this.DMG = DMG;
    }

    public int getDMG() {
        return DMG;
    }

    @Override
    public void usar(Player player) {
        // Implementação futura
    }

    @Override
    public String toString(){
        return nome + " (Dano: " + DMG + ")";
    }
}
