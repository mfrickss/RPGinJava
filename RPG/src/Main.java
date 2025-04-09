import Monstros.*;  // Importa tudo dentro da pasta Monstros
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Random random = new Random();
        Monstro[] monstros = new Monstro[3];
        int choice;

        System.out.println("Você acorda em uma masmorra, não há memórias em sua mente, você não sabe como ou porquê está ali.\nAo olhar ao redor, você vê 3 caminhos: ");

        System.out.println("1. Uma portão que leva à um destino oculto pela escuridão! ");
        System.out.println("2. Uma abertura na parede, parece um buraco causado por algo grande!");
        System.out.println("3. Uma porta de ferro que parece muito pesada, é impossível saber o que tem atrás.");
        linha();
        System.out.print("Qual sua escolha?(1-3): ");
        choice = scanner.nextInt();

        if(choice == 1){

        }





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

     static void linha(){
        System.out.println("===================================");
    }
}