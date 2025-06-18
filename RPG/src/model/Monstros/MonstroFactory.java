// 5. Padrões (Factory)
package model.Monstros;

import java.util.Random;

/**
 * Factory para criação de monstros
 * Implementa o padrão Factory Method
 */
public class MonstroFactory {
    private static final Random random = new Random();
    
    public enum TipoMonstro {
        GOBLIN, ORC, ESQUELETO
    }
    
    public static Monstro criarMonstro(TipoMonstro tipo) {
        switch (tipo) {
            case GOBLIN:
                return new Goblin();
            case ORC:
                return new Orc();
            case ESQUELETO:
                return new Esqueleto();
            default:
                return new Goblin();
        }
    }
    
    public static Monstro criarMonstroAleatorio() {
        TipoMonstro[] tipos = TipoMonstro.values();
        TipoMonstro tipoAleatorio = tipos[random.nextInt(tipos.length)];
        return criarMonstro(tipoAleatorio);
    }
    
    public static Monstro[] criarGrupoDeMonstros(int quantidade) {
        Monstro[] monstros = new Monstro[quantidade];
        for (int i = 0; i < quantidade; i++) {
            monstros[i] = criarMonstroAleatorio();
        }
        return monstros;
    }
} 