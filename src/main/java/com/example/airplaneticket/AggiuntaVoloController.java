package com.example.airplaneticket;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.sql.SQLException;

/*  controller class per l'interfaccia che permette all'amministratore di aggigungere voli
* */

public class AggiuntaVoloController {
    public TextField textPrezzo;
    public TextField textDestinazione;
    public TextField textPartenza;
    public DatePicker dataPartenza;
    public DatePicker dataArrivo;
    public TextField capacita;
    static CommandProxy aggiungiVolo = new CommandProxy(new AggiungiVoloCommand()); //proxy per l'accesso ai command

    // metodo collegato al button per l'aggiunta del volo
    public void aggiungiVolo(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        System.out.println(dataPartenza.getValue().toString()
        );
        Volo v = new Volo(textDestinazione.getText(),textPartenza.getText(), 0 , dataPartenza.getValue().toString(),dataArrivo.getValue().toString(),Integer.parseInt(capacita.getText()),Integer.parseInt(textPrezzo.getText()));
        aggiungiVolo.executeCommand(v);
        Window window = textPrezzo.getScene().getWindow();
        window.hide();
    }
    //  metodo per cancellare il contenuto inserito nei campi
    public void cancella(ActionEvent actionEvent) {
        textDestinazione.clear();
        textPartenza.clear();
        textPrezzo.clear();
        capacita.clear();
    }
}
