package model.Monstros;

import model.Player;

/**
 * Estratégia de ataque simples (padrão Strategy).
 */
public class AtaqueSimples implements AtaqueStrategy {
    @Override
    public void executarAtaque(Monstro monstro, Player player) {
        int dano = monstro.getDano();
        player.levarDMG(dano);
        System.out.println(monstro.getNome() + " atacou causando " + dano + " de dano!");
    }
} 