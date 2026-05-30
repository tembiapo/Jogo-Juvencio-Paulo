package Model;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Heroi extends Personagem{
    private ArrayList<Pocoes>  pocoes;
    private ArrayList<Item> inventario;
    private int dinheiro;

    public Heroi(ArrayList<Pocoes> pocoes, ArrayList<Item> inventario, int moedas) {
        this.pocoes = pocoes;
        this.inventario = inventario;
        this.dinheiro = moedas;
    }

    public Heroi(ArrayList<Pocoes> pocoes, ArrayList<Item> inventario, int moedas, int id, String nome, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armaduraCapacete, Armaduras armaduraPeitoral, Armaduras armaduraBotas, Armaduras armaduraCalca) {
        super(id, nome, vida, vidaMx, mana, manaMx, dano, defesa, agilidade, magia, maoDireta, maoEsquerda, armaduraCapacete, armaduraPeitoral, armaduraBotas, armaduraCalca);
        this.pocoes = pocoes;
        this.inventario = inventario;
        this.dinheiro = moedas;
    }

    public Heroi(ArrayList<Pocoes> pocoes, ArrayList<Item> inventario, int moedas, String nome, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armaduraCapacete, Armaduras armaduraPeitoral, Armaduras armaduraBotas, Armaduras armaduraCalca) {
        super(nome, vida, vidaMx, mana, manaMx, dano, defesa, agilidade, magia, maoDireta, maoEsquerda, armaduraCapacete, armaduraPeitoral, armaduraBotas, armaduraCalca);
        this.pocoes = pocoes;
        this.inventario = inventario;
        this.dinheiro = moedas;
    }

    public Heroi() {
    } 

    public ArrayList<Pocoes> getPocoes() {
        return pocoes;
    }

    public void setPocoes(ArrayList<Pocoes> pocoes) {
        this.pocoes = pocoes;
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
    }

    public int getMoedas() {
        return dinheiro;
    }

    public void setMoedas(int moedas) {
        this.dinheiro = moedas;
    }

    
    
}
