/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Pocoes;
import Util.ConnectionFactory;
import Util.Raridade;
import Util.TipoPocao;
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
public class DaoPocoes {
    int linhasAfetadas;

    public void insertPocao(Pocoes pocao) throws SQLException {
        String sql = "INSERT INTO pocoes (nome, efeito, tipoefeito, raridade, preco, descricao, contraefeito) "
                + "VALUES (?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, pocao.getNome());
            stmt.setInt(2, pocao.getEfeito());
            stmt.setString(3, pocao.getTipopocao().name());
            stmt.setString(4, pocao.getRaridade().name());
            stmt.setInt(5, pocao.getPreco());
            stmt.setString(6, pocao.getDescricao());
            stmt.setInt(7, pocao.getContraEfeito());

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Poção inserida com sucesso");
            }
        }
    }

    public Pocoes getPocaoById(int id) throws SQLException {
        Pocoes pocao = null;
        String sql = "SELECT * FROM pocoes WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pocao = new Pocoes(
                        rs.getInt("efeito"),
                        TipoPocao.valueOf(rs.getString("tipoefeito")),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("preco"),
                        Raridade.valueOf(rs.getString("raridade")),
                        rs.getInt("contraefeito")
                );
            }
        }
        return pocao;
    }

    public List<Pocoes> listarPocoes() throws SQLException {
        List<Pocoes> listaPocoes = new ArrayList<>();
        String sql = "SELECT * FROM pocoes";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pocoes pocao = new Pocoes(
                        rs.getInt("efeito"),
                        TipoPocao.valueOf(rs.getString("tipoefeito")),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("preco"),
                        Raridade.valueOf(rs.getString("raridade")),
                        rs.getInt("contraefeito")
                );
                listaPocoes.add(pocao);
            }

            if (listaPocoes.isEmpty()) {
                System.out.println("Nenhuma poção cadastrada");
            }
        }
        return listaPocoes;
    }

    public List<Pocoes> getPocoesByHeroiId(int heroiId) throws SQLException {
        List<Pocoes> listaPocoes = new ArrayList<>();
        String sql = "SELECT * FROM heroi_pocoes WHERE heroi_id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, heroiId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pocoes pocao = getPocaoById(rs.getInt("pocao_id"));
                if (pocao != null) {
                    listaPocoes.add(pocao);
                }
            }

            if (listaPocoes.isEmpty()) {
                System.out.println("Nenhuma poção encontrada para o herói");
            }
        }
        return listaPocoes;
    }

    public void updatePocao(Pocoes pocao) throws SQLException {
        String sql = "UPDATE pocoes SET nome=?, efeito=?, tipoefeito=?, raridade=?, preco=?, descricao=?, contraefeito=? "
                + "WHERE id=?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, pocao.getNome());
            stmt.setInt(2, pocao.getEfeito());
            stmt.setString(3, pocao.getTipopocao().name());
            stmt.setString(4, pocao.getRaridade().name());
            stmt.setInt(5, pocao.getPreco());
            stmt.setString(6, pocao.getDescricao());
            stmt.setInt(7, pocao.getContraEfeito());
            stmt.setInt(8, pocao.getId());

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Poção atualizada com sucesso");
            }
        }
    }

    public void deletePocao(int id) throws SQLException {
        String sql = "DELETE FROM pocoes WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Poção deletada com sucesso");
            }
        }
    }
}
