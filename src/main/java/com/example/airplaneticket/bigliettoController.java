package com.example.airplaneticket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

/**
@author Morlando Pasquale, Bencivenga Crescenzo
Classe per l'acqquisto del biglietto
*/
public class bigliettoController  implements Initializable{
    SceneChanger sceneChanger = new SceneChanger();
    @FXML
    private TextField textPartenza;

    @FXML
    private TextField textDestinazione;

    @FXML
    private TextField textNVolo;

    @FXML
    private TextField textDataPartenza;

    @FXML
    private TextField textDataArrivo;

    @FXML
    private TextField textPrezzo;

    //Metodo per l'inizializzazione del biglietto
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Biglietto bi = Biglietto.getInstance();
        textPartenza.setText(bi.getPartenza());
        textDestinazione.setText(bi.getDestinazine());
        textDataArrivo.setText(bi.getDataArrivo().toString());
        textDataPartenza.setText(bi.getDataPartenza().toString());
        textPrezzo.setText(bi.getPrezzo().toString());
        textNVolo.setText(String.valueOf(bi.getNVolo()));
    }
    
    //Metodo collegato al button acquista, per l'acquisto del biglietto
    public void acquistaBiglietto(ActionEvent actionEvent) throws IOException {
        sceneChanger.cambiaScena("acquista-view.fxml",697,550,actionEvent);
    }
}
