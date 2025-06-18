// 5. Padrões (Observer)
// 7. Serialização
package view;

import java.io.Serializable;
import observer.ConquistaObserver;

/**
 * Classe que exibe as conquistas do jogador
 * Implementa o padrão Observer
 */
public class ConquistaDisplay implements ConquistaObserver, Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;

    public ConquistaDisplay(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String conquista) {
        System.out.println("\n=== Nova Conquista Desbloqueada ===");
        System.out.println("Jogador: " + nome);
        System.out.println("Conquista: " + conquista);
        System.out.println("===============================\n");
    }
} 