package com.example.airplaneticket;

import java.sql.SQLException;

public class EliminaVoloCommand implements ICommandVoli{
    static Volo ultimoVolo;


    @Override
    public void executeCommand(Volo v) throws SQLException, ClassNotFoundException {
        dbConnection con = dbConnection.getInstance();
        ultimoVolo = v;
        con.deleteElement("DELETE FROM volo WHERE nVolo ="+v.getNVolo());
    }

    @Override
    public void undoCommand() throws SQLException, ClassNotFoundException {
        dbConnection con = dbConnection.getInstance();
        con.insertQuery("INSERT INTO volo VALUES ('"+ultimoVolo.getPartenza()+"','"+ultimoVolo.getDestinazione()+"','"+ultimoVolo.getNVolo()+"','"+ultimoVolo.getDataPartenza()+"','"+ultimoVolo.getDataArrivo()+"','"+
                ultimoVolo.getCapacita()+"','"+ultimoVolo.getPrezzo()+"');");
    }
}
