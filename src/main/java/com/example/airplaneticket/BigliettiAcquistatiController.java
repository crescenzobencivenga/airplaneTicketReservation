package com.example.airplaneticket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/* classe controller per l'interfaccia che permette di visualizzare i biglietti acquistati
*/

public class BigliettiAcquistatiController implements Initializable {
    SceneChanger sceneChanger = new SceneChanger();
    public TableColumn<Volo, Integer> colNumeroVolo;
    public TableColumn<Volo, String> colPartenza;
    public TableColumn<Volo, String> colDestinazione;
    public TableColumn<Volo, String> colDataPartenza;
    public TableColumn<Volo, String> colDataArrivo;
    public TableView<Volo> tabellaBiglietti;
    private final ObservableList<Volo> biglietti = FXCollections.observableArrayList();

    
    /** metodo collegato al button indietro
    */
    public void indietroMenu(ActionEvent actionEvent) throws IOException {
        sceneChanger.cambiaScena("actions-view.fxml",1021,717,actionEvent);
    }

    // metodo per l'inizializzazione dei campi della tabella contenente i biglietti
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {                    
        colPartenza.setCellValueFactory(new PropertyValueFactory<>("partenza"));
        colDestinazione.setCellValueFactory(new PropertyValueFactory<>("destinazione"));
        colDataArrivo.setCellValueFactory(new PropertyValueFactory<>("dataArrivo"));
        colNumeroVolo.setCellValueFactory(new PropertyValueFactory<>("nVolo"));
        colDataPartenza.setCellValueFactory(new PropertyValueFactory<>("dataPartenza"));
        dbConnection db = null;
        ResultSet rs = null;
        try {
            db = dbConnection.getInstance();
            rs = db.selectQuery("SELECT destinazione,partenza,nVolo,dataPartenza,dataArrivo from volo where nVolo IN (SELECT numeroVolo from bigliettiAcquistati where idUser = "+Utente.getInstance().getId()+");");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                biglietti.add(new Volo(rs.getString("destinazione"),rs.getString("partenza"),rs.getInt("nVolo"),rs.getString("dataPartenza"),rs.getString("dataArrivo"),0,0));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        tabellaBiglietti.setItems(biglietti);
    }
}

