package Personagens.Itens;
import Personagens.Player;
import Personagens.Monstros.*;

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

    public int getCustoMana() {
        return custoMana;
    }

    public void usarMagia(Player player, Monstro monstro) {
        if(player.getPlayerMana() < player.getMagiaEquipada().getCustoMana()){
            System.out.printf("Você está sem mana para usar: %s | %d|%d", player.getMagiaEquipada().getNome(), player.getPlayerMana(), player.getMagiaEquipada().getCustoMana());
            return;
        }
        player.setPlayerMana(player.custoUsoMagia());
        monstro.levarDMG(player.getMagiaEquipada().getDMG());
    }

    @Override
    public void usar(Player player) {

    }

    @Override
    public String toString(){
        return nome + " (Dano: " + DMG + ")";
    }
}
