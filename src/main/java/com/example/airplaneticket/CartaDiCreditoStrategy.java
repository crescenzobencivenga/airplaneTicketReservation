package com.example.airplaneticket;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

public class CartaDiCreditoStrategy implements IStrategiaPagamento {
    SceneChanger sceneChanger = new SceneChanger();
    public Button btnPaga;
    public TextField dataScadenza;
    public TextField cvv;
    public TextField numeroCarta;
    public TextField nome;

    @Override
    public void paga(ActionEvent actionEvent) throws IOException {
        sceneChanger.cambiaScena("cartaDiCredito-view.fxml",876,595,actionEvent);
    }

    public void effettuaPagamento(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        Biglietto bi = Biglietto.getInstance();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Carta di Credito");
        alert.setContentText("Pagamentodi " + bi.getPrezzo() +" effettuato con carta di credito");
        alert.showAndWait();
        Window window = btnPaga.getScene().getWindow();
        window.hide();
        dbConnection.getInstance().insertQuery("Insert into bigliettiAcquistati values ('"+bi.getNVolo()+"','"+Utente.getInstance().getId()+"');");
        int nuovaCapacita = dbConnection.getInstance().selectQuery("SELECT capacita FROM volo WHERE nVolo="+bi.getNVolo()+";").getInt("capacita") - 1;
        dbConnection.getInstance().insertQuery("UPDATE volo SET capacita="+nuovaCapacita +" WHERE nVolo = "+bi.getNVolo()+";");
    }
}
