package Personagens;

import Personagens.Itens.Arma;
import Personagens.Itens.Magia;


public class Player {
    private int playerHP;
    private int playerMaxHP;
    private int playerMana;
    private int playerManaMax;
    private Magia magiaEquipada;
    private Arma armaEquipada;
    //COMPOSIÇÃO
    private Inventario inventario;

    public Player() {
        this.playerHP = 100;
        this.playerMaxHP = 100;
        this.playerMana = 100;
        this.playerManaMax = 100;
        this.armaEquipada = new Arma("Adaga de Ferro", "Uma adaga brilhante e pequena", 100, 8, 13);
        this.magiaEquipada = new Magia("Bola de fogo", "Uma pequena bola de fogo", 20, 18, 10);
        this.inventario = new Inventario(10);
    }

    public void printStats() {
        System.out.println("Player - HP: " + playerHP + ", Dano: " + armaEquipada.getDMG());
        System.out.println("Player - Arma equipada: " + armaEquipada.toString());
        System.out.println("Player - Magia equipada: " + magiaEquipada.toString());
    }

    public int getPlayerHP(){
        return this.playerHP;
    }

    public int getPlayerMaxHP(){
        return this.playerMaxHP;
    }

    public int getPlayerMana(){
        return this.playerMana;
    }

    public int setPlayerMana(){
        return this.playerMana;
    }

    public int getPlayerManaMax(){
        return this.playerManaMax;
    }

    public int getPlayerArmaDMG(){
        return armaEquipada.getDMG();
    }

    public int getPlayerMagiaDMG(){
        return magiaEquipada.getDMG();
    }

    public void levarDMG(int dano){
        this.playerHP -= dano;
        if (this.playerHP < 0) {
            this.playerHP = 0;
        }
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public Magia getMagiaEquipada() {
        return magiaEquipada;
    }

    public void recuperarHP(int cura){
        this.playerHP += cura;
        if(this.playerHP > this.playerMaxHP){
            this.playerHP = this.playerMaxHP;
        }
        System.out.printf("\nVocê recuperou %d HP. %d|%d", cura, playerHP, playerMaxHP);
    }

    public void recuperarMana(int manaRegen){
        this.playerMana += manaRegen;
        if(this.playerMana > this.playerManaMax){
            this.playerMana = this.playerManaMax;
        }
        System.out.printf("\nVocê recuperou %d de mana. %d|%d", manaRegen, playerMana, playerManaMax);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void trocarArma(Arma novaArma){
        this.armaEquipada = novaArma;
        System.out.println("Você equipou " + novaArma);
    }

    public int custoUsoMagia(){
        return this.playerMana - magiaEquipada.getCustoMana();
    }

    public void setPlayerMana(int manaPlayer) {
        this.playerMana = manaPlayer;
    }

}
