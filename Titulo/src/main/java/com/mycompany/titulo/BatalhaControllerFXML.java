/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.titulo;

import Controller.BatalhaController;
import Controller.Sessao;
import Model.Batalha;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author user
 */
public class BatalhaControllerFXML implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Batalha batalha = Sessao.getBatalhaAtual();
        setBatalha(batalha);
        atualizarTela(); // popula a tela com os dados da batalha
    }

    @FXML
    private Label labelTurno;
    @FXML
    private Label labelNomeHeroi;
    @FXML
    private Label labelVidaHeroi;
    @FXML
    private ProgressBar barVidaHeroi;
    @FXML
    private Label labelNomeInimigo;
    @FXML
    private Label labelVidaInimigo;
    @FXML
    private ProgressBar barVidaInimigo;
    @FXML
    private Button btnAtacar;
    @FXML
    private Button btnDefender;
    @FXML
    private Button btnMagia;
    @FXML
    private Button btnUsarItem;

    private Batalha batalha;
    private BatalhaController batalhaController = new BatalhaController();
    
    

    public void setBatalha(Batalha batalha) {
        this.batalha = batalha;
        atualizarTela();
    }

    private void atualizarTela() {
        labelTurno.setText("Turno " + batalha.getTurnoAtual());

        labelNomeHeroi.setText(batalha.getHeroi().getNome());
        labelVidaHeroi.setText(batalha.getHeroi().getVida() + " / " + batalha.getHeroi().getVidaMx());
        barVidaHeroi.setProgress((double) batalha.getHeroi().getVida() / batalha.getHeroi().getVidaMx());

        labelNomeInimigo.setText(batalha.getInimigo().getNome());
        labelVidaInimigo.setText(batalha.getInimigo().getVida() + " / " + batalha.getInimigo().getVidaMx());
        barVidaInimigo.setProgress((double) batalha.getInimigo().getVida() / batalha.getInimigo().getVidaMx());

        // desabilita botões se batalha encerrada
        boolean encerrada = batalha.isBatalhaEncerrada();
        btnAtacar.setDisable(encerrada);
        btnDefender.setDisable(encerrada);
        btnMagia.setDisable(encerrada);
        btnUsarItem.setDisable(encerrada);
    }

    @FXML
    private void handleAtacar() {
        batalhaController.Atacar(batalha);       // herói ataca
        batalhaController.InimigoAtacar(batalha); // inimigo contra-ataca sem dado de defesa
        verificarFimDeBatalha();
        atualizarTela();
    }

    @FXML
    private void handleDefender() {
        batalhaController.Defender(batalha);
        batalhaController.Atacar(batalha);
        atualizarTela();
    }

//    @FXML
//    private void handleMagia() {
//        batalhaController.usarMagia(batalha);
//        batalhaController.inimigoAtacar(batalha);
//        atualizarTela();
//    }

    @FXML
    private void handleUsarItem() {
        // abre tela de seleção de item
    }    
    
    private void verificarFimDeBatalha() {
        boolean perdeu = false;
        if (batalha.isBatalhaEncerrada()) {
            if (batalha.getHeroi().getVida() > 0 && batalha.getInimigo().getVida() <= 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Vitória!");
                alert.setHeaderText("Você venceu!");
                alert.setContentText("Você derrotou " + batalha.getInimigo().getNome() + "!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Derrota");
                alert.setHeaderText("Você foi derrotado!");
                alert.setContentText("GAME OVER");
                alert.showAndWait();
                perdeu = true;
            }

            try {
                App.setRoot("Lobby");
                if (perdeu) {
                    Sessao.encerrar();
                    App.setRoot("Inicio");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
