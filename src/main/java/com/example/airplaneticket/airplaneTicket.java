package com.example.airplaneticket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;


public class airplaneTicket extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(airplaneTicket.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1201, 855);
        stage.setTitle("Airplane Ticket");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}