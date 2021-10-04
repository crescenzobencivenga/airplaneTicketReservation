package com.example.airplaneticket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Controller Class dell'interfaccia utente di login
 *  costruisce l'interfaccia in base al tipo di utente che effettua il login
 * */


public class loginController {
    public Text textCredErrate;
    LoginDirector loginDirector = new LoginDirector();
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    /*Metodo collegato al login button che controlla se l'utente esiste all'interno del database e costruisce
        attraverso il login director l'interfaccia giusta
    * */
    public void loginButtonAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        dbConnection db = dbConnection.getInstance();
        ResultSet rs = db.selectQuery("SELECT * from user where username = '" + usernameField.getText() + "' AND password ='" +
                passwordField.getText() + "';");
        if (rs.next()) {
            Utente utente = Utente.getInstance();
            utente.setId(rs.getInt("user_id"));
            utente.setCognome(rs.getString("cognome"));
            utente.setNome(rs.getString("nome"));
            utente.setUsername(rs.getString("username"));
            utente.setPassword(rs.getString("password"));
            utente.setUserType(rs.getInt("userType"));
            if (utente.getUserType() == 1){
                loginDirector.setLoginBuilder(new AdminLoginBuilder());
                loginDirector.creaInterfaccia(event);
            }else{
                loginDirector.setLoginBuilder(new UserLoginBuilder());
                loginDirector.creaInterfaccia(event);
            }
        } else {
            textCredErrate.setText("Credenziali non valide");
        }

    }
}