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
 * Classe que representa o jogador no jogo
 * Herda de Personagem e implementa ConquistaSubject
 */
public class Player extends Personagem implements ConquistaSubject {
    private static final long serialVersionUID = 1L;
    private int playerMANA;
    private int moedas;
    private Arma armaEquipada;
    private Inventario inventario;
    private Set<String> conquistas;
    private List<ConquistaObserver> observers;
    private Map<String, Integer> estatisticas;

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

    private void inicializarEstatisticas() {
        estatisticas.put("monstrosDerrotados", 0);
        estatisticas.put("itensColetados", 0);
        estatisticas.put("salasExploradas", 0);
        estatisticas.put("danoCausado", 0);
        estatisticas.put("danoRecebido", 0);
    }

    @Override
    public void registrarObserver(ConquistaObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(ConquistaObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(String conquista) {
        for (ConquistaObserver observer : observers) {
            observer.atualizar(conquista);
        }
    }

    public void atualizarEstatistica(String chave, int valor) {
        estatisticas.put(chave, estatisticas.getOrDefault(chave, 0) + valor);
        verificarConquistas();
    }

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

    public void adicionarConquista(String conquista) {
        if (conquistas.add(conquista)) {
            System.out.println("Nova conquista desbloqueada: " + conquista);
            notificarObservers(conquista);
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        int danoAtaque = getPlayerDMG();
        alvo.receberDano(danoAtaque);
        System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + danoAtaque + " de dano!");
    }

    @Override
    public void printStats() {
        System.out.println("Player - HP: " + getHp() + "/" + getHpMaximo() + ", Dano: " + getPlayerDMG());
        System.out.println("Player - Arma equipada: " + armaEquipada.toString());
        System.out.println("Moedas: " + moedas);
        System.out.println("Mana: " + playerMANA + "/100");
    }

    // Métodos específicos do Player
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

    public void salvarProgresso(String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(this);
            System.out.println("Progresso salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar progresso: " + e.getMessage());
        }
    }

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
