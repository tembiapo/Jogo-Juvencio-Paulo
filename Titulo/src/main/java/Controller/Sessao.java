/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Batalha;
import Model.Heroi;

/**
 *
 * @author user
 */
public class Sessao {
    private static Heroi heroiAtual;
    private static Batalha batalhaAtual;

    public static Heroi getHeroiAtual() {
        return heroiAtual;
    }
    
    public static Batalha getBatalhaAtual(){
        return batalhaAtual;
    }
    
    public static void setBatalhaAtual(Batalha batalha){
        batalhaAtual = batalha;
    }

    public static void setHeroiAtual(Heroi heroi) {
        heroiAtual = heroi;
    }

    public static void encerrar() {
        heroiAtual = null;
    }
    
    public static void encerrarBatalhaAtual(){
        batalhaAtual = null;
    }
}
