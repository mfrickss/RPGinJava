package Personagens;

public class Arma {
    private String Nome;
    private int DMG;

    public Arma(String nome, int DMG){
        this.Nome = nome;
        this.DMG = DMG;
    }

    public int getDMG() {
        return DMG;
    }

    public String getNome(){
        return Nome;
    }

    @Override
    public String toString(){
        return Nome + " (Dano; " + DMG + ")";
    }
}
