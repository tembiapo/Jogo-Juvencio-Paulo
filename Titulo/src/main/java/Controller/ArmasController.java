/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DaoArmas;
import Model.Armas;
import Util.Raridade;
import Util.TipoArma;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ArmasController {
    DaoArmas daoArma;
    
    public void InsertArmaController(Armas arma){
        try {
            daoArma.insertArma(arma);
        } catch (Exception e) {
            System.err.println("Erro ao inserir arma: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Armas getArmaByIdController(int id) {
        try {
            return daoArma.getArmaById(id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar arma: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Armas> listarArmasController() {
        try {
            return daoArma.listarArmas();
        } catch (Exception e) {
            System.err.println("Erro ao listar armas: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>(); // vai retornar a lista vazia se der algum erro
        }
    }

    public void updateArmaController(Armas arma) {
        try {
            daoArma.updateArma(arma);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar arma: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void updateNomeArmaController(String novoNome, int id) {
        try {
            daoArma.updateNomeArma(novoNome, id);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar nome da arma: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateContraEfeitoArmaController(int novoContraEfeito, int id) {
        try {
            daoArma.updateContraEfeitoArma(novoContraEfeito, id);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar contraefeito da arma: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateDanoBaseArmaController(int novoDanoBase, int id) {
        try {
            daoArma.updateDanoBaseArma(novoDanoBase, id);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar danoBase da arma: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateMaoDuplaArmaController(boolean novaMaoDupla, int id) {
        try {
            daoArma.updateMaoDuplaArma(novaMaoDupla, id);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar maoDupla da arma: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateTipoArmaController(TipoArma novoTipo, int id) {
        try {
            daoArma.updateTipoArma(novoTipo, id);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar tipo da arma: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateRaridadeArmaController(Raridade novaRaridade, int id) {
        try {
            daoArma.updateRaridadeArma(novaRaridade, id);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar raridade da arma: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updatePrecoArmaController(int novoPreco, int id) {
        try {
            daoArma.updatePrecoArma(novoPreco, id);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar preco da arma: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateDescricaoArmaController(String novaDescricao, int id) {
        try {
            daoArma.updateDescricaoArma(novaDescricao, id);
        } catch (Exception e) {
            System.err.println("Erro ao atualizar descricao da arma: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteArmaController(int id) {
        try {
            daoArma.deleteArma(id);
        } catch (Exception e) {
            System.err.println("Erro ao deletar arma: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
