/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.Raridade;
import Util.TipoPocao;

/**
 *
 * @author user
 */
public class Pocoes extends Item{
    //por enquanto só funciona assim
    //+10 de vida
    //+1 de forca
    
    private int efeito;
    private TipoPocao tipopocao;

    public Pocoes() {
    }

    public Pocoes(int efeito, TipoPocao tipopocao, int id, String nome, String descricao, int preco, Raridade raridade, int contraEfeito) {
        super(id, nome, descricao, preco, raridade, contraEfeito);
        this.efeito = efeito;
        this.tipopocao = tipopocao;
    }

    public Pocoes(int efeito, TipoPocao tipopocao, String nome, String descricao, int preco, Raridade raridade, int contraEfeito) {
        super(nome, descricao, preco, raridade, contraEfeito);
        this.efeito = efeito;
        this.tipopocao = tipopocao;
    }
    

    public int getEfeito() {
        return efeito;
    }

    public void setEfeito(int efeito) {
        this.efeito = efeito;
    }

    public TipoPocao getTipopocao() {
        return tipopocao;
    }

    public void setTipopocao(TipoPocao tipopocao) {
        this.tipopocao = tipopocao;
    }
    
    
}
