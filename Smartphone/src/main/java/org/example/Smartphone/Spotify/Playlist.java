package org.example.Smartphone.Spotify;

public class Playlist {
    private String titulo;
    private int quantMusica;

    public Playlist(String titulo, int quantMusica) {
        this.titulo = titulo;
        this.quantMusica = quantMusica;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantMusica() {
        return quantMusica;
    }

    public void setQuantMusica(int quantMusica) {
        this.quantMusica = quantMusica;
    }
}
