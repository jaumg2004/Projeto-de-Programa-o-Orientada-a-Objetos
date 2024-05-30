package org.example.Smartphone.DragonCity;

public class Ilhas {

    private int idIlhas;
    private String nomeDaIlha;
    private int dragonCityIdDragonCity;

    public Ilhas(int idIlhas, String nomeDaIlha, int dragonCityIdDragonCity) {
        this.idIlhas = idIlhas;
        this.nomeDaIlha = nomeDaIlha;
        this.dragonCityIdDragonCity = dragonCityIdDragonCity;
    }

    // Getters and Setters
    public int getIdIlhas() {
        return idIlhas;
    }

    public void setIdIlhas(int idIlhas) {
        this.idIlhas = idIlhas;
    }

    public String getNomeDaIlha() {
        return nomeDaIlha;
    }

    public void setNomeDaIlha(String nomeDaIlha) {
        this.nomeDaIlha = nomeDaIlha;
    }

    public int getDragonCityIdDragonCity() {
        return dragonCityIdDragonCity;
    }

    public void setDragonCityIdDragonCity(int dragonCityIdDragonCity) {
        this.dragonCityIdDragonCity = dragonCityIdDragonCity;
    }

}

