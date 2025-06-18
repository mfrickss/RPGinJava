package controller;

import model.*;
import model.Monstros.*;
import model.Itens.*;
import model.Loja;
import model.Inventario;
import view.ConquistaDisplay;
import observer.*;
import java.util.*;

// Classe principal do jogo RPG
public class Main {
    // Instância Singleton do jogo
    private static Main instance;
    // Scanner para entrada do usuário
    private static Scanner scanner;
    // Gerador de números aleatórios
    private static Random random;
    // Estatísticas globais do jogo
    private static Map<String, Integer> estatisticasGlobais = new HashMap<>();

    // Construtor privado para Singleton
    private Main() {
        scanner = new Scanner(System.in);
        random = new Random();
        inicializarEstatisticasGlobais();
    }

    // Retorna a instância Singleton
    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    // Retorna o Scanner global
    public static Scanner getScanner() {
        return scanner;
    }

    // Retorna o Random global
    public static Random getRandom() {
        return random;
    }

    // Inicializa as estatísticas globais
    private void inicializarEstatisticasGlobais() {
        estatisticasGlobais.put("jogosIniciados", 0);
        estatisticasGlobais.put("totalMonstrosDerrotados", 0);
        estatisticasGlobais.put("totalMoedasColetadas", 0);
        estatisticasGlobais.put("jogosConcluidos", 0);
    }

