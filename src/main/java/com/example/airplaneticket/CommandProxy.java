package com.example.airplaneticket;

import java.sql.SQLException;

/** 
*    @author Morlando Pasquale, Bencivenga Crescenzo
*   classe che implementa il proxy per il logging dei comandi eseguiti dall'amministratore
*/

public class CommandProxy implements ICommandVoli {
    private ICommandVoli commandVoli;
    
    
    public CommandProxy(ICommandVoli command){
        commandVoli = command;
    }
    
    /** override del metodo executeCommand che esegue l'executeCommand della classe definita 
    * attraverso il costruttore e chiama il metodo logging
    * @param volo da inserire o eliminare
    */
    @Override
    public void executeCommand(Volo v) throws SQLException, ClassNotFoundException {
        commandVoli.executeCommand(v);
        addLog(commandVoli.getClass().toString(),"do", v);
    }
    
    
    /** override undo command
    */
    @Override
    public void undoCommand() throws SQLException, ClassNotFoundException {
        commandVoli.undoCommand();
        addLog(commandVoli.getClass().toString(),"undo", null);
    }

    /** metodo per il logging delle operazioni eseguite
    *   @param classe di appartenenza del command eseguito, il comando eseguito, volo sul quale è eseguito il comando
    */
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
