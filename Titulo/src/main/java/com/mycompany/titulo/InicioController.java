package com.mycompany.titulo;

import java.io.IOException;
import javafx.fxml.FXML;

public class InicioController {

    @FXML
    private void actionIniciar() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void actionRank() throws IOException {
        App.setRoot("Rank");
    }
    
    @FXML
    private void actionSair() throws IOException{
        
    }
}
