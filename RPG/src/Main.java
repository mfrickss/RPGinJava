import Monstros.*;  // Importa tudo dentro da pasta Monstros
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Monstro[] monstros = new Monstro[3];


        for (int i = 0; i < monstros.length; i++) {
            int tipoMonstro = random.nextInt(3);

            if (tipoMonstro == 0) {
                monstros[i] = new Esqueleto();
            } else if (tipoMonstro == 1) {
                monstros[i] = new Orc();
            } else {
                monstros[i] = new Goblin();
            }
        }

        for (int i = 0; i < monstros.length; i++) {
            System.out.println("Monstro " + (i + 1) + " - Status:");
            monstros[i].printStats();
            System.out.println();
        }
    }
}