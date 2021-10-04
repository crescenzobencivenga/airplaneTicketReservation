package com.example.airplaneticket;

import java.sql.SQLException;

public class AggiungiVoloCommand implements ICommandVoli{
    static Volo nuovoVolo;

    @Override
    public void executeCommand(Volo v) throws SQLException, ClassNotFoundException {
        dbConnection con = dbConnection.getInstance();
        nuovoVolo = v;
        System.out.println(v.getDataArrivo()+"   "+v.getDataPartenza());
        con.insertQuery("INSERT INTO volo VALUES ('"+v.getPartenza()+"','"+v.getDestinazione()+"',null,'"+v.getDataPartenza()+"','"+v.getDataArrivo()+"','"+
                v.getCapacita()+"','"+v.getPrezzo()+"');");
        nuovoVolo.setnVolo((con.selectQuery("SELECT MAX(nVolo) AS max from VOLO;")).getInt("max"));

    }

    @Override
    public void undoCommand() throws SQLException, ClassNotFoundException {
        dbConnection con = dbConnection.getInstance();
        System.out.println("elimino volo " + nuovoVolo.getNVolo());
        con.deleteElement("DELETE FROM volo WHERE nVolo ="+nuovoVolo.getNVolo());
    }
}
