module com.example.airplaneticket {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.airplaneticket to javafx.fxml;
    exports com.example.airplaneticket;
}