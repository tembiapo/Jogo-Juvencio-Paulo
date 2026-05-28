package Dao;

import Model.Armaduras;
import Model.Armas;
import Model.Escudo;
import Model.Heroi;
import Model.Item;
import Model.Pocoes;
import Util.ConnectionFactory;
import Util.Raridade;
import Util.TipoArma;
import Util.TipoArmadura;
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
public class DaoHeroi {
    DaoArmas daoArma;
    DaoEscudos daoEscudo;
    DaoArmaduras daoArmadura;
    DaoPocoes daoPocoes;
    int linhasAfetadas;
    
    public void InsertHeroi(Heroi heroi) throws SQLException{
        String sql = "insert into heroi (nome, armadura_id, mao_direita_id, mao_esquerda_arma_id, mao_esquerda_escudo_id)"
                + "values (?,?,?,?,?)";
        
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, heroi.getNome());
            stmt.setInt(2, heroi.getArmadura().getId());
            
            linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Heroi inserido com sucesso");
            }
        }       
    }
    
    public Armas GetArmaById(int id) throws SQLException{
        Armas arma =  new Armas();
        String sql = "select * from arma where id = ?";
        
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery(); 
            if (rs.next()) {
                //int danoBase, boolean maoDupla, TipoArma tipoArma, int id, String nome, String descricao, int preco, Raridade raridade, int contraEfeito
                arma = new Armas(
                        rs.getInt("danoBase"),
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
    
    public ArrayList<Pocoes> ListPocoesByHeroiId(int heroiId) throws SQLException {
    ArrayList<Pocoes> pocoes = new ArrayList<>();
    String sql = "SELECT * FROM heroi_pocoes WHERE heroi_id = ?";

    try (Connection connection = ConnectionFactory.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setInt(1, heroiId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Pocoes pocao = getPocaoById(rs.getInt("pocao_id"));
            if (pocao != null) {
                pocoes.add(pocao);
            }
        }
    }
    return pocoes;
    }
    
    public ArrayList<Item> ListInventarioByHeroiId(int heroiId) throws SQLException {
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
                inventario.add(GetArmaById(armaId));
            } else if (armaduraId != 0) {
                inventario.add(getArmaduraById(armaduraId));
            } else if (escudoId != 0) {
                inventario.add(getEscudoById(escudoId));
            }
        }
    }
    return inventario;
    }
    
    public List<Heroi> ListarHerois() throws SQLException{
        String sql = "select * from heroi";
        List<Heroi> ListHero =  new ArrayList<>();
        Item maoEsquerda = null;
        
        
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            
            ResultSet rs = stmt.executeQuery();                        
                       
            while (rs.next()) {  
                Armas maodireita = GetArmaById(rs.getInt("mao_direita_id"));
                if (maodireita.isMaoDupla() == false) {
                    // verifica qual está preenchido no banco
                    int maoEsquerdaArmaId = rs.getInt("mao_esquerda_arma_id");
                    int maoEsquerdaEscudoId = rs.getInt("mao_esquerda_escudo_id");

                    if (maoEsquerdaEscudoId != 0) {
                        maoEsquerda = daoEscudo.getEscudoById(maoEsquerdaEscudoId);
                    } else if (maoEsquerdaArmaId != 0) {
                        maoEsquerda = daoArma.getArmaById(maoEsquerdaArmaId);
                    } 
                }

                Armaduras armadura = null;
                int armaduraId = rs.getInt("armadura_id");
                if (armaduraId != 0) {
                    armadura = daoArmadura.getArmaduraById(armaduraId);
                }
                
                Heroi h = new Heroi(
                        ListPocoesByHeroiId(rs.getInt("id")),
                        ListInventarioByHeroiId(rs.getInt("id")),
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("vida"),
                        rs.getInt("vidaMx"),
                        rs.getInt("mana"),
                        rs.getInt("manaMx"),
                        rs.getInt("dano"),
                        rs.getInt("defesa"),
                        rs.getInt("agilidade"),
                        rs.getInt("magia"),                    
                        maodireita,
                        maoEsquerda,
                        armadura
                        );
                
                
            ListHero.add(h);
            }       
                        
            if(ListHero.isEmpty()){
                System.out.println("Nenhum heroi cadastrado");
            }
            
            return ListHero;            
        }
    }
}

