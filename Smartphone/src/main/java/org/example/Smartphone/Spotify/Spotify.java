package org.example.Smartphone.Spotify;

import org.example.DAO.SpotifyDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class Spotify {
    private static void inserirMusica(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o nome da música:");
        String nomeMusica = scanner.next();
        System.out.println("Insira o nome do artista:");
        String artista = scanner.next();
        System.out.println("Insira a duração da música em minutos:");
        double duracao = scanner.nextDouble();
        System.out.println("Insira o número de reproduções:");
        int reproducao = scanner.nextInt();
        Musica musica = new Musica(nomeMusica, artista, duracao, reproducao);
        boolean inserirSucesso = spotifyDAO.insertMusica(musica);
        if (inserirSucesso) {
            System.out.println("Música inserida com sucesso.");
        } else {
            System.out.println("Falha ao inserir música.");
        }
    }

    private static void atualizarReproducaoMusica(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o nome da música que deseja atualizar:");
        String nomeMusicaAtualizar = scanner.next();
        System.out.println("Insira o novo número de reproduções:");
        int novaReproducao = scanner.nextInt();
        boolean atualizarSucesso = spotifyDAO.updateMusica(nomeMusicaAtualizar, novaReproducao);
        if (atualizarSucesso) {
            System.out.println("Reprodução da música atualizada com sucesso.");
        } else {
            System.out.println("Falha ao atualizar reprodução da música.");
        }
    }

    private static void excluirMusica(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o nome da música que deseja excluir:");
        String nomeMusicaExcluir = scanner.next();
        boolean excluirSucesso = spotifyDAO.deleteMusica(nomeMusicaExcluir);
        if (excluirSucesso) {
            System.out.println("Música excluída com sucesso.");
        } else {
            System.out.println("Falha ao excluir música.");
        }
    }

    private static void listarMusicas(SpotifyDAO spotifyDAO) {
        ArrayList<Musica> musicas = spotifyDAO.selectMusica();
        System.out.println("Lista de músicas:");
        for (Musica m : musicas) {
            System.out.println("Nome: " + m.getNome() + ", Artista: " + m.getArtista() + ", Duração: " + m.getTempo() + ", Reprodução: " + m.getReproducao());
        }
    }

    private static void criarPlaylist(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o título da playlist:");
        String tituloPlaylist = scanner.next();
        System.out.println("Insira a quantidade de músicas na playlist:");
        int quantMusicaPlaylist = scanner.nextInt();
        Playlist playlist = new Playlist(tituloPlaylist, quantMusicaPlaylist);
        boolean criarPlaylistSucesso = spotifyDAO.insertPlaylist(playlist);
        if (criarPlaylistSucesso) {
            System.out.println("Playlist criada com sucesso.");
        } else {
            System.out.println("Falha ao criar playlist.");
        }
    }

    private static void excluirPlaylist(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o título da playlist que deseja excluir:");
        String tituloPlaylistExcluir = scanner.next();
        boolean excluirPlaylistSucesso = spotifyDAO.deletePlaylist(tituloPlaylistExcluir);
        if (excluirPlaylistSucesso) {
            System.out.println("Playlist excluída com sucesso.");
        } else {
            System.out.println("Falha ao excluir playlist.");
        }
    }

    private static void listarPlaylists(SpotifyDAO spotifyDAO) {
        ArrayList<Playlist> playlists = spotifyDAO.selectPlaylist();
        System.out.println("Lista de playlists:");
        for (Playlist p : playlists) {
            System.out.println("Título: " + p.getTitulo() + ", Quantidade de músicas: " + p.getQuantMusica());
        }
    }

    private static void adicionarMusicaPlaylist(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o nome da música:");
        String nomeMusicaPlaylist = scanner.next();
        System.out.println("Insira o título da playlist:");
        String tituloPlaylistAdicionar = scanner.next();
        boolean adicionarSucesso = spotifyDAO.insertMusicaPlaylist(nomeMusicaPlaylist, tituloPlaylistAdicionar);
        if (adicionarSucesso) {
            System.out.println("Música adicionada à playlist com sucesso.");
        } else {
            System.out.println("Falha ao adicionar música à playlist.");
        }
    }

    private static void removerMusicaPlaylist(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o nome da música:");
        String nomeMusicaRemover = scanner.next();
        System.out.println("Insira o título da playlist:");
        String tituloPlaylistRemover = scanner.next();
        boolean removerSucesso = spotifyDAO.deleteMusicaPlaylist(nomeMusicaRemover, tituloPlaylistRemover);
        if (removerSucesso) {
            System.out.println("Música removida da playlist com sucesso.");
        } else {
            System.out.println("Falha ao remover música da playlist.");
        }
    }

}
