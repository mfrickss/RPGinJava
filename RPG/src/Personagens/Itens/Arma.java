package Personagens.Itens;
import java.util.concurrent.ThreadLocalRandom;

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
    public void usar(Personagens.Player player) {
        System.out.println("Você usou a arma: " + nome);
    }
}
