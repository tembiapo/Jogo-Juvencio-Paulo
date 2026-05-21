package Model;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Heroi {
    private int id;
    private String nome;
    private int nivel, xp;
    private int vida, vidaMx;
    private int mana, manaMx;
    private int dano, defesa, agilidade, magia;
    private Armas maoDireta;
    private Item maoEsquerda;
    private Armaduras armadura;
    private ArrayList<Pocoes>  pocoes;
    private ArrayList<Item> inventario;

    public Heroi() {
    }

    public Heroi(int id, String nome, int nivel, int xp, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armadura, ArrayList<Pocoes> pocoes, ArrayList<Item> inventario) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.xp = xp;
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
        this.armadura = armadura;
        this.pocoes = pocoes;
        this.inventario = inventario;
    }

    public Heroi(int id, String nome, int nivel, int xp, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armadura) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.xp = xp;
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
        this.armadura = armadura;
    }

    public Heroi(String nome, int nivel, int xp, int vida, int vidaMx, int mana, int manaMx, int dano, int defesa, int agilidade, int magia, Armas maoDireta, Item maoEsquerda, Armaduras armadura, ArrayList<Pocoes> pocoes, ArrayList<Item> inventario) {
        this.nome = nome;
        this.nivel = nivel;
        this.xp = xp;
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
        this.armadura = armadura;
        this.pocoes = pocoes;
        this.inventario = inventario;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
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
        return armadura;
    }

    public void setArmadura(Armaduras armadura) {
        this.armadura = armadura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
