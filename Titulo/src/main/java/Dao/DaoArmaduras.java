/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Armaduras;
import Util.ConnectionFactory;
import Util.Raridade;
import Util.TipoArmadura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class DaoArmaduras {
    int linhasAfetadas;

    public void insertArmadura(Armaduras armadura) throws SQLException {
        String sql = "INSERT INTO armaduras (nome, defesabase, tipo, raridade, preco, descricao, contraefeito) "
                + "VALUES (?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, armadura.getNome());
            stmt.setInt(2, armadura.getDefesaBase());
            stmt.setString(3, armadura.getTipo().name());
            stmt.setString(4, armadura.getRaridade().name());
            stmt.setInt(5, armadura.getPreco());
            stmt.setString(6, armadura.getDescricao());
            stmt.setInt(7, armadura.getContraEfeito());

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Armadura inserida com sucesso");
            }
        }
    }

    public Armaduras getArmaduraById(int id) throws SQLException {
        Armaduras armadura = null;
        String sql = "SELECT * FROM armaduras WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                armadura = new Armaduras(
                        rs.getInt("defesabase"),
                        TipoArmadura.valueOf(rs.getString("tipo")),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("preco"),
                        Raridade.valueOf(rs.getString("raridade")),
                        rs.getInt("contraefeito")
                );
            }
        }
        return armadura;
    }
    
    public Armaduras ParteArmaduraRandowPorRaridade(Raridade raridade, TipoArmadura tipoArmadura) throws SQLException {
        Armaduras armadura = null;
        String sql = "SELECT * FROM armaduras WHERE raridade = ? and tipo = ? ORDER BY RANDOM() LIMIT 1";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, raridade.toString());
            stmt.setString(1, tipoArmadura.toString());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                armadura = new Armaduras(
                        rs.getInt("defesabase"),
                        TipoArmadura.valueOf(rs.getString("tipo")),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("preco"),
                        Raridade.valueOf(rs.getString("raridade")),
                        rs.getInt("contraefeito")
                );
            }
        }
        return armadura;
    }

    public List<Armaduras> listarArmaduras() throws SQLException {
        List<Armaduras> listaArmaduras = new ArrayList<>();
        String sql = "SELECT * FROM armaduras";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Armaduras armadura = new Armaduras(
                        rs.getInt("defesabase"),
                        TipoArmadura.valueOf(rs.getString("tipo")),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("preco"),
                        Raridade.valueOf(rs.getString("raridade")),
                        rs.getInt("contraefeito")
                );
                listaArmaduras.add(armadura);
            }

            if (listaArmaduras.isEmpty()) {
                System.out.println("Nenhuma armadura cadastrada");
            }
        }
        return listaArmaduras;
    }

    public void updateArmadura(Armaduras armadura) throws SQLException {
        String sql = "UPDATE armaduras SET nome=?, defesabase=?, tipo=?, raridade=?, preco=?, descricao=?, contraefeito=? "
                + "WHERE id=?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, armadura.getNome());
            stmt.setInt(2, armadura.getDefesaBase());
            stmt.setString(3, armadura.getTipo().name());
            stmt.setString(4, armadura.getRaridade().name());
            stmt.setInt(5, armadura.getPreco());
            stmt.setString(6, armadura.getDescricao());
            stmt.setInt(7, armadura.getContraEfeito());
            stmt.setInt(8, armadura.getId());

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Armadura atualizada com sucesso");
            }
        }
    }

    public void deleteArmadura(int id) throws SQLException {
        String sql = "DELETE FROM armaduras WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Armadura deletada com sucesso");
            }
        }
    }
}
