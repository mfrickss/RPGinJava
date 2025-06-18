package model.Itens;
import java.util.concurrent.ThreadLocalRandom;
import model.Player;

public class Arma extends Item {
    private int danoMin;
    private int danoMax;

    public Arma(String nome, String descricao, int preco, int danoMin, int danoMax) {
        super(nome, descricao, preco);
        this.danoMin = danoMin;
        this.danoMax = danoMax;
    }

    public int getDMG() {
        return ThreadLocalRandom.current().nextInt(danoMin, danoMax + 1);
    }

    @Override
    public String toString() {
        return nome + " (Dano: " + danoMin + "-" + danoMax + ")";
    }

    @Override
    public void usar(Player player) {
        player.trocarArma(this);
    }
}
