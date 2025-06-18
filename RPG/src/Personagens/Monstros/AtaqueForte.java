package Personagens.Monstros;
import Personagens.Player;

/**
 * Estratégia de ataque forte (padrão Strategy).
 * Causa dano dobrado ao jogador.
 */
public class AtaqueForte implements AtaqueStrategy {
    @Override
    public void executarAtaque(Monstro monstro, Player player) {
        int dano = monstro.getDano() * 2;
        player.levarDMG(dano);
        System.out.println(monstro.getNome() + " usou um ATAQUE FORTE e causou " + dano + " de dano!");
    }
} 