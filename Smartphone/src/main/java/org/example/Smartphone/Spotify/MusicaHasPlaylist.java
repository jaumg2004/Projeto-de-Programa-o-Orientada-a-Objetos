package org.example.Smartphone.Spotify;

public class MusicaHasPlaylist {

    private String musicaNome;
    private String playlistTitulo;

    public MusicaHasPlaylist(String musicaNome, String playlistTitulo) {
        this.musicaNome = musicaNome;
        this.playlistTitulo = playlistTitulo;
    }

    public String getMusicaNome() {
        return musicaNome;
    }

    public void setMusicaNome(String musicaNome) {
        this.musicaNome = musicaNome;
    }

    public String getPlaylistTitulo() {
        return playlistTitulo;
    }

    public void setPlaylistTitulo(String playlistTitulo) {
        this.playlistTitulo = playlistTitulo;
    }

}
