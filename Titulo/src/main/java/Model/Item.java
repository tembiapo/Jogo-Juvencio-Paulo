/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Util.Raridade;

/**
 *
 * @author user
 */
public abstract class Item {
    private int id;
    private String nome;
    private String descricao;
    private int preco;
    private Raridade raridade;
    private int contraEfeito;

    public Item() {
    }

    public Item(int id, String nome, String descricao, int preco, Raridade raridade, int contraEfeito) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.raridade = raridade;
        this.contraEfeito = contraEfeito;
    }

    public Item(String nome, String descricao, int preco, Raridade raridade, int contraEfeito) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.raridade = raridade;
        this.contraEfeito = contraEfeito;
    }

    public Item(String nome, String descricao, int preco, Raridade raridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.raridade = raridade;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }

    public int getContraEfeito() {
        return contraEfeito;
    }

    public void setContraEfeito(int contraEfeito) {
        this.contraEfeito = contraEfeito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
