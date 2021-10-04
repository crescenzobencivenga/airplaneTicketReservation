package com.example.airplaneticket;

import java.sql.SQLException;

public class CommandProxy implements ICommandVoli {
    private ICommandVoli commandVoli;
    public CommandProxy(ICommandVoli command){
        commandVoli = command;
    }

    @Override
    public void executeCommand(Volo v) throws SQLException, ClassNotFoundException {
        commandVoli.executeCommand(v);
        addLog(commandVoli.getClass().toString(),"do", v);
    }

    @Override
    public void undoCommand() throws SQLException, ClassNotFoundException {
        commandVoli.undoCommand();
        addLog(commandVoli.getClass().toString(),"undo", null);
    }

    public void addLog(String classe, String comando,Volo v){
        Utente u = Utente.getInstance();
        String log = u.getUsername();
        if (classe.equals(AggiungiVoloCommand.class.toString())){
            if (comando.equals("do")){
                log=log.concat(" ha aggiunto il volo "+ v.getNVolo());
            }else {
                log=log.concat(" ha eseguito l'undo dell'ultimo comando");
            }
        }else {
            if (comando.equals("do")){
                log=log.concat(" ha eliminato il volo "+ v.getNVolo());
            }else {
                log=log.concat(" ha eseguito l'undo dell'ultimo comando");
            }
        }
        System.out.println(log);
    }
}
