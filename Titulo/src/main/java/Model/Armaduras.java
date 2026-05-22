/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.Raridade;
import Util.TipoArmadura;

/**
 *
 * @author user
 */
public class Armaduras extends Item{
    private int defesaBase;
    private TipoArmadura tipo; 

    public Armaduras() {
    }

    public Armaduras(int defesaBase, TipoArmadura tipo, int id, String nome, String descricao, int preco, Raridade raridade, int contraEfeito) {
        super(id, nome, descricao, preco, raridade, contraEfeito);
        this.defesaBase = defesaBase;
        this.tipo = tipo;
    }

    public Armaduras(int defesaBase, TipoArmadura tipo, String nome, String descricao, int preco, Raridade raridade, int contraEfeito) {
        super(nome, descricao, preco, raridade, contraEfeito);
        this.defesaBase = defesaBase;
        this.tipo = tipo;
    }


    public int getDefesaBase() {
        return defesaBase;
    }

    public void setDefesaBase(int defesaBase) {
        this.defesaBase = defesaBase;
    }

    public TipoArmadura getTipo() {
        return tipo;
    }

    public void setTipo(TipoArmadura tipo) {
        this.tipo = tipo;
    }
}
