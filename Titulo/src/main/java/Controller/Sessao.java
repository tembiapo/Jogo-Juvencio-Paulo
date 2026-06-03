/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Heroi;

/**
 *
 * @author user
 */
public class Sessao {
    private static Heroi heroiAtual;

    public static Heroi getHeroiAtual() {
        return heroiAtual;
    }

    public static void setHeroiAtual(Heroi heroi) {
        heroiAtual = heroi;
    }

    public static void encerrar() {
        heroiAtual = null;
    }
}
