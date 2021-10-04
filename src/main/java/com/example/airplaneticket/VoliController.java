package com.example.airplaneticket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
    Classe per 
*/

public class VoliController implements Initializable {
    public Text textBigliettiEsauriti;
    SceneChanger sceneChanger = new SceneChanger();
    dbConnection db = null;
    public TableView<Volo> tabellaVoli;
    public TableColumn<Volo, Integer> colNumeroVolo;
    public TableColumn<Volo, String> colPartenza;
    public TableColumn<Volo, String> colDestinazione;
    public TableColumn<Volo, String> colDataPartenza;
    public TableColumn<Volo, String> colDataArrivo;
    public TableColumn<Volo, String> colNumeroPosti;
    public TableColumn<Volo, Double> colPrezzo;
    public TableColumn<Volo, Integer> colCapacita;
    public Button btnVisualizzaBiglietto;
    ObservableList<String> citta = FXCollections.observableArrayList();
    private final ObservableList<Volo> voli = FXCollections.observableArrayList();
    public ComboBox<String> partenzaComboBox = new ComboBox<>(citta);
    public ComboBox<String> destinazioneComboBox = new ComboBox<>(citta);

    
    //Metodo Singleton per 
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ResultSet rs = null;
        try {
            dbConnection db = dbConnection.getInstance();
            rs = db.selectQuery("SELECT DISTINCT partenza FROM (SELECT partenza FROM volo union SELECT destinazione from volo);");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                citta.add(rs.getString("partenza"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        citta.add(null);
        partenzaComboBox.setItems(citta);
        destinazioneComboBox.setItems(citta);
        colCapacita.setCellValueFactory(new PropertyValueFactory<>("capacita"));
        colPrezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        colPartenza.setCellValueFactory(new PropertyValueFactory<>("partenza"));
        colDestinazione.setCellValueFactory(new PropertyValueFactory<>("destinazione"));
        colDataArrivo.setCellValueFactory(new PropertyValueFactory<>("dataArrivo"));
        colNumeroVolo.setCellValueFactory(new PropertyValueFactory<>("nVolo"));
        colDataPartenza.setCellValueFactory(new PropertyValueFactory<>("dataPartenza"));
        colNumeroPosti.setCellValueFactory(new PropertyValueFactory<>("capacita"));
        try {
            AggiornaTabella(null);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Metodo per aggiornare i campi della tabella una volta selezionato un filtro
    public void AggiornaTabella(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        voli.clear();
        db = dbConnection.getInstance();
        String partenza = partenzaComboBox.getValue();
        String destinazione = destinazioneComboBox.getValue();
        ResultSet rs;

        if (partenza == null && destinazione == null) {
            rs = db.selectQuery("SELECT * from volo;");
        } else if (destinazione == null) {
            rs = db.selectQuery("SELECT * from volo where partenza = '" + partenza + "';");
        } else if (partenza == null) {
            rs = db.selectQuery("SELECT * from volo where destinazione = '" + destinazione + "';");
        } else {
            rs = db.selectQuery("SELECT * from volo where partenza = '" + partenza + "' AND destinazione = '" + destinazione + "';");
        }

        while (rs.next()) {
            voli.add(new Volo(rs.getString("destinazione"), rs.getString("partenza"), rs.getInt("nVolo"),
                    rs.getString("dataPartenza"), rs.getString("dataArrivo"), rs.getInt("capacita"), rs.getDouble("prezzo")));
        }
        tabellaVoli.setItems(voli);
    }

    //Metodo per tornare all'interfaccia precedente
    public void indietroMenu(ActionEvent actionEvent) throws IOException {
        sceneChanger.cambiaScena("actions-view.fxml", 1021, 717, actionEvent);
    }

    //metodo collegato al button visualizza biglietto
    public void visualizzaBiglietto(ActionEvent actionEvent) throws IOException {
        Biglietto bi = Biglietto.getInstance();
        Volo v = tabellaVoli.getSelectionModel().getSelectedItem();
        if (v != null) {
            if (v.getCapacita() > 0) {
                bi.setDataArrivo(v.getDataArrivo());
                bi.setDataPartenza(v.getDataPartenza());
                bi.setPartenza(v.getPartenza());
                bi.setDestinazine(v.getDestinazione());
                bi.setPrezzo(v.getPrezzo());
                bi.setnVolo(v.getNVolo());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("biglietto-view.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setScene(new Scene(loader.load()));
                stage.setTitle("biglietto");
                stage.show();
            }
            else {
                textBigliettiEsauriti.setText("Biglietti esauriti");
            }
        }
    }
}