    // Método principal do jogo
    public static void main(String[] args) {
        Main game = Main.getInstance();
        estatisticasGlobais.put("jogosIniciados", estatisticasGlobais.get("jogosIniciados") + 1);
        Player player = new Player();
        Loja loja = new Loja();
        int salaAtual = 0;
        int totalSalas = 10;

        // Configura o sistema de conquistas
        ConquistaDisplay display = new ConquistaDisplay("Aventureiro");
        player.registrarObserver(display);

        // Adiciona poções iniciais ao inventário
        player.getInventario().adicionarItem(new pocaoCura("Poção de Cura Menor", "Restaura 30 de HP", 30, 30));
        player.getInventario().adicionarItem(new pocaoMana("Poção de Mana Menor", "Restaura 30 de Mana", 30, 30));

        linha();
        System.out.println("Você acorda de frente para uma masmorra, não há memórias em sua mente, você não sabe como ou porquê está ali.\nVocê tem apenas algumas escolhas.");

        // Loop principal do jogo
        while (salaAtual < totalSalas && player.getPlayerHP() > 0) {
            int choice = -1;

            linha();
            System.out.println("1. Entrar na masmorra ");
            System.out.println("2. Ao olhar para o lado, você vê uma figura humanoide, falar com tal?");
            System.out.println("3. Fugir");
            System.out.println("4. Salvar Progresso");
            System.out.println("5. Carregar Progresso");
            System.out.println("6. Ver Estatísticas");
            System.out.println("7. Sair do Jogo");
            linha();

            try {
                System.out.print("Qual sua escolha?(1-7): ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
                continue;
            }

            // Decisão do menu principal
            switch (choice) {
                case 1:
                    salaAtual = explorarMasmorra(player, salaAtual);
                    break;
                case 2:
                    interagirComMercador(player, loja);
                    break;
                case 3:
                    salaAtual = chanceFugir(salaAtual);
                    break;
                case 4:
                    player.salvarProgresso("savegame.dat");
                    break;
                case 5:
                    Player loadedPlayer = Player.carregarProgresso("savegame.dat");
                    if (loadedPlayer != null) {
                        player = loadedPlayer;
                        player.registrarObserver(display);
                    }
                    break;
                case 6:
                    mostrarEstatisticas(player);
                    break;
                case 7:
                    System.out.println("Obrigado por jogar!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        // Fim do jogo
        if (salaAtual >= totalSalas) {
            System.out.println("Parabéns! Você completou a masmorra!");
            estatisticasGlobais.put("jogosConcluidos", estatisticasGlobais.get("jogosConcluidos") + 1);
        }

        exibirEstatisticasFinais(player);
        scanner.close();
    }

    // Imprime uma linha separadora
    static void linha() {
        System.out.println("===================================");
    }

    // Explora a masmorra e apresenta opções ao jogador
    static int explorarMasmorra(Player player, int salaAtual) {
        salaAtual = 1;
        player.atualizarEstatistica("salasExploradas", 1);
        System.out.println("Você passa pela escuridão e ao chegar ao que parece ser o fim, você se vê completamente sozinho.\nAo ascender sua tocha você se depara com inimigos...");
        linha();

        System.out.println("1. Começar combate");
        System.out.println("2. Abrir inventário");
        System.out.println("3. Fugir");
        linha();
        
        try {
            System.out.print("Qual sua escolha?(1-3): ");
            int subChoice = Integer.parseInt(scanner.nextLine());
            
            switch (subChoice) {
                case 1:
                    System.out.println("COMBATE");
                    linha();
                    salaAtual = startBattle(player, salaAtual);
                    break;
                case 2:
                    player.getInventario().abrirInventario(player, scanner);
                    break;
                case 3:
                    salaAtual = chanceFugir(salaAtual);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Digite um número.");
        }
        
        return salaAtual;
    }

    // Interação com o mercador (loja ou história)
    static void interagirComMercador(Player player, Loja loja) {
        linha();
        System.out.println("Você solta um tímido 'Olá?', em seguida, ouve uma voz grunhida.");
        linha();
        System.out.println("'Oláááá! Faz tempo que não vejo um desafiante novo. Você me parece fraco. Quer comprar alguns itens? hihihihihi'");
        System.out.println("1. Sim");
        System.out.println("2. Falar");
        System.out.println("3. Sair");
        
        try {
            System.out.print("Escolha: ");
            int lojaChoice = Integer.parseInt(scanner.nextLine());
            
            switch (lojaChoice) {
                case 1:
                    boolean naLoja = true;
                    while (naLoja) {
                        loja.mostrarLoja(player);
                        try {
                            System.out.print("Escolha um item para comprar (0 para sair): ");
                            int escolhaItem = Integer.parseInt(scanner.nextLine());
                            if (escolhaItem == 0) {
                                naLoja = false;
                            } else {
                                loja.comprarItem(player, escolhaItem);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida! Digite um número.");
                        }
                    }
                    break;
                case 2:
                    contarHistoriaDoMercador();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Digite um número.");
        }
    }

    // Exibe a história do mercador
    static void contarHistoriaDoMercador() {
        System.out.println("\n'Ah, você quer saber sobre esta masmorra? Hmm...'");
        System.out.println("O mercador se aproxima e sussurra:");
        System.out.println("'Esta masmorra é antiga, muito antiga. Dizem que foi construída por uma civilização perdida.");
        System.out.println("Eles guardavam um tesouro imenso, mas algo deu errado...'");
        System.out.println("O mercador faz uma pausa e olha ao redor, nervoso.");
        System.out.println("'Os monstros que você vê não são naturais. Eles foram criados, transformados...");
        System.out.println("E o pior é que eles continuam se multiplicando. Cada vez mais fortes, cada vez mais numerosos.'");
        System.out.println("'Eu fico aqui para ajudar aventureiros como você. Alguém precisa parar isso antes que seja tarde demais.'");
        System.out.println("'Se você conseguir chegar ao final da masmorra, talvez encontre respostas... e o tesouro, é claro!'");
        System.out.println("O mercador sorri, revelando dentes amarelados.");
        System.out.println("'Mas cuidado, jovem aventureiro. Nem tudo é o que parece ser...'");
        linha();
    }

    // Inicia o combate contra um grupo de monstros
    static int startBattle(Player player, int salaAtual) {
        Monstro[] monstros = MonstroFactory.criarGrupoDeMonstros(3);

        for (Monstro monstro : monstros) {
            System.out.println("\nUm monstro apareceu!");
            monstro.printStats();

            // Loop de combate
            while (monstro.getHp() > 0 && player.getPlayerHP() > 0) {
                System.out.println("\nSeu HP: " + player.getPlayerHP());
                System.out.println("HP do Monstro: " + monstro.getHp());
                System.out.println("1. Atacar");
                System.out.println("2. Inventário");
                System.out.println("3. Fugir");

                try {
                    System.out.print("Escolha: ");
                    int escolha = Integer.parseInt(scanner.nextLine());

                    switch (escolha) {
                        case 1:
                            int dano = player.getPlayerDMG();
                            monstro.receberDano(dano);
                            player.atualizarEstatistica("danoCausado", dano);
                            System.out.println("Você causou " + dano + " de dano!");
                            break;
                        case 2:
                            player.getInventario().abrirInventario(player, scanner);
                            break;
                        case 3:
                            int novaSala = chanceFugir(salaAtual);
                            if (novaSala < salaAtual) {
                                salaAtual = novaSala;
                                System.out.println("Você fugiu.");
                                return salaAtual;
                            }
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Digite um número.");
                    continue;
                }

                if (monstro.getHp() > 0) {
                    monstro.atacar(player);
                }
            }

            // Verifica se o jogador foi derrotado
            if (player.getPlayerHP() <= 0) {
                System.out.println("Você foi derrotado...");
                return salaAtual;
            } else {
                System.out.println("Você derrotou o monstro!");
                player.atualizarEstatistica("monstrosDerrotados", 1);
                estatisticasGlobais.put("totalMonstrosDerrotados", 
                    estatisticasGlobais.get("totalMonstrosDerrotados") + 1);
                
                int recompensa = random.nextInt(20) + 10;
                player.adicionarMoedas(recompensa);
                estatisticasGlobais.put("totalMoedasColetadas", 
                    estatisticasGlobais.get("totalMoedasColetadas") + recompensa);
            }
        }

        System.out.println("Você venceu todos os monstros da masmorra!");
        salaAtual++;
        return salaAtual;
    }

    // Tenta fugir da sala, com chance de sucesso
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

    // Exibe estatísticas do jogador
    static void mostrarEstatisticas(Player player) {
        System.out.println("\n=== Estatísticas do Jogador ===");
        player.printStats();
        System.out.println(player.getEstatisticas());
        System.out.println("==============================\n");
    }

    // Exibe estatísticas finais ao terminar o jogo
    static void exibirEstatisticasFinais(Player player) {
        System.out.println("\n=== Estatísticas Finais ===");
        player.printStats();
        System.out.println(player.getEstatisticas());
        System.out.println("Estatísticas Globais: " + estatisticasGlobais);
        System.out.println("========================\n");
    }
}
