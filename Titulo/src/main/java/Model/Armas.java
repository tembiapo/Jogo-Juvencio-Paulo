/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.Raridade;
import Util.TipoArma;

/**
 *
 * @author user
 */
public class Armas extends Item{
    private int danoBase;
    private boolean maoDupla;
    private TipoArma tipoArma;

    public Armas() {
    }

    public Armas(int danoBase, boolean maoDupla, TipoArma tipoArma, int id, String nome, String descricao, int preco, Raridade raridade, int contraEfeito) {
        super(id, nome, descricao, preco, raridade, contraEfeito);
        this.danoBase = danoBase;
        this.maoDupla = maoDupla;
        this.tipoArma = tipoArma;
    }

    public Armas(int danoBase, boolean maoDupla, TipoArma tipoArma, String nome, String descricao, int preco, Raridade raridade, int contraEfeito) {
        super(nome, descricao, preco, raridade, contraEfeito);
        this.danoBase = danoBase;
        this.maoDupla = maoDupla;
        this.tipoArma = tipoArma;
    }
    
    
    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public boolean isMaoDupla() {
        return maoDupla;
    }

    public void setMaoDupla(boolean maoDupla) {
        this.maoDupla = maoDupla;
    }

    public TipoArma getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(TipoArma tipoArma) {
        this.tipoArma = tipoArma;
    }
}
