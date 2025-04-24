package Personagens;

import Personagens.Itens.Arma;

public class Player {
    private int playerHP;
    private int playerMaxHP;
    private int playerMANA;
    private Arma armaEquipada;
    private Inventario inventario;


    public Player() {
        this.playerHP = 100;
        this.playerMaxHP = 100;
        this.playerMANA = 100;
        this.armaEquipada = new Arma("Adaga de Ferro", "Uma adaga brilhante e pequena", 100, 10);
        this.inventario = new Inventario(10);
    }

    public void printStats() {
        System.out.println("Personagens.Player - HP: " + playerHP + ", Dano: " + armaEquipada.getDMG());
        System.out.println("Arma equipada: " + armaEquipada);
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
        this.playerHP += manaRegen;
        if(this.playerHP > this.playerMaxHP){
            this.playerHP = this.playerMaxHP;
        }
        System.out.printf("\nVocê recuperou %d HP. %d|%d", manaRegen, playerHP, playerMaxHP);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void trocarArma(Arma novaArma){
        this.armaEquipada = novaArma;
        System.out.println("Você equipou" + novaArma);
    }

}
