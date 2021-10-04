package com.example.airplaneticket;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

/**
    @author Morlando Pasquale, Bencivenga Crescenzo
    Classe che implementa una strategia di pagamento
*/

public class PaypalControllerStrategy implements IStrategiaPagamento {
    SceneChanger sceneChanger = new SceneChanger();
    public TextField username;
    public PasswordField password;
    public Button btnPaga;

    
    @Override
    public void paga(ActionEvent actionEvent) throws IOException {
        sceneChanger.cambiaScena("paypal-view.fxml",742,544,actionEvent);
    }
    
    //metodo collegato al button paga per il pagamento con PayPal che conferma il pagamento
    public void effettuaPagamento(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        Biglietto bi = Biglietto.getInstance();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Paypal");
        alert.setContentText("Pagamento di " + bi.getPrezzo() +" effettuato con paypal");
        alert.showAndWait();
        Window window = username.getScene().getWindow();
        window.hide();
        dbConnection.getInstance().insertQuery("Insert into bigliettiAcquistati values ('"+bi.getNVolo()+"','"+Utente.getInstance().getId()+"');");    //inserimento biglietto acquistato
        int nuovaCapacita = dbConnection.getInstance().selectQuery("SELECT capacita FROM volo WHERE nVolo="+bi.getNVolo()+";").getInt("capacita") - 1; //riduzione capacità del volo
        dbConnection.getInstance().insertQuery("UPDATE volo SET capacita="+nuovaCapacita +" WHERE nVolo = "+bi.getNVolo()+";");                        //
    }

}
