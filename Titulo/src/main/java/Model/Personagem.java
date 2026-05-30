/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author aluno
 */
public class Personagem {
    private int id;
    private String nome;
    private int vida, vidaMx;
    private int mana, manaMx;
    private int dano, defesa, agilidade, magia;
    private Armas maoDireta;
    private Item maoEsquerda;
    private Armaduras armaduraCapacete;
    private Armaduras armaduraPeitoral;
    private Armaduras armaduraBotas;
    private Armaduras armaduraCalca;

    public Personagem() {
    }

    public Personagem(int id, String nome, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armaduraCapacete, Armaduras armaduraPeitoral, Armaduras armaduraBotas, Armaduras armaduraCalca) {
        this.id = id;
        this.nome = nome;
        this.vida = vida;
        this.vidaMx = vidaMx;
        this.mana = mana;
        this.manaMx = manaMx;
        this.dano = dano;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.magia = magia;
        this.maoDireta = maoDireta;
        this.maoEsquerda = maoEsquerda;
        this.armaduraCapacete = armaduraCapacete;
        this.armaduraPeitoral = armaduraPeitoral;
        this.armaduraBotas = armaduraBotas;
        this.armaduraCalca = armaduraCalca;
    }

    public Personagem(String nome, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armaduraCapacete, Armaduras armaduraPeitoral, Armaduras armaduraBotas, Armaduras armaduraCalca) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMx = vidaMx;
        this.mana = mana;
        this.manaMx = manaMx;
        this.dano = dano;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.magia = magia;
        this.maoDireta = maoDireta;
        this.maoEsquerda = maoEsquerda;
        this.armaduraCapacete = armaduraCapacete;
        this.armaduraPeitoral = armaduraPeitoral;
        this.armaduraBotas = armaduraBotas;
        this.armaduraCalca = armaduraCalca;
    }
    
    

    public Armaduras getArmaduraCapacete() {
        return armaduraCapacete;
    }

    public void setArmaduraCapacete(Armaduras armaduraCapacete) {
        this.armaduraCapacete = armaduraCapacete;
    }

    public Armaduras getArmaduraPeitoral() {
        return armaduraPeitoral;
    }

    public void setArmaduraPeitoral(Armaduras armaduraPeitoral) {
        this.armaduraPeitoral = armaduraPeitoral;
    }

    public Armaduras getArmaduraBotas() {
        return armaduraBotas;
    }

    public void setArmaduraBotas(Armaduras armaduraBotas) {
        this.armaduraBotas = armaduraBotas;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMx() {
        return vidaMx;
    }

    public void setVidaMx(int vidaMx) {
        this.vidaMx = vidaMx;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getManaMx() {
        return manaMx;
    }

    public void setManaMx(int manaMx) {
        this.manaMx = manaMx;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public Armas getMaoDireta() {
        return maoDireta;
    }

    public void setMaoDireta(Armas maoDireta) {
        this.maoDireta = maoDireta;
    }

    public Item getMaoEsquerda() {
        return maoEsquerda;
    }

    public void setMaoEsquerda(Item maoEsquerda) {
        this.maoEsquerda = maoEsquerda;
    }

    public Armaduras getArmadura() {
        return armaduraCapacete;
    }

    public void setArmadura(Armaduras armadura) {
        this.armaduraCapacete = armadura;
    }

    public Armaduras getArmaduraCalca() {
        return armaduraCalca;
    }

    public void setArmaduraCalca(Armaduras armaduraCalca) {
        this.armaduraCalca = armaduraCalca;
    }
    
    
}
