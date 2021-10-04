package com.example.airplaneticket;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
    Classe utilizzata per il cambio di view e caricamento della classe controller relativa
*/
public class SceneChanger {
    public void cambiaScena(String scena,int width,int height, ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scena));
        Scene scene = new Scene(loader.load(), width, height);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setTitle(scena.substring(0,scena.length()-10));
        window.setScene(scene);
        window.show();
    }
}
