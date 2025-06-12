// 5. Padrões (Observer)
// 7. Serialização
package Personagens;

import java.io.Serializable;

/**
 * Interface Observer para o sistema de conquistas
 */
public interface ConquistaObserver extends Serializable {
    void atualizar(String conquista);
} 