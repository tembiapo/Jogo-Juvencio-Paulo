package Controller;

import Dao.DaoInimigo;
import Model.Batalha;
import Model.Escudo;
import Model.Personagem;

/**
 *
 * @author user
 */
public class BatalhaController {
    public void Atacar(Batalha batalha){
        Personagem jogador = batalha.getHeroi();
        Personagem inimigo = batalha.getInimigo();

        // jogador ataca — inimigo rola dado de defesa normalmente
        int danoAtaque = jogador.calcularDanoAtaque();
        int defesaInimigo = inimigo.calcularDefesa() - jogador.getAgilidade();
        int danoFinal = Math.max(0, danoAtaque - defesaInimigo);
        inimigo.setVida(inimigo.getVida() - danoFinal);
        System.out.println(jogador.getNome() + " atacou causando " + danoFinal + " de dano!");

        // inimigo contra-ataca — jogador NÃO rola dado, só usa atributo fixo (armaduras)
        int danoInimigoAtaque = inimigo.calcularDanoAtaque();
        int defesaFixaJogador = (jogador.getDefesa() + jogador.getArmaduraBotas().getDefesaBase() + jogador.getArmaduraCalca().getDefesaBase()
                                + jogador.getArmaduraPeitoral().getDefesaBase() + jogador.getArmaduraCapacete().getDefesaBase()) 
                                - inimigo.getAgilidade(); // sem dado!
        //se for escudo
        if (jogador.getMaoEsquerda() instanceof  Escudo) {
            Escudo armaEsquerda = (Escudo) jogador.getMaoEsquerda();
            defesaFixaJogador += armaEsquerda.getBloqueioBase();
        }
        int danoFinalInimigo = Math.max(0, danoInimigoAtaque - defesaFixaJogador);
        jogador.setVida(jogador.getVida() - danoFinalInimigo);
        System.out.println(inimigo.getNome() + " contra-atacou causando " + danoFinalInimigo + " de dano!");

        batalha.proximoTurno();
    }
    
    public void Defender(Batalha batalha){
        Personagem jogador = batalha.getHeroi();
        Personagem inimigo = batalha.getInimigo();
        
        int danoAtaque = inimigo.calcularDanoAtaque();
        int defesaAtaque = jogador.calcularDefesa() - inimigo.getAgilidade();
        
        int danoFinal = Math.max(0, danoAtaque - defesaAtaque);
        inimigo.setVida(jogador.getVida() - danoFinal);
        
        System.out.println(inimigo.getNome() + " atacou causando " + danoFinal + " de dano!");
        System.out.println(jogador.getNome() + " tem " + jogador.getVida() + " de vida restante!");
        
        batalha.proximoTurno();
    }
    
    
    public void IniciarBatalha(){
        DaoInimigo daoInimigo = new DaoInimigo();
        
    }
}
