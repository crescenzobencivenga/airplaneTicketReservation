package com.example.airplaneticket;

import javafx.event.ActionEvent;

import java.io.IOException;

/**
    @author Morlando Pasquale, Bencivenga Crescenzo
    Interfaccia che definisce il metodo per il pagamento
*/
public interface IStrategiaPagamento {
    void paga(ActionEvent actionEvent) throws IOException;
}
