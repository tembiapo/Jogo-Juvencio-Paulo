/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Capanga extends Personagem{
    private int xpConcede;
    private int retornoMonetario;
    private ArrayList<Item> item;

    public Capanga(int xpConcede, int retornoMonetario, ArrayList<Item> item) {
        this.xpConcede = xpConcede;
        this.retornoMonetario = retornoMonetario;
        this.item = item;
    }

    public Capanga(int xpConcede, int retornoMonetario, ArrayList<Item> item, int id, String nome, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armaduraCapacete, Armaduras armaduraPeitoral, Armaduras armaduraBotas, Armaduras armaduraCalca) {
        super(id, nome, vida, vidaMx, mana, manaMx, dano, defesa, agilidade, magia, maoDireta, maoEsquerda, armaduraCapacete, armaduraPeitoral, armaduraBotas, armaduraCalca);
        this.xpConcede = xpConcede;
        this.retornoMonetario = retornoMonetario;
        this.item = item;
    }

    public Capanga(int xpConcede, int retornoMonetario, ArrayList<Item> item, String nome, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armaduraCapacete, Armaduras armaduraPeitoral, Armaduras armaduraBotas, Armaduras armaduraCalca) {
        super(nome, vida, vidaMx, mana, manaMx, dano, defesa, agilidade, magia, maoDireta, maoEsquerda, armaduraCapacete, armaduraPeitoral, armaduraBotas, armaduraCalca);
        this.xpConcede = xpConcede;
        this.retornoMonetario = retornoMonetario;
        this.item = item;
    }

    public Capanga() {
    }

    
    public int getXpConcede() {
        return xpConcede;
    }

    public void setXpConcede(int xpConcede) {
        this.xpConcede = xpConcede;
    }

    public int getRetornoMonetario() {
        return retornoMonetario;
    }

    public void setRetornoMonetario(int retornoMonetario) {
        this.retornoMonetario = retornoMonetario;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }
    
    
}
