package Personagens;

import Personagens.Itens.Arma;
import Personagens.Itens.Item;
import Personagens.Itens.pocaoCura;
import Personagens.Itens.pocaoMana;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Loja
 * Representa a loja do jogo.
 * Agrega listas de itens e armas (coleção List).
 * Relaciona-se com Player e Inventario (dependência/agregação).
 */
public class Loja {
    // Lista de itens disponíveis para compra (coleção List)
    private List<Item> itensDisponiveis;
    // Lista de armas disponíveis para compra (coleção List)
    private List<Arma> armasDisponiveis;

    /**
     * Construtor da Loja. Inicializa as listas de itens e armas.
     */
    public Loja() {
        this.itensDisponiveis = new ArrayList<>();
        this.armasDisponiveis = new ArrayList<>();
        inicializarLoja();
    }

    /**
     * Inicializa os itens e armas disponíveis na loja.
     */
    private void inicializarLoja() {
        // Armas
        armasDisponiveis.add(new Arma("Espada Longa", "Uma espada afiada e resistente", 150, 12, 18));
        armasDisponiveis.add(new Arma("Machado de Guerra", "Um machado pesado e poderoso", 200, 15, 20));
        armasDisponiveis.add(new Arma("Arco Curto", "Um arco ágil e preciso", 120, 10, 16));

        // Poções
        itensDisponiveis.add(new pocaoCura("Poção de Cura Menor", "Restaura 30 de HP", 30, 30));
        itensDisponiveis.add(new pocaoCura("Poção de Cura Maior", "Restaura 60 de HP", 60, 60));
        itensDisponiveis.add(new pocaoMana("Poção de Mana Menor", "Restaura 30 de Mana", 30, 30));
        itensDisponiveis.add(new pocaoMana("Poção de Mana Maior", "Restaura 60 de Mana", 60, 60));
    }

    /**
     * Mostra a loja e os itens disponíveis para o jogador.
     */
    public void mostrarLoja(Player player) {
        System.out.println("\n=== LOJA DO MERCADOR ===");
        System.out.println("Suas moedas: " + player.getMoedas());
        
        System.out.println("\n=== ARMAS DISPONÍVEIS ===");
        for (int i = 0; i < armasDisponiveis.size(); i++) {
            Arma arma = armasDisponiveis.get(i);
            System.out.println((i + 1) + ". " + arma.toString() + " - Preço: " + arma.getValor() + " moedas");
        }
        
        System.out.println("\n=== POÇÕES DISPONÍVEIS ===");
        for (int i = 0; i < itensDisponiveis.size(); i++) {
            Item item = itensDisponiveis.get(i);
            System.out.println((i + armasDisponiveis.size() + 1) + ". " + item.toString());
        }
        
        System.out.println("\n0. Sair da loja");
    }

    /**
     * Realiza a compra de um item ou arma pelo jogador.
     */
    public boolean comprarItem(Player player, int escolha) {
        if (escolha > 0 && escolha <= armasDisponiveis.size()) {
            // Compra de arma
            Arma armaEscolhida = armasDisponiveis.get(escolha - 1);
            if (player.gastarMoedas(armaEscolhida.getValor())) {
                player.getInventario().adicionarItem(armaEscolhida);
                return true;
            }
        } else if (escolha > armasDisponiveis.size() && escolha <= armasDisponiveis.size() + itensDisponiveis.size()) {
            // Compra de poção
            Item itemEscolhido = itensDisponiveis.get(escolha - armasDisponiveis.size() - 1);
            if (player.gastarMoedas(itemEscolhido.getValor())) {
                player.getInventario().adicionarItem(itemEscolhido);
                return true;
            }
        }
        return false;
    }
} 