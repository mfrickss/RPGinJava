import Personagens.Monstros.*;  // Importa tudo dentro da pasta Personagens.Monstros
import java.util.Random;
import java.util.Scanner;
import Personagens.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        Player player = new Player();
        int choice;

        System.out.println("Você acorda em uma masmorra, não há memórias em sua mente, você não sabe como ou porquê está ali.\nAo olhar ao redor, você vê 3 caminhos: ");

        System.out.println("1. Uma portão que leva à um destino oculto pela escuridão! ");
        System.out.println("2. Uma abertura na parede, parece um buraco causado por algo grande!");
        System.out.println("3. Uma porta de ferro que parece muito pesada, é impossível saber o que tem atrás.");
        linha();
        System.out.print("Qual sua escolha?(1-3): ");
        choice = scanner.nextInt();

        if(choice == 1){
            System.out.println("Você passa pela escuridão e ao chegar ao que parece ser o fim, você se vê completamente sozinho.\nAo ascender sua tocha você se depara com inimigos...");
            linha();

            System.out.println("1. Começar combate");
            System.out.println("2. Abrir inventário");
            System.out.println("3. Fugir");
            linha();
            System.out.print("Qual sua escolha?(1-3): ");
            choice = scanner.nextInt();

            if (choice == 1){
                System.out.println("COMBATE");
                linha();
                startBattle(player);
            }

        }

    }

     static void linha(){
        System.out.println("===================================");
    }



    static void startBattle(Player player) {
        Monstro[] monstros = gerarMonstros(); // ← gera os monstros aqui

        for (Monstro monstro : monstros) {
            System.out.println("\nUm monstro apareceu!");
            monstro.printStats(); // ← mostra status do monstro

            while (monstro.getMonsterHP() > 0 && player.getPlayerHP() > 0) {
                System.out.println("\nSeu HP: " + player.getPlayerHP());
                System.out.println("HP do Monstro: " + monstro.getMonsterHP());
                System.out.println("1. Atacar");
                System.out.println("2. Inventário");
                System.out.println("3. Fugir (não funciona)");
                System.out.print("Escolha: ");
                int escolha = scanner.nextInt();

                if (escolha == 1) {
                    monstro.levarDMG(player.getPlayerDMG());
                    System.out.println("Você causou " + player.getPlayerDMG() + " de dano!");
                } else {
                    System.out.println("Você tentou fugir... mas não tem escapatória!");
                }

                if (monstro.getMonsterHP() > 0) {
                    player.levarDMG(monstro.getMonsterDMG());
                    System.out.println("O monstro atacou e causou " + monstro.getMonsterDMG() + " de dano!");
                }
            }

            if (player.getPlayerHP() <= 0) {
                System.out.println("Você foi derrotado...");
                return;
            } else {
                System.out.println("Você derrotou o monstro!");
            }
        }

        System.out.println("Você venceu todos os monstros da masmorra!");

    }

    static Monstro[] gerarMonstros() {
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

        return monstros; // ← retorna o array para ser usado no combate
    }

    }


