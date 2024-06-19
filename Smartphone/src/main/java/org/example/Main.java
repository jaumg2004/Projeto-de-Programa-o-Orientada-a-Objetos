package org.example;


import org.example.DAO.DragonCityDAO;
import org.example.DAO.GoogleDAO;
import org.example.DAO.SpotifyDAO;
import org.example.DAO.TelefoneDAO;

import java.util.Scanner;

import static org.example.Smartphone.DragonCity.DragonCity.*;
import static org.example.Smartphone.Google.Google.*;
import static org.example.Smartphone.Spotify.Spotify.*;
import static org.example.Smartphone.Telefone.Telefone.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DragonCityDAO dragonCityDAO = new DragonCityDAO();
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        SpotifyDAO spotifyDAO = new SpotifyDAO();
        GoogleDAO googleDAO = new GoogleDAO();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Entrar no Spotify");
            System.out.println("2. Entrar no Telefone");
            System.out.println("3. Entrar no Google");
            System.out.println("4. Jogar Dragon City");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    while (true) {
                        System.out.println("Escolha uma opção:");
                        System.out.println("1. Inserir música");
                        System.out.println("2. Atualizar reprodução de música");
                        System.out.println("3. Excluir música");
                        System.out.println("4. Listar músicas");
                        System.out.println("5. Criar playlist");
                        System.out.println("6. Excluir playlist");
                        System.out.println("7. Listar playlists");
                        System.out.println("8. Adicionar música a uma playlist");
                        System.out.println("9. Remover música de uma playlist");
                        System.out.println("10. Sair");

                        int opcaoSpotify = scanner.nextInt();

                        switch (opcaoSpotify) {
                            case 1:
                                inserirMusica(scanner, spotifyDAO);
                                break;
                            case 2:
                                atualizarReproducaoMusica(scanner, spotifyDAO);
                                break;
                            case 3:
                                excluirMusica(scanner, spotifyDAO);
                                break;
                            case 4:
                                listarMusicas(spotifyDAO);
                                break;
                            case 5:
                                criarPlaylist(scanner, spotifyDAO);
                                break;
                            case 6:
                                excluirPlaylist(scanner, spotifyDAO);
                                break;
                            case 7:
                                listarPlaylists(spotifyDAO);
                                break;
                            case 8:
                                adicionarMusicaPlaylist(scanner, spotifyDAO);
                                break;
                            case 9:
                                removerMusicaPlaylist(scanner, spotifyDAO);
                                break;
                            case 10:
                                System.out.println("Voltando para o menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida. Por favor, escolha novamente.");
                        }

                        if (opcaoSpotify == 10) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("Escolha uma opção:");
                        System.out.println("1. Ligar");
                        System.out.println("2. Atualizar chamada");
                        System.out.println("3. Excluir ligação");
                        System.out.println("4. Criar novo contato");
                        System.out.println("5. Atualizar contato");
                        System.out.println("6. Excluir contato");
                        System.out.println("7. Listar contatos");
                        System.out.println("8. Incluir contato na chamada");
                        System.out.println("9. Excluir contato da chamada");
                        System.out.println("10. Listar associações pessoa-chamada");
                        System.out.println("11. Sair");

                        int opcaoTelefone = scanner.nextInt();

                        switch (opcaoTelefone) {
                            case 1:
                                inserirChamada(telefoneDAO);
                                break;
                            case 2:
                                atualizarChamada(scanner, telefoneDAO);
                                break;
                            case 3:
                                excluirChamada(scanner, telefoneDAO);
                                break;
                            case 4:
                                inserirPessoa(scanner, telefoneDAO);
                                break;
                            case 5:
                                atualizarPessoa(scanner, telefoneDAO);
                                break;
                            case 6:
                                excluirPessoa(scanner, telefoneDAO);
                                break;
                            case 7:
                                listarPessoas(telefoneDAO);
                                break;
                            case 8:
                                incluirPessoaChamada(scanner, telefoneDAO);
                                break;
                            case 9:
                                excluirPessoaChamada(scanner, telefoneDAO);
                                break;
                            case 10:
                                listarAssociacoesPessoaChamada(telefoneDAO);
                                break;
                            case 11:
                                System.out.println("Voltando para o menu principal...");
                                return;
                            default:
                                System.out.println("Opção inválida. Por favor, escolha novamente.");
                        }
                    }
                case 3:
                    while (true) {
                        System.out.println("Escolha uma opção:");
                        System.out.println("1. Pesquisar");
                        System.out.println("2. Atualizar histórico");
                        System.out.println("3. Excluir pesquisa");
                        System.out.println("4. Listar históricos");
                        System.out.println("5. Sair");

                        int opcaoGoogle = scanner.nextInt();

                        switch (opcaoGoogle) {
                            case 1:
                                inserirHistorico(scanner, googleDAO);
                                break;
                            case 2:
                                atualizarHistorico(scanner, googleDAO);
                                break;
                            case 3:
                                excluirHistorico(scanner, googleDAO);
                                break;
                            case 4:
                                listarHistorico(googleDAO);
                                break;
                            case 5:
                                System.out.println("Voltando para o menu principal...");
                                return;
                            default:
                                System.out.println("Opção inválida. Por favor, escolha novamente.");
                        }
                    }
                case 4:
                    while (true) {
                        System.out.println("Escolha uma opção:");
                        System.out.println("1. Criar uma nova conta");
                        System.out.println("2. Mudar nome e senha da conta");
                        System.out.println("3. Deletar conta");
                        System.out.println("4. Listar todas as contas");
                        System.out.println("5. Comprar uma nova ilha");
                        System.out.println("6. Vender uma ilha");
                        System.out.println("7. Listar todas as ilhas");
                        System.out.println("8. Criar novo habitat");
                        System.out.println("9. Adicionar um dragão ao habitat");
                        System.out.println("10. Destruir habitat");
                        System.out.println("11. Listar todos os habitats");
                        System.out.println("12. Mudar o nome de um dragão");
                        System.out.println("13. Sacrificar dragão");
                        System.out.println("14. Catalogar um tipo");
                        System.out.println("15. Listar todos os tipos");
                        System.out.println("16. Associar tipo a um dragão");
                        System.out.println("17. Desassociar tipo de um dragão");
                        System.out.println("18. Listar todas as associações de tipos e dragões");
                        System.out.println("19. Sair do jogo");

                        int opcaoDragonCity = scanner.nextInt();

                        switch (opcaoDragonCity) {
                            case 1:
                                criarNovaConta(scanner, dragonCityDAO);
                                break;
                            case 2:
                                mudarNomeSenhaConta(scanner, dragonCityDAO);
                                break;
                            case 3:
                                deletarConta(scanner, dragonCityDAO);
                                break;
                            case 4:
                                listarContas(dragonCityDAO);
                                break;
                            case 5:
                                comprarNovaIlha(scanner, dragonCityDAO);
                                break;
                            case 6:
                                venderIlha(scanner, dragonCityDAO);
                                break;
                            case 7:
                                listarIlhas(dragonCityDAO);
                                break;
                            case 8:
                                criarNovoHabitat(scanner, dragonCityDAO);
                                break;
                            case 9:
                                adicionarDragaoHabitat(scanner, dragonCityDAO);
                                break;
                            case 10:
                                destruirHabitat(scanner, dragonCityDAO);
                                break;
                            case 11:
                                listarHabitats(dragonCityDAO);
                                break;
                            case 12:
                                mudarNomeDragao(scanner, dragonCityDAO);
                                break;
                            case 13:
                                sacrificarDragao(scanner, dragonCityDAO);
                                break;
                            case 14:
                                catalogarTipo(scanner, dragonCityDAO);
                                break;
                            case 15:
                                listarTipos(dragonCityDAO);
                                break;
                            case 16:
                                associarTipoDragao(scanner, dragonCityDAO);
                                break;
                            case 17:
                                desassociarTipoDragao(scanner, dragonCityDAO);
                                break;
                            case 18:
                                listarAssociacoesTipoDragao(dragonCityDAO);
                                break;
                            case 19:
                                System.out.println("Saindo do jogo Dragon City...");
                                return;
                            default:
                                System.out.println("Opção inválida. Por favor, escolha novamente.");
                        }
                    }
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
}