package com.example.airplaneticket;

import javafx.event.ActionEvent;
import java.io.IOException;

/** 
* @author Morlando Pasquale, Bencivenga Crescenzo
* Costruttore delle interfacce utente che implementa l'interfaccia ILoginBuilder
* per la creazione dell'interfaccia per l'admin
*/


public class AdminLoginBuilder implements ILoginBuilder {
    SceneChanger sceneChanger = new SceneChanger();

    @Override
    public void buildInterface(ActionEvent actionEvent) throws IOException {
        sceneChanger.cambiaScena("gestioneVoli-view.fxml",1016,872,actionEvent);
    }
}
