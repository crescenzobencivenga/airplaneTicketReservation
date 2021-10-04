package com.example.airplaneticket;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class AcquistaController   {
    public SceneChanger sceneChanger = new SceneChanger();

    public Button btnCartaDiCredito;
    public Button btnPaypal;

    public void acquistaCartaCredito(ActionEvent actionEvent) throws IOException {
        pay(new CartaDiCreditoStrategy(),actionEvent);
    }

    public void acquistaPaypal(ActionEvent actionEvent) throws IOException {
        pay(new PaypalControllerStrategy(),actionEvent);
    }


    public void pay(IStrategiaPagamento sp, ActionEvent actionEvent) throws IOException {
        sp.paga(actionEvent);
    }
}
