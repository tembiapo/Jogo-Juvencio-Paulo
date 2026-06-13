package Dao;

import Model.Armaduras;
import Model.Armas;
import Model.Escudo;
import Model.Heroi;
import Model.Item;
import Model.Pocoes;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoHeroi {

    DaoArmas daoArma = new DaoArmas();
    DaoEscudos daoEscudo = new DaoEscudos();
    DaoArmaduras daoArmadura = new DaoArmaduras();
    DaoPocoes daoPocoes = new DaoPocoes();
    int linhasAfetadas;

    public Heroi insertHeroi(Heroi heroi) throws SQLException {
        String sql = "INSERT INTO heroi (nome, armadura_capacete_id, armadura_peitoral_id, armadura_botas_id, armadura_calca_id, "
                + "mao_direita_id, mao_esquerda_arma_id, mao_esquerda_escudo_id) "
                + "VALUES (?,?,?,?,?,?,?,?) RETURNING id";

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, heroi.getNome());

            if (heroi.getArmaduraCapacete() != null) {
                stmt.setInt(2, heroi.getArmaduraCapacete().getId());
            } else {
                stmt.setNull(2, java.sql.Types.INTEGER);
            }

            if (heroi.getArmaduraPeitoral() != null) {
                stmt.setInt(3, heroi.getArmaduraPeitoral().getId());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }

            if (heroi.getArmaduraBotas() != null) {
                stmt.setInt(4, heroi.getArmaduraBotas().getId());
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER);
            }

            if (heroi.getArmaduraCalca() != null) {
                stmt.setInt(5, heroi.getArmaduraCalca().getId());
            } else {
                stmt.setNull(5, java.sql.Types.INTEGER);
            }

            if (heroi.getMaoDireta() != null) {
                stmt.setInt(6, heroi.getMaoDireta().getId());
            } else {
                stmt.setNull(6, java.sql.Types.INTEGER);
            }

            if (heroi.getMaoEsquerda() instanceof Armas) {
                stmt.setInt(7, heroi.getMaoEsquerda().getId());
                stmt.setNull(8, java.sql.Types.INTEGER);
            } else if (heroi.getMaoEsquerda() instanceof Escudo) {
                stmt.setNull(7, java.sql.Types.INTEGER);
                stmt.setInt(8, heroi.getMaoEsquerda().getId());
            } else {
                stmt.setNull(7, java.sql.Types.INTEGER);
                stmt.setNull(8, java.sql.Types.INTEGER);
            }
            
            ResultSet rs = stmt.executeQuery(); 
            if (rs.next()) {
                heroi.setId(rs.getInt("id"));
                System.out.println("Heroi inserido com sucesso, ID: " + heroi.getId());
            }
            return heroi;
        }
    }

    public ArrayList<Pocoes> listPocoesByHeroiId(int heroiId) throws SQLException {
        ArrayList<Pocoes> pocoes = new ArrayList<>();
        String sql = "SELECT * FROM heroi_pocoes WHERE heroi_id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, heroiId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pocoes pocao = daoPocoes.getPocaoById(rs.getInt("pocao_id"));
                if (pocao != null) {
                    pocoes.add(pocao);
                }
            }
        }
        return pocoes;
    }

    public ArrayList<Item> listInventarioByHeroiId(int heroiId) throws SQLException {
        ArrayList<Item> inventario = new ArrayList<>();
        String sql = "SELECT * FROM heroi_inventario WHERE heroi_id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, heroiId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int armaId = rs.getInt("arma_id");
                int armaduraId = rs.getInt("armadura_id");
                int escudoId = rs.getInt("escudo_id");

                if (armaId != 0) {
                    inventario.add(daoArma.getArmaById(armaId));
                } else if (armaduraId != 0) {
                    inventario.add(daoArmadura.getArmaduraById(armaduraId));
                } else if (escudoId != 0) {
                    inventario.add(daoEscudo.getEscudoById(escudoId));
                }
            }
        }
        return inventario;
    }
    
    public Heroi getHeroiById(int id) throws SQLException{
        Heroi heroi = null;
        String sql = "SELECT * FROM heroi where id = ?";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Armas maoDireita = null;
                int maoDireitaId = rs.getInt("mao_direita_id");
                if (maoDireitaId != 0) {
                    maoDireita = daoArma.getArmaById(maoDireitaId);
                }

                // mão esquerda
                Item maoEsquerda = null;
                if (maoDireita == null || !maoDireita.isMaoDupla()) {
                    int maoEsquerdaArmaId = rs.getInt("mao_esquerda_arma_id");
                    int maoEsquerdaEscudoId = rs.getInt("mao_esquerda_escudo_id");

                    if (maoEsquerdaEscudoId != 0) {
                        maoEsquerda = daoEscudo.getEscudoById(maoEsquerdaEscudoId);
                    } else if (maoEsquerdaArmaId != 0) {
                        maoEsquerda = daoArma.getArmaById(maoEsquerdaArmaId);
                    }
                }

                // armaduras
                Armaduras capacete = null;
                Armaduras peitoral = null;
                Armaduras botas = null;
                Armaduras calca = null;

                int capaceteId = rs.getInt("armadura_capacete_id");
                int peitoralId = rs.getInt("armadura_peitoral_id");
                int botasId = rs.getInt("armadura_botas_id");
                int calcaId = rs.getInt("armadura_calca_id");

                if (capaceteId != 0) capacete = daoArmadura.getArmaduraById(capaceteId);
                if (peitoralId != 0) peitoral = daoArmadura.getArmaduraById(peitoralId);
                if (botasId != 0)    botas    = daoArmadura.getArmaduraById(botasId);
                if (calcaId != 0)    calca    = daoArmadura.getArmaduraById(calcaId);

                int heroiId = rs.getInt("id");

                heroi = new Heroi(
                    listPocoesByHeroiId(heroiId),
                    listInventarioByHeroiId(heroiId),
                    heroiId,
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
                    calca,
                    rs.getInt("nivel")
                );
            }
             
            return heroi;
        }
    }

    public List<Heroi> listarHerois() throws SQLException {
        String sql = "SELECT * FROM heroi";
        List<Heroi> listHero = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // mão direita
                Armas maoDireita = null;
                int maoDireitaId = rs.getInt("mao_direita_id");
                if (maoDireitaId != 0) {
                    maoDireita = daoArma.getArmaById(maoDireitaId);
                }

                // mão esquerda
                Item maoEsquerda = null;
                if (maoDireita == null || !maoDireita.isMaoDupla()) {
                    int maoEsquerdaArmaId = rs.getInt("mao_esquerda_arma_id");
                    int maoEsquerdaEscudoId = rs.getInt("mao_esquerda_escudo_id");

                    if (maoEsquerdaEscudoId != 0) {
                        maoEsquerda = daoEscudo.getEscudoById(maoEsquerdaEscudoId);
                    } else if (maoEsquerdaArmaId != 0) {
                        maoEsquerda = daoArma.getArmaById(maoEsquerdaArmaId);
                    }
                }

                // armaduras
                Armaduras capacete = null;
                Armaduras peitoral = null;
                Armaduras botas = null;
                Armaduras calca = null;

                int capaceteId = rs.getInt("armadura_capacete_id");
                int peitoralId = rs.getInt("armadura_peitoral_id");
                int botasId = rs.getInt("armadura_botas_id");
                int calcaId = rs.getInt("armadura_calca_id");

                if (capaceteId != 0) capacete = daoArmadura.getArmaduraById(capaceteId);
                if (peitoralId != 0) peitoral = daoArmadura.getArmaduraById(peitoralId);
                if (botasId != 0)    botas    = daoArmadura.getArmaduraById(botasId);
                if (calcaId != 0)    calca    = daoArmadura.getArmaduraById(calcaId);

                int heroiId = rs.getInt("id");

                Heroi h = new Heroi(
                        listPocoesByHeroiId(heroiId),
                        listInventarioByHeroiId(heroiId),
                        heroiId,
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
                        calca,
                        rs.getInt("nivel")
                );

                listHero.add(h);
            }

            if (listHero.isEmpty()) {
                System.out.println("Nenhum heroi cadastrado");
            }

            return listHero;
        }
    }
    
    public int getVidaAtual(int id) throws SQLException{
        int vidaAtual = 0;
        String sql = "selecet vida from heroi where id =?";
        
        try  (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                vidaAtual = rs.getInt("vida");
            }
            return vidaAtual;
        }
    }
    
    public int updateVida(int vidaPerdida, int id) throws SQLException{
        int vidaAtual = 0;
        String sql = "update heroi set vida = ? where id = ?";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            
            int vidaAnterior = getVidaAtual(id);
            vidaAtual = vidaAnterior - vidaPerdida;
            
            if (vidaAtual <= 0) {
                vidaAtual = 0;
                stmt.setInt(1, vidaAtual);
                stmt.setInt(2, id);
            }else{
                stmt.setInt(1, vidaAtual);
                stmt.setInt(2, id);
            }
            return vidaAtual;
        }
    }
    
    public int getManaAtual(int id) throws SQLException{
        int vidaAtual = 0;
        String sql = "selecet mana from heroi where id =?";
        
        try  (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                vidaAtual = rs.getInt("vida");
            }
            return vidaAtual;
        }
    }
    
    public int updateMana(int manaPerdida, int id) throws SQLException{
        int manaAtual = 0;
        String sql = "update heroi set mana = ? where id = ?";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            
            int manaAnterior = getManaAtual(id);
            manaAtual = manaAnterior - manaPerdida;
            
            if (manaAtual <= 0) {
                manaAtual = 0;
                stmt.setInt(1, manaAtual);
                stmt.setInt(2, id);
            }else{
                stmt.setInt(1, manaAtual);
                stmt.setInt(2, id);
            }
            return manaAtual;
        }
    }
    
    public void removeItemInventario(int heroiId, int itemId) throws SQLException {
        String sql = "DELETE FROM heroi_inventario WHERE heroi_id=? AND id=?";
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, heroiId);
            stmt.setInt(2, itemId);
            stmt.executeUpdate();
        }
    }
    
    public void removePocao(int heroiId, int pocaoId) throws SQLException {
        String sql = "UPDATE heroi_pocoes SET quantidade = quantidade - 1 "
                + "WHERE heroi_id=? AND pocao_id=?";
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, heroiId);
            stmt.setInt(2, pocaoId);
            stmt.executeUpdate();
        }
    }
    
    public void trocaCapaceteInventario(int heroiId, int capacateId) throws SQLException{
        String sql = "update heroi_inventario set armadura_capacete_id = ? where id =?";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, capacateId);
            stmt.setInt(2, heroiId);
        }
    }
    
    public void trocaPeitoralInventario(int heroiId, int peitoralId) throws SQLException{
        String sql = "update heroi_inventario set armadura_peitoral_id = ? where id =?";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, peitoralId);
            stmt.setInt(2, heroiId);
        }
    }
    
    public void trocaCalcaInventario(int heroiId, int calcaId) throws SQLException{
        String sql = "update heroi_inventario set armadura_calca_id = ? where id =?";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, calcaId);
            stmt.setInt(2, heroiId);
        }
    }
    
    public void trocaBotasInventario(int heroiId, int botasId) throws SQLException{
        String sql = "update heroi_inventario set armadura_botas_id = ? where id =?";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, botasId);
            stmt.setInt(2, heroiId);
        }
    }
    
    public void trocaArmaInventario(int heroiId, int armaId) throws SQLException{
        String sql = "update heroi_inventario set arma = ? where id =?";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, armaId);
            stmt.setInt(1, heroiId);
        }
    }
    
    public void trocaEscudoInventario(int heroiId, int escudoId) throws SQLException{
        String sql = "update heroi_inventario set arma = ? where id =?";
        
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, escudoId);
            stmt.setInt(1, heroiId);
        }
    }
    
    
}