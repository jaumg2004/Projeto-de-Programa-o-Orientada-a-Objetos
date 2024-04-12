package org.example.Smartphone.DragonCity;

public class Habitat {
    private int idHabitat;
    private int quantDragoes;
    private int ilhasIdIlhas;
    private int tipoIdTipo;

    public Habitat(int idHabitat, int quantDragoes, int ilhasIdIlhas, int tipoIdTipo) {
        this.idHabitat = idHabitat;
        this.quantDragoes = quantDragoes;
        this.ilhasIdIlhas = ilhasIdIlhas;
        this.tipoIdTipo = tipoIdTipo;
    }

    public int getIdHabitat() {
        return idHabitat;
    }

    public void setIdHabitat(int idHabitat) {
        this.idHabitat = idHabitat;
    }

    public int getQuantDragoes() {
        return quantDragoes;
    }

    public void setQuantDragoes(int quantDragoes) {
        this.quantDragoes = quantDragoes;
    }

    public int getIlhasIdIlhas() {
        return ilhasIdIlhas;
    }

    public void setIlhasIdIlhas(int ilhasIdIlhas) {
        this.ilhasIdIlhas = ilhasIdIlhas;
    }

    public int getTipoIdTipo() {
        return tipoIdTipo;
    }

    public void setTipoIdTipo(int tipoIdTipo) {
        this.tipoIdTipo = tipoIdTipo;
    }
}

