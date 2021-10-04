package com.example.airplaneticket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
    @author Morlando Pasquale, Bencivenga Crescenzo
    Controller class per l'interfaccia dell'admin
*/

public class GestioneVoliController implements Initializable {

    public Button btnEliminaVolo;
    public Button undoOp;
    SceneChanger cambiaScena = new SceneChanger();
    public TableView<Volo> tabellaVoli;
    public TableColumn<Volo, Integer> colNumeroVolo;
    public TableColumn<Volo, String> colPartenza;
    public TableColumn<Volo, String> colDestinazione;
    public TableColumn<Volo, String> colDataPartenza;
    public TableColumn<Volo, String> colDataArrivo;
    public TableColumn<Volo, String> colNumeroPosti;
    public TableColumn<Volo, Double> colPrezzo;
    private final ObservableList<Volo> voli = FXCollections.observableArrayList();
    public int lastCommand;
    ICommandVoli commandProxy = new CommandProxy(new EliminaVoloCommand());

     /**  
     *metodo per l'inizializzazione dei campi della tabella contenente i voli
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colPrezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        colPartenza.setCellValueFactory(new PropertyValueFactory<>("partenza"));
        colDestinazione.setCellValueFactory(new PropertyValueFactory<>("destinazione"));
        colDataArrivo.setCellValueFactory(new PropertyValueFactory<>("dataArrivo"));
        colNumeroVolo.setCellValueFactory(new PropertyValueFactory<>("nVolo"));
        colDataPartenza.setCellValueFactory(new PropertyValueFactory<>("dataPartenza"));
        colNumeroPosti.setCellValueFactory(new PropertyValueFactory<>("capacita"));
        dbConnection db = null;
        ResultSet rs = null;

        try {
            db = dbConnection.getInstance();
            rs = db.selectQuery("SELECT * from volo;");

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
                voli.add(new Volo(rs.getString("destinazione"),rs.getString("partenza"),rs.getInt("nVolo"),rs.getString("dataPartenza"),rs.getString("dataArrivo"),rs.getInt("capacita"),rs.getDouble("prezzo")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        tabellaVoli.setItems(voli);
    }


    /**
    *   metodo per aggionare i campi della tabella una volta effettuate operazioni di inserimento o eliminazione di un volo
    */
    public void AggiornaTabella(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        voli.clear();
        dbConnection db = dbConnection.getInstance();
        ResultSet rs = db.selectQuery("SELECT * from volo;");
        while (rs.next()){
            voli.add(new Volo(rs.getString("destinazione"),rs.getString("partenza"),rs.getInt("nVolo"),rs.getString("dataPartenza"),rs.getString("dataArrivo"),rs.getInt("capacita"),rs.getDouble("prezzo")));
        }
        tabellaVoli.setItems(voli);
    }


    // metodo collegato al button elimina volo
    public void eliminaVolo(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, NoSuchMethodException {
        Volo v = tabellaVoli.getSelectionModel().getSelectedItem();
        if (v != null) {
            commandProxy.executeCommand(v);
            AggiornaTabella(actionEvent);
            lastCommand = 1;
        }
    }

    // metodo collegato al button aggiungi volo
    public void aggiungiVolo(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("aggiuntaVolo-view.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("biglietto");
        stage.showAndWait();
        AggiornaTabella(actionEvent);
        lastCommand = 2;
    }

    // metodo collegato al button cancella ultima operazione
    public void undoOp(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (lastCommand == 1){
            commandProxy.undoCommand();
            lastCommand = 0;
        }else if (lastCommand == 2){
            AggiuntaVoloController.aggiungiVolo.undoCommand();
            lastCommand=0;
        }
        AggiornaTabella(actionEvent);
    }
}
