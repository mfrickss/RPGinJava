package Personagens;

import Personagens.Itens.Arma;

public class Player {
    private int playerHP;
    private int playerMANA;
    private Arma armaEquipada;


    public Player() {
        this.playerHP = 100;
        this.playerMANA = 100;
        this.armaEquipada = new Arma("Adaga de Ferro", "Uma adaga brilhante e pequena", 100, 10);
    }

    public void printStats() {
        System.out.println("Personagens.Player - HP: " + playerHP + ", Dano: " + armaEquipada.getDMG());
        System.out.println("Arma equipada: " + armaEquipada);
    }

    public int getPlayerHP(){
        return this.playerHP;
    }

    public int getPlayerDMG(){
        return armaEquipada.getDMG();
    }

    public void levarDMG(int dano){
        this.playerHP -= dano;
    }

    public void trocarArma(Arma novaArma){
        this.armaEquipada = novaArma;
        System.out.println("Você equipou" + novaArma);
    }

}
