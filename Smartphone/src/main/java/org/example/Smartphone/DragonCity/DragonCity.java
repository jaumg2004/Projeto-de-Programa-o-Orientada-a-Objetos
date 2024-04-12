package org.example.Smartphone.DragonCity;

public class DragonCity {

    private int idDragonCity;
    private String username;
    private String senha;

    public DragonCity(int idDragonCity, String username, String senha) {
        this.idDragonCity = idDragonCity;
        this.username = username;
        this.senha = senha;
    }

    public int getIdDragonCity() {
        return idDragonCity;
    }

    public void setIdDragonCity(int idDragonCity) {
        this.idDragonCity = idDragonCity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
