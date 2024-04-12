package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;

public class SpotifyDAO extends ConnectionDAO {

    // INSERT
    public boolean insertMusica(String nome, String artista, double tempo, int reproducao) {
        connectToDB();
        String sql = "INSERT INTO Música (Nome, Artista, Tempo, Reprodução) values(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, artista);
            pst.setDouble(3, tempo);
            pst.setInt(4, reproducao);
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

    // UPDATE
    public boolean updateMusica(String nome, Integer novaReproducao) {
        connectToDB();
        String sql = "UPDATE Música SET Reprodução=? WHERE Nome=?";
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
    public ArrayList<String[]> selectMusica() {
        ArrayList<String[]> musicas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Música";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] musica = new String[4];
                musica[0] = rs.getString("Nome");
                musica[1] = rs.getString("Artista");
                musica[2] = String.valueOf(rs.getDouble("Tempo"));
                musica[3] = String.valueOf(rs.getInt("Reprodução"));
                musicas.add(musica);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        return musicas;
    }

    // INSERT na tabela Playlist
    public boolean insertPlaylist(String titulo, int quantMusica) {
        connectToDB();
        String sql = "INSERT INTO Playlist (Titulo, QuantMúsica) values(?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, titulo);
            pst.setInt(2, quantMusica);
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
    public ArrayList<String[]> selectPlaylist() {
        ArrayList<String[]> playlists = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Playlist";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] playlist = new String[2];
                playlist[0] = rs.getString("Titulo");
                playlist[1] = String.valueOf(rs.getInt("QuantMúsica"));
                playlists.add(playlist);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return playlists;
    }

    public boolean insertMusicaPlaylist(String musicaNome, String playlistTitulo) {
        connectToDB();
        String sql = "INSERT INTO Música_has_Playlist (Música_Nome, Playlist_Titulo) VALUES (?, ?)";
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
