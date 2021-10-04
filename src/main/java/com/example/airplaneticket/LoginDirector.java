package com.example.airplaneticket;

import javafx.event.ActionEvent;

import java.io.IOException;

/**
    @author Morlando Pasquale, Bencivenga Crescenzo
    Fornisce un punto di accesso per la creazione delle due interfacce utente
*/

public class LoginDirector {
    ILoginBuilder loginBuilder;

    /** setter per loginBuilder
    */
    public void setLoginBuilder(ILoginBuilder loginBuilder){
        this.loginBuilder = loginBuilder;
    }
    public void creaInterfaccia(ActionEvent event) throws IOException {
        loginBuilder.buildInterface(event);
    }
}
