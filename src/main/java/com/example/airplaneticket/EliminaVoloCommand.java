package com.example.airplaneticket;

import java.sql.SQLException;


/** classe che implementa i metodi per l'eliminazione dei voli
 */
public class EliminaVoloCommand implements ICommandVoli{
    static Volo ultimoVolo;

    /** override execute command per l'eleminazione di un volo
    * @param volo da eliminare
    */
    @Override
    public void executeCommand(Volo v) throws SQLException, ClassNotFoundException {
        dbConnection con = dbConnection.getInstance();
        ultimoVolo = v;
        con.deleteElement("DELETE FROM volo WHERE nVolo ="+v.getNVolo());
    }
    /** override undo command per l'eleminazione di un volo
    */
    @Override
    public void undoCommand() throws SQLException, ClassNotFoundException {
        dbConnection con = dbConnection.getInstance();
        con.insertQuery("INSERT INTO volo VALUES ('"+ultimoVolo.getPartenza()+"','"+ultimoVolo.getDestinazione()+"','"+ultimoVolo.getNVolo()+"','"+ultimoVolo.getDataPartenza()+"','"+ultimoVolo.getDataArrivo()+"','"+
                ultimoVolo.getCapacita()+"','"+ultimoVolo.getPrezzo()+"');");
    }
}
