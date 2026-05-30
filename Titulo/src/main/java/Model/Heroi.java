package Model;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Heroi extends Personagem{
    private ArrayList<Pocoes>  pocoes;
    private ArrayList<Item> inventario;

    public Heroi(ArrayList<Pocoes> pocoes, ArrayList<Item> inventario) {
        this.pocoes = pocoes;
        this.inventario = inventario;
    }

    public Heroi(ArrayList<Pocoes> pocoes, ArrayList<Item> inventario, int id, String nome, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armaduraCapacete, Armaduras armaduraPeitoral, Armaduras armaduraBotas, Armaduras armaduraCalca) {
        super(id, nome, vida, vidaMx, mana, manaMx, dano, defesa, agilidade, magia, maoDireta, maoEsquerda, armaduraCapacete, armaduraPeitoral, armaduraBotas, armaduraCalca);
        this.pocoes = pocoes;
        this.inventario = inventario;
    }

    public Heroi(ArrayList<Pocoes> pocoes, ArrayList<Item> inventario, String nome, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armaduraCapacete, Armaduras armaduraPeitoral, Armaduras armaduraBotas, Armaduras armaduraCalca) {
        super(nome, vida, vidaMx, mana, manaMx, dano, defesa, agilidade, magia, maoDireta, maoEsquerda, armaduraCapacete, armaduraPeitoral, armaduraBotas, armaduraCalca);
        this.pocoes = pocoes;
        this.inventario = inventario;
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

    
    
}
