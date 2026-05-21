/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Escudo;
import Util.ConnectionFactory;
import Util.Raridade;
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
public class DaoEscudos {
     int linhasAfetadas;

    public void insertEscudo(Escudo escudo) throws SQLException {
        String sql = "INSERT INTO escudos (nome, defesabase, raridade, preco, descricao, contraefeito) "
                + "VALUES (?,?,?,?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, escudo.getNome());
            stmt.setInt(2, escudo.getBloqueioBase());
            stmt.setString(3, escudo.getRaridade().name());
            stmt.setInt(4, escudo.getPreco());
            stmt.setString(5, escudo.getDescricao());
            stmt.setInt(6, escudo.getContraEfeito());

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Escudo inserido com sucesso");
            }
        }
    }

    public Escudo getEscudoById(int id) throws SQLException {
        Escudo escudo = null;
        String sql = "SELECT * FROM escudos WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                escudo = new Escudo(
                        rs.getInt("defesabase"),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("preco"),
                        Raridade.valueOf(rs.getString("raridade")),
                        rs.getInt("contraefeito")
                );
            }
        }
        return escudo;
    }

    public List<Escudo> listarEscudos() throws SQLException {
        List<Escudo> listaEscudos = new ArrayList<>();
        String sql = "SELECT * FROM escudos";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Escudo escudo = new Escudo(
                        rs.getInt("defesabase"),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("preco"),
                        Raridade.valueOf(rs.getString("raridade")),
                        rs.getInt("contraefeito")
                );
                listaEscudos.add(escudo);
            }

            if (listaEscudos.isEmpty()) {
                System.out.println("Nenhum escudo cadastrado");
            }
        }
        return listaEscudos;
    }

    public void updateEscudo(Escudo escudo) throws SQLException {
        String sql = "UPDATE escudos SET nome=?, defesabase=?, raridade=?, preco=?, descricao=?, contraefeito=? "
                + "WHERE id=?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, escudo.getNome());
            stmt.setInt(2, escudo.getBloqueioBase());
            stmt.setString(3, escudo.getRaridade().name());
            stmt.setInt(4, escudo.getPreco());
            stmt.setString(5, escudo.getDescricao());
            stmt.setInt(6, escudo.getContraEfeito());
            stmt.setInt(7, escudo.getId());

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Escudo atualizado com sucesso");
            }
        }
    }

    public void deleteEscudo(int id) throws SQLException {
        String sql = "DELETE FROM escudos WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Escudo deletado com sucesso");
            }
        }
    }
}
