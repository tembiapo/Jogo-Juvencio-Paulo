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
    
    public Armas getArmaRandowByTipoComun(TipoArma tipoArma) throws SQLException{
        Armas arma = null;
        String sql = "SELECT * FROM armas WHERE tipo = ? and raridade = 'comun' ORDER BY RANDOM() LIMIT 1";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, tipoArma.toString());
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                arma = new Armas(
                        rs.getInt("danobase"),
                        rs.getInt("maodupla") == 1,
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

    // construtor de arma com id
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
    
    public void updateNomeArma(String novoNome, int id) throws SQLException {
        String sql = "UPDATE armas SET nome=?"
                + "WHERE id=?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setInt(2, id);

            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("nome, da arma"+ id +", atualizada com sucesso");
            }
        }
    }
    
    public void updateContraEfeitoArma(int novoContraEfeito, int id) throws SQLException {
        String sql = "UPDATE armas SET contraefeito=? WHERE id=?";
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, novoContraEfeito);
            stmt.setInt(2, id);
            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("ContraEfeito da arma " + id + " atualizado com sucesso");
            }
        }
    }
    
    public void updateDanoBaseArma(int novoDanoBase, int id) throws SQLException {
        String sql = "UPDATE armas SET danobase=? WHERE id=?";
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, novoDanoBase);
            stmt.setInt(2, id);
            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("DanoBase da arma " + id + " atualizado com sucesso");
            }
        }
    }
    
    public void updateMaoDuplaArma(boolean novaMaoDupla, int id) throws SQLException {
        String sql = "UPDATE armas SET maodupla=? WHERE id=?";
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, novaMaoDupla);
            stmt.setInt(2, id);
            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("MaoDupla da arma " + id + " atualizado com sucesso");
            }
        }
    }

    public void updateTipoArma(TipoArma novoTipo, int id) throws SQLException {
        String sql = "UPDATE armas SET tipo=? WHERE id=?";
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, novoTipo.name());
            stmt.setInt(2, id);
            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Tipo da arma " + id + " atualizado com sucesso");
            }
        }
    }
    
    public void updateRaridadeArma(Raridade novaRaridade, int id) throws SQLException {
        String sql = "UPDATE armas SET raridade=? WHERE id=?";
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, novaRaridade.name());
            stmt.setInt(2, id);
            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Raridade da arma " + id + " atualizada com sucesso");
            }
        }
    }
    
    public void updatePrecoArma(int novoPreco, int id) throws SQLException {
        String sql = "UPDATE armas SET preco=? WHERE id=?";
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, novoPreco);
            stmt.setInt(2, id);
            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Preco da arma " + id + " atualizado com sucesso");
            }
        }
    }
    
    public void updateDescricaoArma(String novaDescricao, int id) throws SQLException {
        String sql = "UPDATE armas SET descricao=? WHERE id=?";
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, novaDescricao);
            stmt.setInt(2, id);
            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Descricao da arma " + id + " atualizada com sucesso");
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
