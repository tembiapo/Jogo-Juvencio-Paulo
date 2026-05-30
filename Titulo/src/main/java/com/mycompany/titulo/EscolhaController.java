/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.titulo;

import Controller.HeroiController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EscolhaController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    HeroiController heroiController = new HeroiController();
    
    @FXML
    private TextField nomePesonagem;
    
    @FXML
    private Button armaLeveButton;
    
    @FXML
    private Button armaPesadaButton;
    
    @FXML
    private void escolhaLeve() throws IOException{
        heroiController.InsertHeroiController(nomePesonagem.getText(), 1);
        App.setRoot("Lobby");
    }
    
    @FXML
    private void escolhaPesada() throws IOException{
        heroiController.InsertHeroiController(nomePesonagem.getText(), 2);
        App.setRoot("Lobby");
    }
    
}
