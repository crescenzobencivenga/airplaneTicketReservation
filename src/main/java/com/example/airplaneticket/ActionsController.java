package com.example.airplaneticket;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.io.IOException;

/** 
*   @author Morlando Pasquale, Bencivenga Crescenzo
*    Controller class per l'interfaccia utente dove viene selezionato
*   se visualizzare i voli disponibili o visualizzare i biglietti acquistati
*/

public class ActionsController {
    SceneChanger sceneChanger = new SceneChanger();
    public Button bntVisualizzaVoli;
    public Button btnVisualizzaBigliettiAcquistati;

    //  metodo collegato al button visualizzavoli

    public void visualizzaVoli(ActionEvent actionEvent) throws IOException {
        sceneChanger.cambiaScena("voli-view.fxml",1016,872,actionEvent);
    }
    // metodo collegato al button visualizza biglietti acquistati
    public void visualizzaBigliettiAcquistati(ActionEvent actionEvent) throws IOException {
        sceneChanger.cambiaScena("bigliettiAcquistati-view.fxml",1016,872,actionEvent);
    }
}
