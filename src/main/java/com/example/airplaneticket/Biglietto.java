package com.example.airplaneticket;

public class Biglietto {
    private static Biglietto instance = null;

    private String partenza;
    private String destinazine;
    private String dataArrivo;
    private String dataPartenza;
    private Double prezzo;
    private int nVolo;

    public static Biglietto getInstance(){
        if(instance==null){
            instance=new Biglietto();
        }
        return instance;
    }
    public String getPartenza() {
        return partenza;
    }

    public String getDestinazine() {
        return destinazine;
    }

    public String getDataArrivo() {
        return dataArrivo;
    }

    public String getDataPartenza() {
        return dataPartenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public void setDestinazine(String destinazine) {
        this.destinazine = destinazine;
    }

    public void setDataArrivo(String dataArrivo) {
        this.dataArrivo = dataArrivo;
    }

    public void setDataPartenza(String dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

    public void setnVolo(int nVolo) {
        this.nVolo = nVolo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public int getNVolo() {
        return nVolo;
    }
}
