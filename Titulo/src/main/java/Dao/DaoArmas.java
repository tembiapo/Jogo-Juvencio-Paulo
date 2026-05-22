package Dao;

import Model.Armas;
import Util.ConnectionFactory;
import Util.Raridade;
import Util.TipoArma;
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
public class DaoArmas {
    int linhasAfetadas;

    public void insertArma(Armas arma) throws SQLException {
        String sql = "INSERT INTO armas (nome, contraefeito, danobase, maodupla, tipo, raridade, preco, descricao) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, arma.getNome());
            stmt.setInt(2, arma.getContraEfeito());
            stmt.setInt(3, arma.getDanoBase());
            stmt.setBoolean(4, arma.isMaoDupla());
            stmt.setString(5, arma.getTipoArma().name());
            stmt.setString(6, arma.getRaridade().name());
            stmt.setInt(7, arma.getPreco());
            stmt.setString(8, arma.getDescricao());

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Arma inserida com sucesso");
            }
        }
    }

    public Armas getArmaById(int id) throws SQLException {
        Armas arma = null;
        String sql = "SELECT * FROM armas WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                arma = new Armas(
                        rs.getInt("danobase"),
                        rs.getBoolean("maodupla"),
                        TipoArma.valueOf(rs.getString("tipo")),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("preco"),
                        Raridade.valueOf(rs.getString("raridade")),
                        rs.getInt("contraefeito")
                );
            }
        }
        return arma;
    }

    public List<Armas> listarArmas() throws SQLException {
        List<Armas> listaArmas = new ArrayList<>();
        String sql = "SELECT * FROM armas";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Armas arma = new Armas(
                        rs.getInt("danobase"),
                        rs.getBoolean("maodupla"),
                        TipoArma.valueOf(rs.getString("tipo")),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("preco"),
                        Raridade.valueOf(rs.getString("raridade")),
                        rs.getInt("contraefeito")
                );
                listaArmas.add(arma);
            }

            if (listaArmas.isEmpty()) {
                System.out.println("Nenhuma arma cadastrada");
            }
        }
        return listaArmas;
    }

    public void updateArma(Armas arma) throws SQLException {
        String sql = "UPDATE armas SET nome=?, contraefeito=?, danobase=?, maodupla=?, tipo=?, raridade=?, preco=?, descricao=? "
                + "WHERE id=?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, arma.getNome());
            stmt.setInt(2, arma.getContraEfeito());
            stmt.setInt(3, arma.getDanoBase());
            stmt.setBoolean(4, arma.isMaoDupla());
            stmt.setString(5, arma.getTipoArma().name());
            stmt.setString(6, arma.getRaridade().name());
            stmt.setInt(7, arma.getPreco());
            stmt.setString(8, arma.getDescricao());
            stmt.setInt(9, arma.getId());

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Arma atualizada com sucesso");
            }
        }
    }

    public void deleteArma(int id) throws SQLException {
        String sql = "DELETE FROM armas WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Arma deletada com sucesso");
            }
        }
    }
}
