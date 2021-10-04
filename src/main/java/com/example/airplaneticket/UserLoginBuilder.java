package com.example.airplaneticket;

import javafx.event.ActionEvent;
import java.io.IOException;

/*  Costruttore delle interfacce utente che implementa l'interfaccia ILoginBuilder
    per la creazione dell'interfaccia per user
 * */


public class UserLoginBuilder implements ILoginBuilder {
    SceneChanger sceneChanger = new SceneChanger();

    @Override
    public void buildInterface(ActionEvent actionEvent) throws IOException {
        sceneChanger.cambiaScena("actions-view.fxml",1016,872,actionEvent);
    }
}
