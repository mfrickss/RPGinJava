import Personagens.Monstros.*;
import java.util.Random;
import java.util.Scanner;
import Personagens.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        Player player = new Player();
        int salaAtual = 0;
        int totalSalas = 10;
        int totalMoedas = 0;

        linha();
        System.out.println("Você acorda de frente para uma masmorra, não há memórias em sua mente, você não sabe como ou porquê está ali.\nVocê tem apenas 3 escolhas.");

        while (salaAtual < totalSalas && player.getPlayerHP() > 0) {
            int choice;

            linha();
            System.out.println("1. Entrar na masmorra ");
            System.out.println("2. Ao olhar para o lado, você vê uma figura humanoide, falar com tal?");
            System.out.println("3. Fugir");
            linha();
            //TRY CATCH EM EXECUÇÃO
            try {
                System.out.print("Qual sua escolha?(1-3): ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
                continue;
            }

            if (choice == 1) {
                salaAtual = 1;
                System.out.println("Você passa pela escuridão e ao chegar ao que parece ser o fim, você se vê completamente sozinho.\nAo ascender sua tocha você se depara com inimigos...");
                linha();

                System.out.println("1. Começar combate");
                System.out.println("2. Abrir inventário");
                System.out.println("3. Fugir");
                linha();
                int subChoice;
                try {
                    System.out.print("Qual sua escolha?(1-3): ");
                    subChoice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Digite um número.");
                    continue;
                }
                if (subChoice == 1) {
                    System.out.println("COMBATE");
                    linha();
                    salaAtual = startBattle(player, salaAtual);
                }
            } else if (choice == 2) {
                linha();
                System.out.println("Você solta um tímido 'Olá?', em seguida, ouve uma voz grunhida.");
                linha();
                System.out.println("'Oláááá! Faz tempo que não vejo um desafiante novo. Você me parece fraco. Quer comprar alguns itens? hihihihihi'");
                System.out.println("1. Sim");
                System.out.println("2. Falar");
                System.out.println("3. Sair");
                int lojaChoice = -1;
                try {
                    System.out.print("Escolha: ");
                    lojaChoice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Digite um número.");
                    continue;
                }
                if (lojaChoice == 1){
                    System.out.println("LOJA");
                } else if (lojaChoice == 2) {
                    System.out.println("HISTÓRIA");
                } else {
                    salaAtual = 0;
                }
            } else if (choice == 3) {
                salaAtual = chanceFugir(salaAtual);
            }
        }
    }

    static void linha() {
        System.out.println("===================================");
    }

    static int startBattle(Player player, int salaAtual) {
        Monstro[] monstros = gerarMonstros();

        for (Monstro monstro : monstros) {
            System.out.println("\nUm monstro apareceu!");
            monstro.printStats();

            while (monstro.getMonsterHP() > 0 && player.getPlayerHP() > 0) {
                System.out.println("\nSeu HP: " + player.getPlayerHP() + "|" + player.getPlayerMaxHP());
                System.out.println("\nSua Mana: " + player.getPlayerMana() + "|" + player.getPlayerManaMax());
                System.out.println("HP do Monstro: " + monstro.getMonsterHP());
                System.out.println("1. Atacar");
                System.out.println("2. Inventário");
                System.out.println("3. Fugir");

                int escolha;
                try {
                    System.out.print("Escolha: ");
                    escolha = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Digite um número.");
                    continue;
                }

                if (escolha == 1) {
                    System.out.println("1. Atacar com espada");
                    System.out.println("2. Usar magia");
                    int choice;
                    try {
                        System.out.print("Escolha: ");
                        choice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida! Digite um número.");
                        continue;
                    }
                    if(choice == 1){
                        monstro.levarDMG(player.getPlayerArmaDMG());
                        System.out.println("Você causou " + player.getPlayerArmaDMG() + " de dano com a " + player.getArmaEquipada().getNome() + "!");
                    }else{
                        player.getMagiaEquipada().usarMagia(player, monstro);
                        System.out.println("Você causou " + player.getPlayerMagiaDMG() + " de dano com a " + player.getMagiaEquipada().getNome() + "!");
                    }

                } else if (escolha == 3) {
                    int novaSala = chanceFugir(salaAtual);
                    if (novaSala < salaAtual) {
                        salaAtual = novaSala;
                        System.out.println("Você fugiu.");
                        return salaAtual;
                    }
                }

                if (monstro.getMonsterHP() > 0) {
                    monstro.atacar(player);
                }
            }

            if (player.getPlayerHP() <= 0) {
                System.out.println("Você foi derrotado...");
                return salaAtual;
            } else {
                System.out.println("Você derrotou o monstro!");
            }
        }

        System.out.println("Você venceu todos os monstros da masmorra!");
        salaAtual++;
        return salaAtual;
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
        return monstros;
    }

    static int chanceFugir(int salaAtual) {
        int chance = random.nextInt(9) + 1;
        if (chance >= 6) {
            salaAtual--;
            System.out.println("Você conseguiu fugir!");
        } else {
            System.out.println("Você tentou fugir mas os monstros te encurralaram. LUTE!");
        }
        return salaAtual;
    }
}
