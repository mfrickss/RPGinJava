// 5. Padrões (Observer)
// 7. Serialização
package Personagens;

import java.util.List;
import java.io.Serializable;

/**
 * Interface Subject para o sistema de conquistas
 */
public interface ConquistaSubject extends Serializable {
    void registrarObserver(ConquistaObserver observer);
    void removerObserver(ConquistaObserver observer);
    void notificarObservers(String conquista);
    List<String> getConquistas();
} 