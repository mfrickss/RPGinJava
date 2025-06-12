package Personagens;

import Personagens.Itens.Arma;
import Personagens.Itens.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Item> itens;
    private int capacidadeMax;

    public Inventario(int capacidadeMax) {
        this.itens = new ArrayList<>();
        this.capacidadeMax = capacidadeMax;
    }

    public Inventario() {
        this(20); // Capacidade padrão
    }

    // 4. Métodos de Coleções
    public boolean adicionarItem(Item item) {
        if (itens.size() < capacidadeMax) {
            itens.add(item);
            System.out.printf("O item %s foi adicionado ao inventário.\n", item.getNome());
            return true;
        } else {
            System.out.println("Seu inventário está cheio!");
            return false;
        }
    }

    public void removerItem(Item item) {
        if (itens.remove(item)) {
            System.out.println("Item removido: " + item.getNome());
        }
    }

    // Método contains
    public boolean contemItem(String nomeItem) {
        return itens.stream().anyMatch(item -> item.getNome().equalsIgnoreCase(nomeItem));
    }

    // Método size
    public int getTamanho() {
        return itens.size();
    }

    // Método clear
    public void limparInventario() {
        itens.clear();
        System.out.println("Inventário limpo!");
    }

    // Método sort
    public void ordenarPorNome() {
        Collections.sort(itens, Comparator.comparing(Item::getNome));
        System.out.println("Inventário ordenado por nome!");
    }

    public void ordenarPorValor() {
        Collections.sort(itens, Comparator.comparing(Item::getValor).reversed());
        System.out.println("Inventário ordenado por valor!");
    }

    // Método indexOf
    public int encontrarIndice(String nomeItem) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getNome().equalsIgnoreCase(nomeItem)) {
                return i;
            }
        }
        return -1;
    }

    // Filtrar itens usando stream
    public List<Item> filtrarPorTipo(Class<?> tipo) {
        return itens.stream()
                .filter(tipo::isInstance)
                .collect(Collectors.toList());
    }

    public List<Arma> obterArmas() {
        return itens.stream()
                .filter(item -> item instanceof Arma)
                .map(item -> (Arma) item)
                .collect(Collectors.toList());
    }

    public void mostrarInventario() {
        if (itens.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
            return;
        }
        System.out.println("==|Seu inventário|==");
        System.out.printf("Itens: %d | Capacidade: %d\n", itens.size(), capacidadeMax);

        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            System.out.println((i + 1) + ". " + item.getNome());
            System.out.println("   Descrição: " + item.getDescricao());
            System.out.println("   Valor: " + item.getValor());

            if (item instanceof Arma) {
                Arma arma = (Arma) item;
                System.out.println("   DMG: " + arma.getDMG());
            }
        }
        System.out.println("=======================");
    }

    public void usarItem(int indice, Player player) {
        if (indice >= 0 && indice < itens.size()) {
            Item item = itens.get(indice);
            item.usar(player);

            if (!(item instanceof Arma)) {
                removerItem(item);
                System.out.println("Item consumido.");
            }
        } else {
            System.out.println("Item inválido.");
        }
    }

    public void abrirInventario(Player player, Scanner scanner) {
        while (true) {
            mostrarInventario();

            if (itens.isEmpty()) {
                System.out.println("Pressione ENTER para voltar.");
                scanner.nextLine();
                return;
            }

            System.out.println("1. Usar item");
            System.out.println("2. Remover item");
            System.out.println("3. Ordenar por nome");
            System.out.println("4. Ordenar por valor");
            System.out.println("5. Mostrar apenas armas");
            System.out.println("6. Voltar");
            System.out.print("O que deseja fazer? ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Escolha qual item usar (1-" + itens.size() + "): ");
                        int itemEscolhido = Integer.parseInt(scanner.nextLine()) - 1;
                        if (itemEscolhido >= 0 && itemEscolhido < itens.size()) {
                            Item item = itens.get(itemEscolhido);
                            if (item instanceof Arma) {
                                System.out.println("1. Equipar arma");
                                System.out.println("2. Voltar");
                                System.out.print("O que deseja fazer? ");
                                int armaChoice = Integer.parseInt(scanner.nextLine());
                                if (armaChoice == 1) {
                                    usarItem(itemEscolhido, player);
                                }
                            } else {
                                usarItem(itemEscolhido, player);
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Escolha qual item remover (1-" + itens.size() + "): ");
                        int itemRemover = Integer.parseInt(scanner.nextLine()) - 1;
                        if (itemRemover >= 0 && itemRemover < itens.size()) {
                            Item item = itens.get(itemRemover);
                            System.out.println("Você descartou: " + item.getNome());
                            removerItem(item);
                        }
                        break;
                    case 3:
                        ordenarPorNome();
                        break;
                    case 4:
                        ordenarPorValor();
                        break;
                    case 5:
                        List<Arma> armas = obterArmas();
                        System.out.println("=== Armas no Inventário ===");
                        if (armas.isEmpty()) {
                            System.out.println("Nenhuma arma encontrada.");
                        } else {
                            for (int i = 0; i < armas.size(); i++) {
                                Arma arma = armas.get(i);
                                System.out.println((i + 1) + ". " + arma.getNome() + " (DMG: " + arma.getDMG() + ")");
                            }
                        }
                        System.out.println("===========================");
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }

    // Getters
    public ArrayList<Item> getItens() {
        return new ArrayList<>(itens);
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }
}
