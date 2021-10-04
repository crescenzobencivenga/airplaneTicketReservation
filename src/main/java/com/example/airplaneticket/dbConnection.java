package com.example.airplaneticket;

import java.sql.*;

public class dbConnection { //receiver

    private dbConnection() throws SQLException, ClassNotFoundException {
        conn = DriverManager.getConnection(DATABASE_URL);
        Class.forName(JDBC_DRIVER);
    }
    public static dbConnection getInstance() throws SQLException, ClassNotFoundException {
        if(dbInstance==null)
            dbInstance = new dbConnection();
        return dbInstance;
    }

    public void insertQuery(String qu) throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate(qu);
    }
    public ResultSet selectQuery(String qu) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(qu);
        return result;
    }
    public void deleteElement(String qu) throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate(qu);
    }

    private final Connection conn;
    private static dbConnection dbInstance = null;
    private static final String JDBC_DRIVER="org.sqlite.JDBC";
    private static final String DATABASE_URL="jdbc:sqlite:airplane.sqlite";

}
