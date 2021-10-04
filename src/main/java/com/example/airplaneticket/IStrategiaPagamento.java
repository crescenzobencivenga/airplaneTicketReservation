package com.example.airplaneticket;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface IStrategiaPagamento {
    void paga(ActionEvent actionEvent) throws IOException;
}