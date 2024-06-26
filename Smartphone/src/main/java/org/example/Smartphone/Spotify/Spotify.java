package org.example.Smartphone.Spotify;

import org.example.DAO.SpotifyDAO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Spotify {
    public static void inserirMusica(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o nome da música:");
        String nomeMusica = scanner.next();

        System.out.println("Insira o nome do artista:");
        scanner.next(); // Limpar o buffer
        String artista = scanner.next();

        double duracao = 0.0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("Insira a duração da música em minutos (0.01 a 999.99):");
                duracao = scanner.nextDouble();
                if (duracao <= 0 || duracao > 999.99) {
                    throw new InputMismatchException("Duração fora do intervalo permitido.");
                }
                entradaValida = true; // A entrada é válida, sair do loop
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido dentro do intervalo permitido.");
                scanner.next(); // Limpar a entrada inválida do scanner
            }
        }

        int reproducao = 0;
        entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("Insira o número de reproduções:");
                reproducao = scanner.nextInt();
                entradaValida = true; // A entrada é válida, sair do loop
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro válido.");
                scanner.next(); // Limpar a entrada inválida do scanner
            }
        }

        Musica musica = new Musica(nomeMusica, artista, duracao, reproducao);
        boolean inserirSucesso = spotifyDAO.insertMusica(musica);
        if (inserirSucesso) {
            System.out.println("Música inserida com sucesso.");
        } else {
            System.out.println("Falha ao inserir música.");
        }
    }

    public static void atualizarReproducaoMusica(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o nome da música que deseja atualizar:");
        String nomeMusicaAtualizar = scanner.next();
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.println("Insira o novo número de reproduções:");
        int novaReproducao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner
        boolean atualizarSucesso = spotifyDAO.updateMusica(nomeMusicaAtualizar, novaReproducao);
        if (atualizarSucesso) {
            System.out.println("Reprodução da música atualizada com sucesso.");
        } else {
            System.out.println("Falha ao atualizar reprodução da música.");
        }
    }


    public static void excluirMusica(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o nome da música que deseja excluir:");
        String nomeMusicaExcluir = scanner.next();
        boolean excluirSucesso = spotifyDAO.deleteMusica(nomeMusicaExcluir);
        if (excluirSucesso) {
            System.out.println("Música excluída com sucesso.");
        } else {
            System.out.println("Falha ao excluir música.");
        }
    }

    public static void listarMusicas(SpotifyDAO spotifyDAO) {
        ArrayList<Musica> musicas = spotifyDAO.selectMusica();
        System.out.println("Lista de músicas:");
        for (Musica m : musicas) {
            System.out.println("Nome: " + m.getNome() + ", Artista: " + m.getArtista() + ", Duração: " + m.getTempo() + ", Reprodução: " + m.getReproducao());
        }
    }

    public static void criarPlaylist(Scanner scanner, SpotifyDAO spotifyDAO) {
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

    public static void excluirPlaylist(Scanner scanner, SpotifyDAO spotifyDAO) {
        System.out.println("Insira o título da playlist que deseja excluir:");
        String tituloPlaylistExcluir = scanner.next();
        boolean excluirPlaylistSucesso = spotifyDAO.deletePlaylist(tituloPlaylistExcluir);
        if (excluirPlaylistSucesso) {
            System.out.println("Playlist excluída com sucesso.");
        } else {
            System.out.println("Falha ao excluir playlist.");
        }
    }

    public static void listarPlaylists(SpotifyDAO spotifyDAO) {
        ArrayList<Playlist> playlists = spotifyDAO.selectPlaylist();
        System.out.println("Lista de playlists:");
        for (Playlist p : playlists) {
            System.out.println("Título: " + p.getTitulo() + ", Quantidade de músicas: " + p.getQuantMusica());
        }
    }

    public static void adicionarMusicaPlaylist(Scanner scanner, SpotifyDAO spotifyDAO) {
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

    public static void removerMusicaPlaylist(Scanner scanner, SpotifyDAO spotifyDAO) {
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
