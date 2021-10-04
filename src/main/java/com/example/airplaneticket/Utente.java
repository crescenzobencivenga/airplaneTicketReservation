package com.example.airplaneticket;

public class Utente {
    private int id;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private Integer userType;
    private static Utente instance = null;


    public static Utente getInstance(){
        if(instance==null){
            instance=new Utente();
        }
        return instance;
    }

    public Integer getUserType() {
        return userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
