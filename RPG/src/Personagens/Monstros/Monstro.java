package Personagens.Monstros;

public abstract class Monstro {
    public int monsterHP;
    public int monsterDMG;

    public abstract void printStats();

    public int getMonsterHP(){
        return monsterHP;
    }

    public void levarDMG(int dano){
        this.monsterHP -= dano;
    }

    public int getMonsterDMG(){
        return monsterDMG;
    }
}