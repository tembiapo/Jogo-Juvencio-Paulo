package com.mycompany.titulo;

import Controller.BatalhaController;
import Controller.Sessao;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class LobbyController {
    

    @FXML
    private void actionIrBatalha() throws IOException {
        BatalhaController batalhaController = new BatalhaController();
        batalhaController.IniciarBatalha();
        if (Sessao.getBatalhaAtual() != null) {
            App.setRoot("Batalha");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Nenhum inimigo disponível");
            alert.setContentText("Não há inimigos disponíveis para batalha. Verifique o banco de dados.");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void actionIrMaga() throws IOException {
        App.setRoot("Maga");
    }
    
    @FXML
    private void actionIrMercador() throws IOException {
        App.setRoot("Mercador");
    }
    
    @FXML
    private void actionIrInventarioFXML() throws IOException {
        App.setRoot("InventarioFXML");
    }
}