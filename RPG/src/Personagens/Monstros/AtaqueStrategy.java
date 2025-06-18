package Personagens.Monstros;
import Personagens.Player;

/**
 * Interface Strategy para ataques de monstros.
 * Permite trocar o comportamento de ataque em tempo de execução.
 */
public interface AtaqueStrategy {
    void executarAtaque(Monstro monstro, Player player);
} 