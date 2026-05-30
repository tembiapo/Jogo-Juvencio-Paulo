package Controller;

import Dao.DaoArmaduras;
import Dao.DaoArmas;
import Dao.DaoHeroi;
import Model.Armaduras;
import Model.Armas;
import Model.Heroi;
import Model.Item;
import Util.Raridade;
import Util.TipoArma;
import Util.TipoArmadura;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class HeroiController {
    DaoHeroi daoHeroi = new DaoHeroi();
    
    public void InsertHeroiController(String nome, int escolha){
        try {
            DaoArmas daoArmas = new DaoArmas();
            DaoArmaduras daoArmaduras =  new DaoArmaduras();
            Armas arma = null;
            Armas armaSegundaria = null;
            
            Armaduras armaduraCapacete = daoArmaduras.ParteArmaduraRandowPorRaridade(Raridade.comun, TipoArmadura.capacete);
            Armaduras armaduraPeitoral = daoArmaduras.ParteArmaduraRandowPorRaridade(Raridade.comun, TipoArmadura.peitoral);
            Armaduras armaduraCalca = daoArmaduras.ParteArmaduraRandowPorRaridade(Raridade.comun, TipoArmadura.calcas);
            Armaduras armaduraBotas = daoArmaduras.ParteArmaduraRandowPorRaridade(Raridade.comun, TipoArmadura.botas);
            
            // 1 --> se refere a armas leves
            // 
            switch (escolha) {
                case 1:
                    arma = daoArmas.getArmaRandowByTipoComun(TipoArma.leve);
                    armaSegundaria = daoArmas.getArmaRandowByTipoComun(TipoArma.escudo);
                    break;
                case 2:
                    arma = daoArmas.getArmaRandowByTipoComun(TipoArma.pesada);
                    break;
                default:
                    System.err.println("Escolha inválida: " + escolha + ". Use 1 para leve ou 2 para pesada.");
                    return; // encerra sem inserir herói com dados errados
            }
            
            // verifica se os itens foram encontrados no banco
            if (arma == null) {
                System.err.println("Nenhuma arma encontrada para a escolha: " + escolha);
                return;
            }
            if (armaduraCapacete == null || armaduraPeitoral == null || armaduraCalca == null || armaduraBotas == null) {
                System.err.println("Erro ao buscar armaduras iniciais — verifique se há armaduras comuns cadastradas.");    
                return;
            }
            
            daoHeroi.insertHeroi(new Heroi(null, null, nome, 100, 100, 0, 0, 0, 0, 0, 0, arma, armaSegundaria, armaduraCapacete, armaduraPeitoral, armaduraBotas,armaduraCalca));
        } catch (SQLException e) {
            System.err.println("Erro ao inserir herói: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Heroi getHeroiByIdController(int id) {
        try {
            List<Heroi> herois = daoHeroi.listarHerois();
            return herois.stream()
                    .filter(h -> h.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (SQLException e) {
            System.err.println("Erro ao buscar herói: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Heroi> listarHeroisController() {
        try {
            List<Heroi> lista = daoHeroi.listarHerois();
            if (lista.isEmpty()) {
                System.err.println("Nenhum herói cadastrado");
            }
            return lista;
        } catch (SQLException e) {
            System.err.println("Erro ao listar heróis: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ArrayList<Item> getInventarioController(int heroiId) {
        try {
            return daoHeroi.listInventarioByHeroiId(heroiId);
        } catch (SQLException e) {
            System.err.println("Erro ao buscar inventário: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
