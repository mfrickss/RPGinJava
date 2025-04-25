package Personagens.Itens;
import Personagens.Player;

public class Magia extends Item{

    private int DMG;
    private int custoMana;

    public Magia(String nome, String descricao, int valor, int DMG, int custoMana){
        super(nome, descricao, valor);
        this.DMG = DMG;
        this.custoMana = custoMana;
    }

    public int getDMG() {
        return DMG;
    }

    private int getCustoMana() {
        return custoMana;
    }

    public void usarMagia(Player player) {
        if(player.getPlayerMana() <= 0){
            System.out.println("Sem mana para usar " + nome + "!");
        }
        int i = player.getPlayerMana() - custoMana;
    }

    @Override
    public String toString(){
        return nome + " (Dano: " + DMG + ")";
    }
}
