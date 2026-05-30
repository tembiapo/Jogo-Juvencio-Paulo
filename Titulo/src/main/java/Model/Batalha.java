/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author user
 */
public class Batalha {
    private Heroi heroi;
    private Personagem inimigo;
    private int turnoAtual;
    private boolean batalhaEncerrada;
    private boolean herioVenceu;

    public Batalha(Heroi heroi, Personagem inimigo) {
        this.heroi = heroi;
        this.inimigo = inimigo;
        this.turnoAtual = 1;
        this.batalhaEncerrada = false;
    }

    public Batalha() {
    }

    public void proximoTurno() {
        turnoAtual++;
    }

    public boolean isBatalhaEncerrada() {
        return heroi.getVida() <= 0 || inimigo.getVida() <= 0;
    }

    public boolean isHeroiVenceu() {
        return inimigo.getVida() <= 0;
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    public Personagem getInimigo() {
        return inimigo;
    }

    public void setInimigo(Personagem inimigo) {
        this.inimigo = inimigo;
    }

    public int getTurnoAtual() {
        return turnoAtual;
    }

    public void setTurnoAtual(int turnoAtual) {
        this.turnoAtual = turnoAtual;
    }

    public boolean isHerioVenceu() {
        return herioVenceu;
    }

    public void setHerioVenceu(boolean herioVenceu) {
        this.herioVenceu = herioVenceu;
    }
}
