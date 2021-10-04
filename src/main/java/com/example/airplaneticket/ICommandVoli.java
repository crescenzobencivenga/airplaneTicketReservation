package com.example.airplaneticket;

import java.sql.SQLException;

/*  interfaccia command
* */

public interface ICommandVoli {
    void executeCommand(Volo v) throws SQLException, ClassNotFoundException;
    void undoCommand() throws SQLException, ClassNotFoundException;
}
