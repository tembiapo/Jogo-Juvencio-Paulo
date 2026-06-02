/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Armaduras;
import Model.Armas;
import Model.Capanga;
import Model.Item;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DaoInimigo {
    Capanga capanga  = null;
    DaoArmas daoArmas = new DaoArmas();
    DaoEscudos daoEscudos = new DaoEscudos();
    DaoArmaduras daoArmaduras = new DaoArmaduras();
    DaoPocoes daoPocoes = new DaoPocoes();
    int linhaAfetadas;
    
    public ArrayList<Item> getItensByCapangaId(int capangaId) throws SQLException {
        ArrayList<Item> itens = new ArrayList<>();
        String sql = "SELECT * FROM capanga_itens WHERE capanga_id = ?";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, capangaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int armaId = rs.getInt("arma_id");
                int armaduraId = rs.getInt("armadura_id");
                int escudoId = rs.getInt("escudo_id");
                int pocaoId = rs.getInt("pocao_id");

                if (armaId != 0) {
                    itens.add(daoArmas.getArmaById(armaId));
                } else if (armaduraId != 0) {
                    itens.add(daoArmaduras.getArmaduraById(armaduraId));
                } else if (escudoId != 0) {
                    itens.add(daoEscudos.getEscudoById(escudoId));
                } else if (pocaoId != 0) {
                    itens.add(daoPocoes.getPocaoById(pocaoId));
                }
            }
        }
        return itens;
    }
    
    public Capanga getCapanga(int nivel) throws SQLException{        
        Capanga capanga = null;
        String sql = "select * from capanga where nivel = ? ORDER BY RANDOM() LIMIT 1";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, nivel);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                ArrayList<Item> inventario = getItensByCapangaId(rs.getInt("id"));//pega inventario
                // mão direita
                Armas maoDireita = null;
                int maoDireitaId = rs.getInt("mao_direita_id");         

                // mão esquerda
                Item maoEsquerda = null;
                int maoEsquerdaArmaId = rs.getInt("mao_esquerda_arma_id");
                int maoEsquerdaEscudoId = rs.getInt("mao_esquerda_escudo_id");
                if (maoEsquerdaArmaId != 0) {
                    maoEsquerda = daoArmas.getArmaById(maoEsquerdaArmaId);
                }else if (maoEsquerdaEscudoId != 0 ){
                    maoEsquerda = daoEscudos.getEscudoById(maoEsquerdaEscudoId);
                }

                // armaduras
                Armaduras capacete = null;
                Armaduras peitoral = null;
                Armaduras calca = null;
                Armaduras botas = null;

                int capaceteId = rs.getInt("armadura_capacete_id");               

                int peitoralId = rs.getInt("armadura_peitoral_id");
                
                int calcaId = rs.getInt("armadura_calca_id");                

                int botasId = rs.getInt("armadura_botas_id");                

                capanga =  new Capanga(
                        rs.getInt("xpConcede"),
                        rs.getInt("retornoMonetario"),
                        inventario,
                        rs.getString("nome"),
                        rs.getInt("vida"),
                        rs.getInt("vidaMx"),
                        rs.getInt("mana"),
                        rs.getInt("manaMx"),
                        rs.getInt("dano"),
                        rs.getInt("defesa"),
                        rs.getInt("agilidade"),
                        rs.getInt("magia"),
                        maoDireita,
                        maoEsquerda,
                        capacete,
                        peitoral,
                        botas,
                        calca
                );
                
            }
            return capanga;
        }
    }
}
