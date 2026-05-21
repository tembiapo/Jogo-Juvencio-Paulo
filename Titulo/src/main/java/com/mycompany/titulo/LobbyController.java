package com.mycompany.titulo;

import java.io.IOException;
import javafx.fxml.FXML;

public class LobbyController {

    @FXML
    private void actionIrBatalha() throws IOException {
        App.setRoot("Batalha");
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