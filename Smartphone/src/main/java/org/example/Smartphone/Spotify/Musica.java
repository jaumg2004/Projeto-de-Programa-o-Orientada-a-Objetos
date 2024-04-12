package org.example.Smartphone.Spotify;

public class Musica {
    private String nome;
    private String artista;
    private double tempo;
    private int reproducao;

    public Musica(String nome, String artista, double tempo, int reproducao) {
        this.nome = nome;
        this.artista = artista;
        this.tempo = tempo;
        this.reproducao = reproducao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public int getReproducao() {
        return reproducao;
    }

    public void setReproducao(int reproducao) {
        this.reproducao = reproducao;
    }
}
