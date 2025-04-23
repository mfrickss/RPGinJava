package Personagens;

import Personagens.Itens.Arma;
import Personagens.Itens.Item;

import java.util.ArrayList;
import java.util.Scanner;



public class Inventario {

    private ArrayList<Item> itens;
    private int capacidadeMax;

    public Inventario(int capacidadeMax){
        this.itens = new ArrayList<>();
        this.capacidadeMax = capacidadeMax;
    }

    public boolean adicionarItem(Item item){
        if (itens.size() < capacidadeMax){
            itens.add(item);
            System.out.printf("O item $s foi adicionado ao invetário.", item.getNome());
            return true;
        }else{
            System.out.println("Seu inventário está cheio!");
            return false;
        }
    }

    public void removerItem(Item item){
        itens.remove(item);
    }

    public void mostrarInventario(){
        if(itens.isEmpty()){
            System.out.println("Seu inventário está vazio.");
            return;
        }
        System.out.println("==|Seu inventário|==");
        System.out.printf("Itens: %d | %d", itens.size(), capacidadeMax);

        for(int i = 0; i < itens.size(); i++){
           Item item = itens.get(i);
            System.out.println((i+1) + ". " + item.getNome());
            System.out.println(" Descrição: " + item.getDescricao());
            System.out.println("Valor: " + item.getValor());

            if(item instanceof Arma){
                System.out.println(" DMG: " + ((Arma) item).getDMG());
            }

//            if (i < itens.size() - 1) {
//                System.out.println();
//            }
        }
        System.out.println("=======================");
    }

    public void usarItem(int indice, Player player){
        if(indice >= 0 && indice < itens.size()) {
            Item item = itens.get(indice);
            item.usar(player);

            if (!(item instanceof Arma)) {
                removerItem(item);
                System.out.println("-1. Item consumido.");
            }
        }else{
                System.out.println("Item inválido.");
            }
    }

    public void abrirInventario(Player player, Scanner scanner){
        while(true){
            mostrarInventario();

            if (itens.isEmpty()){
                System.out.println("Pressione ENTER para voltar.");
                scanner.nextLine();
                scanner.nextLine();
                return;
            }

            System.out.println("1. Usar item");
            System.out.println("2. Remover item");
            System.out.println("3. Voltar");
            System.out.print("O que deseja fazer? ");
            int choice = scanner.nextInt();

            if (choice == 1){
                System.out.println("Escolha qual item usar\n1- " + itens.size() + "): ");
                int itemEscolhido = scanner.nextInt() - 1;
                usarItem(itemEscolhido, player);
            }else if(choice == 2){
                System.out.println("Escolha qual item remover\n1- " + itens.size() + "): ");
                int itemEscolhido = scanner.nextInt() - 1;
                if (itemEscolhido >= 0 && itemEscolhido < itens.size()){
                    Item itemRemover = itens.get(itemEscolhido);
                    System.out.println("Você descartou: " + itemRemover.getNome());
                    removerItem(itemRemover);
                }
            }else if(choice == 3){
                return;
            }
        }
    }
}
