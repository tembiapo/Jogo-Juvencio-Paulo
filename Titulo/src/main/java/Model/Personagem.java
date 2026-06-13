/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Random;
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
    private int nivel;
    
    //variaveis da batalha
    private Random rand = new Random();
    private int dado = 0;
    
    public int calcularDanoAtaque(){
        dado = rand.nextInt(20) + 1;// +1 pare ele nao ir para pular o 0
        dado += dano;
        if (maoDireta != null) dado += maoDireta.getDanoBase();
        if (maoEsquerda instanceof Armas) {
            Armas armaEsquerda = (Armas) maoEsquerda;
            dado += armaEsquerda.getDanoBase();
        }
        return dado;
    }
    
    public int calcularDefesa(){
        dado = rand.nextInt(20) + 1;
        
        dado += defesa;
        
        if (armaduraBotas != null) {
            dado += armaduraBotas.getDefesaBase();
        }
        if (armaduraCalca != null) {
            dado += armaduraCalca.getDefesaBase();
        }
        if (armaduraCapacete != null) {
            dado += armaduraCapacete.getDefesaBase();
        }
        if (armaduraPeitoral != null)
            dado += armaduraPeitoral.getDefesaBase();
        if (maoEsquerda instanceof Escudo) {
           Escudo armaEsquerda = (Escudo) maoEsquerda;
           dado += armaEsquerda.getBloqueioBase();
        }
        return dado;
    }
    
    
    public Personagem() {
    }

    public Personagem(int id, String nome, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armaduraCapacete, Armaduras armaduraPeitoral, Armaduras armaduraBotas, Armaduras armaduraCalca, int nivel) {
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
        this.nivel = nivel;
    }

    public Personagem(String nome, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armaduraCapacete, Armaduras armaduraPeitoral, Armaduras armaduraBotas, Armaduras armaduraCalca, int nivel) {
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
        this.nivel = nivel;
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

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }
    
    
}
