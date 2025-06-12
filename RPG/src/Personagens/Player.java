package Personagens;

import Personagens.Itens.Arma;


public class Player {
    private int playerHP;
    private int playerMaxHP;
    private int playerMANA;
    private int moedas;
    private Arma armaEquipada;
    //COMPOSIÇÃO
    private Inventario inventario;

    public Player() {
        this.playerHP = 100;
        this.playerMaxHP = 100;
        this.playerMANA = 100;
        this.moedas = 50; // Começa com 50 moedas
        this.armaEquipada = new Arma("Adaga de Ferro", "Uma adaga brilhante e pequena", 100, 8, 13);
        this.inventario = new Inventario(10);
    }

    public void printStats() {
        System.out.println("Player - HP: " + playerHP + ", Dano: " + armaEquipada.getDMG());
        System.out.println("Player - Arma equipada: " + armaEquipada.toString());
        System.out.println("Moedas: " + moedas);
    }

    public int getPlayerHP(){
        return this.playerHP;
    }

    public int getPlayerMaxHP(){
        return this.playerMaxHP;
    }

    public int getPlayerDMG(){
        return armaEquipada.getDMG();
    }

    public void levarDMG(int dano){
        this.playerHP -= dano;
        if (this.playerHP < 0) {
            this.playerHP = 0;
        }
    }

    public void recuperarHP(int cura){
        this.playerHP += cura;
        if(this.playerHP > this.playerMaxHP){
            this.playerHP = this.playerMaxHP;
        }
        System.out.printf("\nVocê recuperou %d HP. %d|%d", cura, playerHP, playerMaxHP);
    }

    public void recuperarMana(int manaRegen){
        this.playerMANA += manaRegen;
        if(this.playerMANA > 100){
            this.playerMANA = 100;
        }
        System.out.printf("\nVocê recuperou %d de Mana. %d|100", manaRegen, playerMANA);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void trocarArma(Arma novaArma){
        this.armaEquipada = novaArma;
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
}
