package Model;

import Util.Raridade;

/**
 *
 * @author user
 */
public class Escudo extends Item{
    
    private int bloqueioBase;

    public Escudo() {
    }

    public Escudo(int bloqueioBase, int id, String nome, String descricao, int preco, Raridade raridade, int contraEfeito) {
        super(id, nome, descricao, preco, raridade, contraEfeito);
        this.bloqueioBase = bloqueioBase;
    }

    public Escudo(int bloqueioBase, String nome, String descricao, int preco, Raridade raridade, int contraEfeito) {
        super(nome, descricao, preco, raridade, contraEfeito);
        this.bloqueioBase = bloqueioBase;
    }


    public Escudo(int bloqueioBase, String nome, String descricao, int preco, Raridade raridade) {
        super(nome, descricao, preco, raridade);
        this.bloqueioBase = bloqueioBase;
    }

    public int getBloqueioBase() {
        return bloqueioBase;
    }

    public void setBloqueioBase(int bloqueioBase) {
        this.bloqueioBase = bloqueioBase;
    }
}
