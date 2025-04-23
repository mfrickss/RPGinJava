//import java.util.Scanner;
//import java.util.Random;
//
//public class maybe {
//
//    public static void main(String[] args) {
//
//        // VARIÁVEIS
//        int playerHP = 100, playerMana = 100, monsterHP = 150;
//        double playerDMG = 10, monsterDMG = 7;
//        String sucesso;
//
//        startBattle(playerDMG, playerHP, monsterHP, monsterDMG);
//    }
//
//    public static int lancarDado(String sucesso) { //Início função lançar dado
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Pressione Enter para lançar o dado!");
//        scanner.nextLine();
//
//        Random random = new Random();
//
//        int numeroLancado = random.nextInt(20) + 1;
//        System.out.println("Você tirou: " + numeroLancado);
//
//        if (numeroLancado <= 1) {
//            System.out.print("DESASTRE!");
//            sucesso = "desastre";
//        } else if (numeroLancado <= 5) {
//            System.out.print("Fraco!");
//            sucesso = "fraco";
//        } else if (numeroLancado <= 10) {
//            System.out.print("Comum!");
//            sucesso = "comum";
//        } else if (numeroLancado <= 15) {
//            System.out.print("Forte!\n");
//            sucesso = "forte";
//        } else if (numeroLancado <= 18) {
//            System.out.print("Muito forte!\n");
//            sucesso = "muito forte";
//        } else {
//            System.out.print("EXTREMO!\n");
//            sucesso = "extremo";
//        }
//
//        return numeroLancado;
//    } //Fim função lançar dado.
//
//    //FUNÇÃO ATACAR
//    public static double playerATQ(double playerDMG) { // Mudança para double
//        int numeroLancado = lancarDado(sucesso);
//
//
//
//        return playerDMG;
//    }
//
//    public static double monsterATQ(double monsterDMG) { // Mudança para double
//        Random random = new Random();
//
//        int numeroLancado = random.nextInt(20) + 1;
//
//        if (numeroLancado <= 1) {
//            monsterDMG *= 0;
//            System.out.print("DESASTRE! O Monstro não acertou o ataque!\n");
//        } else if (numeroLancado <= 5) {
//            System.out.printf("Fraco! O Monstro te arranhou e causou %.2f DMG!\n", monsterDMG);
//            monsterDMG *= 0.8;
//        } else if (numeroLancado <= 10) {
//            System.out.printf("Comum! O Monstro te acertou um soco e causou %.2f DMG!\n", monsterDMG);
//            monsterDMG *= 0.9;
//        } else if (numeroLancado <= 15) {
//            System.out.printf("Forte! O Monstro te dilacerou e causou %.2f DMG!\n", monsterDMG);
//            monsterDMG *= 1.15;
//        } else if (numeroLancado <= 18) {
//            System.out.printf("Muito forte! O Monstro te RETALHOU e causou %.2f DMG!\n", monsterDMG);
//            monsterDMG *= 1.4;
//        } else {
//            System.out.printf("EXTREMO! O Monstro te ANIQUILOU e causou %.2f DMG!\n", monsterDMG);
//            monsterDMG *= 2;
//        }
//        return monsterDMG;
//    }
//
//    public static void startBattle(double playerDMG, int playerHP, int monsterHP, double monsterDMG) { // Mudança para double
//        Scanner scanner = new Scanner(System.in);
//        int i = 1;
//        while (playerHP > 0 && monsterHP > 0) {
//
//            System.out.print("\nTURNO: " + i++);
//
//            // Personagens.Player atacando
//            System.out.println("\n--- SUA VEZ! ---");
//            playerDMG = playerATQ(playerDMG);
//            monsterHP -= playerDMG;
//            System.out.println("O monstro agora tem " + monsterHP + " HP.");
//
//            if (monsterHP <= 0) {
//                System.out.println("Você derrotou o monstro!");
//                break;
//            }
//
//            // Monstro atacando
//            System.out.println("\n--- VEZ DO INIMIGO ---");
//            monsterDMG = monsterATQ(monsterDMG);
//            playerHP -= monsterDMG;
//            System.out.println("Você agora tem " + playerHP + " HP.");
//
//            if (playerHP <= 0) {
//                System.out.println("Você foi derrotado pelo monstro.");
//                break;
//            }
//        }
//    }
//}
