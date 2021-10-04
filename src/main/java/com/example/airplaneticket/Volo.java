package com.example.airplaneticket;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Date;

/**
    Contiene le informazioni inerenti al volo
*/

public class Volo {
    private String destinazione;
    private String partenza;
    private int nVolo;
    private String dataPartenza;
    private String dataArrivo;
    private int capacita;
    private double prezzo;

    public String getDestinazione() {
        return destinazione;
    }

    public String getPartenza() {
        return partenza;
    }

    public int getNVolo() {
        return nVolo;
    }


    public String  getDataPartenza() {
        return dataPartenza;
    }


    public String getDataArrivo() {
        return dataArrivo;
    }

    public int getCapacita() {
        return capacita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Volo(String destinazione, String partenza, int numeroVolo, String dataPartenza, String dataArrivo, int capacita, double prezzo) {
        this.destinazione = destinazione;
        this.partenza = partenza;
        this.nVolo = numeroVolo;
        this.dataPartenza = dataPartenza;
        this.dataArrivo = dataArrivo;
        this.capacita = capacita;
        this.prezzo = prezzo;
    }

    public void setnVolo(int nVolo) {
        this.nVolo = nVolo;
    }
}
