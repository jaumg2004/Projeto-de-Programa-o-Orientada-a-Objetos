package org.example.DAO;

import org.example.Smartphone.Spotify.Musica;
import org.example.Smartphone.Spotify.Playlist;

import java.sql.*;
import java.util.ArrayList;

public class SpotifyDAO extends ConnectionDAO {

    // INSERT
    public boolean insertMusica(Musica musica) {
        connectToDB();
        boolean sucesso;
        String sql = "INSERT INTO Música (Nome, Artista, Tempo, Reprodução) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, musica.getNome());
            pst.setString(2, musica.getArtista());
            pst.setDouble(3, musica.getTempo());
            pst.setInt(4, musica.getReproducao());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }


    // UPDATE
    public boolean updateMusica(String nome, Integer novaReproducao) {
        connectToDB();
        String sql = "UPDATE Música SET Reprodução=? WHERE Nome=?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, novaReproducao);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        return sucesso;
    }

    // DELETE
    public boolean deleteMusica(String nome) {
        connectToDB();
        String sql = "DELETE FROM Música WHERE Nome=?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        return sucesso;
    }

    // SELECT
    public ArrayList<Musica> selectMusica() {
        ArrayList<Musica> musicas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Música";
        boolean sucesso;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Musica musica = new Musica(
                        rs.getString("Nome"),
                        rs.getString("Artista"),
                        rs.getInt("Tempo"),
                        rs.getInt("Reprodução")
                );
                musicas.add(musica);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return musicas;
    }

    // INSERT na tabela Playlist
    public boolean insertPlaylist(Playlist playlist) {
        connectToDB();
        String sql = "INSERT INTO Playlist (Titulo, QuantMúsica) values(?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, playlist.getTitulo());
            pst.setInt(2, playlist.getQuantMusica());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }


    // UPDATE na tabela Playlist
    public boolean updatePlaylist(String titulo, Integer novaQuantMusica) {
        connectToDB();
        String sql = "UPDATE Playlist SET QuantMúsica=? WHERE Titulo=?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, novaQuantMusica);
            pst.setString(2, titulo);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    // DELETE na tabela Playlist
    public boolean deletePlaylist(String titulo) {
        connectToDB();
        String sql = "DELETE FROM Playlist WHERE Titulo=?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, titulo);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    // SELECT na tabela Playlist
    public ArrayList<Playlist> selectPlaylist() {
        ArrayList<Playlist> playlists = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Playlist";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String titulo = rs.getString("Titulo");
                int quantidadeMusica = rs.getInt("QuantMúsica");
                Playlist playlist = new Playlist(titulo, quantidadeMusica);
                playlists.add(playlist);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            closeConnections();
        }
        return playlists;
    }

    public boolean insertMusicaPlaylist(String musicaNome, String playlistTitulo) {
        connectToDB();
        String sql = "INSERT INTO Música_has_Playlist (Música_Nome, Playlist_Titulo) VALUES (?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, musicaNome);
            pst.setString(2, playlistTitulo);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        return sucesso;
    }

    // DELETE RELATIONSHIP
    public boolean deleteMusicaPlaylist(String musicaNome, String playlistTitulo) {
        connectToDB();
        String sql = "DELETE FROM Música_has_Playlist WHERE Música_Nome=? AND Playlist_Titulo=?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, musicaNome);
            pst.setString(2, playlistTitulo);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        return sucesso;
    }

}