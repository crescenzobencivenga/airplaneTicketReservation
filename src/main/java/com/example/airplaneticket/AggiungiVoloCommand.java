package com.example.airplaneticket;

import java.sql.SQLException;

/* Classe richiamata all'esecuzione di comandi da parte dell'amministratore
*/

public class AggiungiVoloCommand implements ICommandVoli{
    static Volo nuovoVolo;

    
    
    /** override execute comand per aggiunta di un volo
    *   @param volo da inserire
    */
    @Override
    public void executeCommand(Volo v) throws SQLException, ClassNotFoundException {
        dbConnection con = dbConnection.getInstance();
        nuovoVolo = v;
        
        con.insertQuery("INSERT INTO volo VALUES ('"+v.getPartenza()+"','"+v.getDestinazione()+"',null,'"+v.getDataPartenza()+"','"+v.getDataArrivo()+"','"+
                v.getCapacita()+"','"+v.getPrezzo()+"');");
        nuovoVolo.setnVolo((con.selectQuery("SELECT MAX(nVolo) AS max from VOLO;")).getInt("max"));

    }
    
    /** override undo command per l'aggiunta di un volo
    */
    @Override
    public void undoCommand() throws SQLException, ClassNotFoundException {
        dbConnection con = dbConnection.getInstance();
        con.deleteElement("DELETE FROM volo WHERE nVolo ="+nuovoVolo.getNVolo());
    }
}
