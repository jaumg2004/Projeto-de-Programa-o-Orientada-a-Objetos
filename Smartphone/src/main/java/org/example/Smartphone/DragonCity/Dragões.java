package org.example.Smartphone.DragonCity;

public class Dragões {
    private int idDragoes;
    private String nome;
    private String especie;
    private int nivel;
    private int habitatIdHabitat;


    // Construtor, getters e setters
    public Dragões(int idDragoes, String nome, String especie, int nivel, int habitatIdHabitat) {
        this.idDragoes = idDragoes;
        this.nome = nome;
        this.especie = especie;
        this.nivel = nivel;
        this.habitatIdHabitat = habitatIdHabitat;
    }

    public int getIdDragoes() {
        return idDragoes;
    }

    public void setIdDragoes(int idDragoes) {
        this.idDragoes = idDragoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getHabitatIdHabitat() {
        return habitatIdHabitat;
    }

    public void setHabitatIdHabitat(int habitatIdHabitat) {
        this.habitatIdHabitat = habitatIdHabitat;
    }
}
