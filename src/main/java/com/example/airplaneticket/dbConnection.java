package com.example.airplaneticket;

import java.sql.*;

/**
        Classe Singleton per la connessione al database
    */

public class dbConnection { //receiver
    
    
    //Metodo per la connessione al databse
    private dbConnection() throws SQLException, ClassNotFoundException {
        conn = DriverManager.getConnection(DATABASE_URL);
        Class.forName(JDBC_DRIVER);
    }
    
    /**
    Restituisce l'istanza del database se è già istanziato,
    altrimenti la istanzia e apre una connesione al database
    */
    public static dbConnection getInstance() throws SQLException, ClassNotFoundException {
        if(dbInstance==null)
            dbInstance = new dbConnection();
        return dbInstance;
    }
    //Metodo per query di tipo inserimento dei dati nel database
    public void insertQuery(String qu) throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate(qu);
    }
    //Metodo per query di tipo selezione all'interno del database
    public ResultSet selectQuery(String qu) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(qu);
        return result;
    }
    //Metodo per query di tipo eliminazione all'interno del database
    public void deleteElement(String qu) throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate(qu);
    }

    private final Connection conn;
    private static dbConnection dbInstance = null;
    private static final String JDBC_DRIVER="org.sqlite.JDBC";
    private static final String DATABASE_URL="jdbc:sqlite:airplane.sqlite";

}
