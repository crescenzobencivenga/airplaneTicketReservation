package com.example.airplaneticket;

import java.sql.SQLException;

/**
    @author Morlando Pasquale, Bencivenga Crescenzo
    interfaccia command
 */

public interface ICommandVoli {
    /**
        @param v volo da inserire o eliminare, a seconda del comando eseguito
    */
    void executeCommand(Volo v) throws SQLException, ClassNotFoundException;
    void undoCommand() throws SQLException, ClassNotFoundException;
}
