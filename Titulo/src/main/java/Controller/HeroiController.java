package Controller;

import Dao.DaoArmas;
import Dao.DaoHeroi;
import Model.Armas;
import Model.Heroi;
import Util.TipoArma;

/**
 *
 * @author user
 */
public class HeroiController {
    DaoHeroi daoHeroi = new DaoHeroi();
    
    public void InsertHeroiController(String nome, int escolha){
        try {
            DaoArmas daoArmas = new DaoArmas();
            
            
            // 1 --> se refere a armas leves 
            if (escolha == 1) {
                Armas arma = daoArmas.getArmaRandowByTipoComun(TipoArma.leve);
            }
        } catch (Exception e) {
        }
    }
}
