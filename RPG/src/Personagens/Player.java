package Personagens;

import Personagens.Itens.Arma;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

/**
 * Classe Player
 * Representa o jogador principal do jogo.
 * Herda de Personagem (herança).
 * Implementa ConquistaSubject (padrão Observer).
 * Possui composição com Inventario e Arma.
 * É serializável (implementa Serializable).
 */
public class Player extends Personagem implements ConquistaSubject {
    // Identificador de versão para serialização
    private static final long serialVersionUID = 1L;

    // Mana do jogador (atributo específico de Player)
    private int playerMANA;
    // Moedas do jogador (atributo específico de Player)
    private int moedas;
    // Arma equipada pelo jogador (composição)
    private Arma armaEquipada;
    // Inventário do jogador (composição)
    private Inventario inventario;
    // Conjunto de conquistas desbloqueadas (coleção Set)
    private Set<String> conquistas;
    // Observadores de conquistas (padrão Observer)
    private List<ConquistaObserver> observers;
    // Estatísticas do jogador (coleção Map)
    private Map<String, Integer> estatisticas;

    /**
     * Construtor do Player. Inicializa atributos e coleções.
     */
    public Player() {
        super("Aventureiro", 100, 10);
        this.playerMANA = 100;
        this.moedas = 50;
        this.armaEquipada = new Arma("Adaga de Ferro", "Uma adaga brilhante e pequena", 100, 8, 13);
        this.inventario = new Inventario(10);
        this.conquistas = new HashSet<>();
        this.observers = new ArrayList<>();
        this.estatisticas = new HashMap<>();
        inicializarEstatisticas();
    }

    /**
     * Inicializa as estatísticas do jogador (coleção Map).
     */
    private void inicializarEstatisticas() {
        estatisticas.put("monstrosDerrotados", 0);
        estatisticas.put("itensColetados", 0);
        estatisticas.put("salasExploradas", 0);
        estatisticas.put("danoCausado", 0);
        estatisticas.put("danoRecebido", 0);
    }

    /**
     * Registra um observador de conquistas (padrão Observer).
     */
    @Override
    public void registrarObserver(ConquistaObserver observer) {
        observers.add(observer);
    }

    /**
     * Remove um observador de conquistas (padrão Observer).
     */
    @Override
    public void removerObserver(ConquistaObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifica todos os observadores sobre uma nova conquista (padrão Observer).
     */
    @Override
    public void notificarObservers(String conquista) {
        for (ConquistaObserver observer : observers) {
            observer.atualizar(conquista);
        }
    }

    /**
     * Atualiza uma estatística do jogador (coleção Map).
     */
    public void atualizarEstatistica(String chave, int valor) {
        estatisticas.put(chave, estatisticas.getOrDefault(chave, 0) + valor);
        verificarConquistas();
    }

    /**
     * Verifica e adiciona conquistas ao jogador (coleção Set).
     */
    private void verificarConquistas() {
        if (estatisticas.get("monstrosDerrotados") >= 10 && !conquistas.contains("Caçador de Monstros")) {
            adicionarConquista("Caçador de Monstros");
        }
        if (estatisticas.get("itensColetados") >= 20 && !conquistas.contains("Colecionador")) {
            adicionarConquista("Colecionador");
        }
        if (estatisticas.get("salasExploradas") >= 5 && !conquistas.contains("Explorador")) {
            adicionarConquista("Explorador");
        }
    }

    /**
     * Adiciona uma conquista ao conjunto (coleção Set) e notifica observers.
     */
    public void adicionarConquista(String conquista) {
        if (conquistas.add(conquista)) {
            System.out.println("Nova conquista desbloqueada: " + conquista);
            notificarObservers(conquista);
        }
    }

    /**
     * Ataca outro personagem (polimorfismo).
     */
    @Override
    public void atacar(Personagem alvo) {
        int danoAtaque = getPlayerDMG();
        alvo.receberDano(danoAtaque);
        System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + danoAtaque + " de dano!");
    }

    /**
     * Imprime as estatísticas do jogador.
     */
    @Override
    public void printStats() {
        System.out.println("Player - HP: " + getHp() + "/" + getHpMaximo() + ", Dano: " + getPlayerDMG());
        System.out.println("Player - Arma equipada: " + armaEquipada.toString());
        System.out.println("Moedas: " + moedas);
        System.out.println("Mana: " + playerMANA + "/100");
    }

    // Métodos de acesso e manipulação de atributos específicos do Player
    public int getPlayerHP() {
        return getHp();
    }

    public int getPlayerMaxHP() {
        return getHpMaximo();
    }

    public int getPlayerDMG() {
        return armaEquipada.getDMG();
    }

    public void levarDMG(int dano) {
        receberDano(dano);
        atualizarEstatistica("danoRecebido", dano);
    }

    public void recuperarHP(int cura) {
        curar(cura);
        System.out.printf("\nVocê recuperou %d HP. %d|%d", cura, getHp(), getHpMaximo());
    }

    public void recuperarMana(int manaRegen) {
        this.playerMANA += manaRegen;
        if (this.playerMANA > 100) {
            this.playerMANA = 100;
        }
        System.out.printf("\nVocê recuperou %d de Mana. %d|100", manaRegen, playerMANA);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void trocarArma(Arma novaArma) {
        this.armaEquipada = novaArma;
        setDano(novaArma.getDMG());
        System.out.println("Você equipou " + novaArma);
    }

    public int getMoedas() {
        return moedas;
    }

    public void adicionarMoedas(int quantidade) {
        this.moedas += quantidade;
        System.out.println("Você recebeu " + quantidade + " moedas!");
    }

    public boolean gastarMoedas(int quantidade) {
        if (this.moedas >= quantidade) {
            this.moedas -= quantidade;
            System.out.println("Você gastou " + quantidade + " moedas!");
            return true;
        }
        System.out.println("Você não tem moedas suficientes!");
        return false;
    }

    @Override
    public List<String> getConquistas() {
        return new ArrayList<>(conquistas);
    }

    public Map<String, Integer> getEstatisticas() {
        return new HashMap<>(estatisticas);
    }

    /**
     * Salva o progresso do jogador em arquivo (serialização).
     */
    public void salvarProgresso(String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(this);
            System.out.println("Progresso salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar progresso: " + e.getMessage());
        }
    }

    /**
     * Carrega o progresso do jogador de arquivo (serialização).
     */
    public static Player carregarProgresso(String nomeArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            Player player = (Player) ois.readObject();
            System.out.println("Progresso carregado com sucesso!");
            return player;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar progresso: " + e.getMessage());
            return new Player();
        }
    }
}
