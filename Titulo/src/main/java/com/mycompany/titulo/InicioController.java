package com.mycompany.titulo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class InicioController implements Initializable {
    @FXML
    private WebView gifView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String gifPath = getClass().getResource("/com/mycompany/titulo/imagens/fundoPegandoFogo.gif").toExternalForm();
        gifView.getEngine().loadContent(
                "<html><body style='margin:0;background:black;'>"
                + "<img src='" + gifPath + "' width='100%' height='100%'/>"
                + "</body></html>"
        );
    }

    @FXML
    private void actionIniciar() throws IOException {
        App.setRoot("Escolha");
    }
    
    @FXML
    private void actionRank() throws IOException {
        App.setRoot("Rank");
    }
    
    @FXML
    private void actionSair() throws IOException{
        
    }
    
    
}
