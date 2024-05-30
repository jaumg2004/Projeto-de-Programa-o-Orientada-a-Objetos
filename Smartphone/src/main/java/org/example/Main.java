package org.example;

import org.example.DAO.DragonCityDAO;
import org.example.DAO.GoogleDAO;
import org.example.DAO.SpotifyDAO;
import org.example.DAO.TelefoneDAO;
import org.example.Smartphone.Google.Historico;
import org.example.Smartphone.Spotify.Musica;
import org.example.Smartphone.Spotify.Playlist;
import org.example.Smartphone.Telefone.Chamada;
import org.example.Smartphone.Telefone.Pessoa;
import org.example.Smartphone.Telefone.PessoaHasChamada;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpotifyDAO spotifyDAO = new SpotifyDAO();
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        GoogleDAO googleDAO = new GoogleDAO();
        DragonCityDAO dragonCityDAO = new DragonCityDAO();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Interagir com Spotify");
            System.out.println("2. Interagir com Telefone");
            System.out.println("3. Interagir com Google");
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
                        System.out.println("1. Inserir chamada");
                        System.out.println("2. Atualizar chamada");
                        System.out.println("3. Excluir chamada");
                        System.out.println("4. Inserir pessoa");
                        System.out.println("5. Atualizar pessoa");
                        System.out.println("6. Excluir pessoa");
                        System.out.println("7. Listar pessoas");
                        System.out.println("8. Incluir pessoa na chamada");
                        System.out.println("9. Excluir pessoa da chamada");
                        System.out.println("10. Listar associações pessoa-chamada");
                        System.out.println("11. Sair");

                        int opcaoTelefone = scanner.nextInt();

                        switch (opcaoTelefone) {
                            case 1:
                                inserirChamada(scanner, telefoneDAO);
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
                        System.out.println("1. Inserir histórico");
                        System.out.println("2. Atualizar histórico");
                        System.out.println("3. Excluir histórico");
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

    private static void inserirChamada(Scanner scanner, TelefoneDAO telefoneDAO) {
        Date dataHora = new Date(System.currentTimeMillis());
        Chamada novaChamada = new Chamada(0, dataHora, 3);
        boolean inseriuChamada = telefoneDAO.insertChamada(novaChamada);
        if (inseriuChamada) {
            System.out.println("Chamada inserida com sucesso. ID: " + novaChamada.getIdChamadas());
        } else {
            System.out.println("Falha ao inserir a chamada.");
        }
    }

    private static void atualizarChamada(Scanner scanner, TelefoneDAO telefoneDAO) {
        System.out.println("Digite o ID da chamada a ser atualizada:");
        int idChamada = scanner.nextInt();
        System.out.println("Digite a nova quantidade de ligações:");
        int novaQuantidade = scanner.nextInt();
        boolean atualizouChamada = telefoneDAO.updateChamada(idChamada, novaQuantidade);
        if (atualizouChamada) {
            System.out.println("Chamada atualizada com sucesso.");
        } else {
            System.out.println("Falha ao atualizar a chamada.");
        }
    }

    private static void excluirChamada(Scanner scanner, TelefoneDAO telefoneDAO) {
        System.out.println("Digite o ID da chamada a ser excluída:");
        int idChamada = scanner.nextInt();
        boolean excluiuChamada = telefoneDAO.deleteChamada(idChamada);
        if (excluiuChamada) {
            System.out.println("Chamada excluída com sucesso.");
        } else {
            System.out.println("Falha ao excluir a chamada.");
        }
    }

    private static void inserirPessoa(Scanner scanner, TelefoneDAO telefoneDAO) {
        Pessoa novaPessoa = new Pessoa("João", "123456789", "joao@example.com", 0);
        boolean inseriuPessoa = telefoneDAO.insertPessoa(novaPessoa);
        if (inseriuPessoa) {
            System.out.println("Pessoa inserida com sucesso.");
        } else {
            System.out.println("Falha ao inserir pessoa.");
        }
    }

    private static void atualizarPessoa(Scanner scanner, TelefoneDAO telefoneDAO) {
        System.out.println("Digite o nome da pessoa a ser atualizada:");
        String nome = scanner.nextLine();
        System.out.println("Digite o novo número de telefone:");
        String novoNumero = scanner.next();

        // Criando um objeto Pessoa com os dados atualizados
        Pessoa pessoa = new Pessoa(nome, novoNumero, null, 0);

        // Chamando o método updatePessoa da classe TelefoneDAO
        boolean atualizouPessoa = telefoneDAO.updatePessoa(pessoa);

        if (atualizouPessoa) {
            System.out.println("Pessoa atualizada com sucesso.");
        } else {
            System.out.println("Falha ao atualizar a pessoa.");
        }
    }


    private static void excluirPessoa(Scanner scanner, TelefoneDAO telefoneDAO) {
        System.out.println("Digite o nome da pessoa a ser excluída:");
        String nomePessoa = scanner.next();

        // Chamando o método deletePessoa da classe TelefoneDAO
        boolean excluiuPessoa = telefoneDAO.deletePessoa(nomePessoa);

        if (excluiuPessoa) {
            System.out.println("Pessoa excluída com sucesso.");
        } else {
            System.out.println("Falha ao excluir a pessoa.");
        }
    }


    private static void listarPessoas(TelefoneDAO telefoneDAO) {
        ArrayList<Pessoa> pessoas = telefoneDAO.selectPessoas();
        System.out.println("Lista de pessoas:");
        for (Pessoa p : pessoas) {
            System.out.println("Nome: " + p.getNome() + ", Número de telefone: " + p.getNumero() + ", Email: " + p.getEmail() + ", Número de chamadas: " + p.getChamadasIdChamadas());
        }
    }


    private static void incluirPessoaChamada(Scanner scanner, TelefoneDAO telefoneDAO) {
        System.out.println("Digite o nome da pessoa:");
        String nomePessoa = scanner.next();
        System.out.println("Digite o ID da chamada:");
        int idChamada = scanner.nextInt();
        PessoaHasChamada pessoaHasChamada = new PessoaHasChamada(nomePessoa, idChamada);
        boolean incluiuAssociacao = telefoneDAO.insertPessoaHasChamada(pessoaHasChamada);
        if (incluiuAssociacao) {
            System.out.println("Associação pessoa-chamada incluída com sucesso.");
        } else {
            System.out.println("Falha ao incluir associação pessoa-chamada.");
        }
    }


    private static void excluirPessoaChamada(Scanner scanner, TelefoneDAO telefoneDAO) {
        System.out.println("Digite o nome da pessoa:");
        String nomePessoa = scanner.next();
        System.out.println("Digite o ID da chamada:");
        int idChamada = scanner.nextInt();
        boolean removeuAssociacao = telefoneDAO.deletePessoaHasChamada(nomePessoa, idChamada);
        if (removeuAssociacao) {
            System.out.println("Associação pessoa-chamada removida com sucesso.");
        } else {
            System.out.println("Falha ao remover associação pessoa-chamada.");
        }
    }


    private static void listarAssociacoesPessoaChamada(TelefoneDAO telefoneDAO) {
        ArrayList<PessoaHasChamada> associacoes = telefoneDAO.selectPessoaHasChamadas();
        System.out.println("Lista de associações pessoa-chamada:");
        for (PessoaHasChamada p : associacoes) {
            System.out.println("ID Pessoa: " + p.getPessoaNome() + ", ID Chamada: " + p.getChamadasIdChamadas());
        }
    }

    private static void inserirHistorico(Scanner scanner, GoogleDAO googleDAO) {
        System.out.println("Insira o site:");
        String site = scanner.next();
        System.out.println("Insira a URL:");
        String url = scanner.next();
        LocalDateTime horarioAcesso = LocalDateTime.now();
        Historico historico = new Historico(site, url, horarioAcesso);
        boolean inserirSucesso = googleDAO.insertHistorico(historico);
        if (inserirSucesso) {
            System.out.println("Histórico inserido com sucesso.");
        } else {
            System.out.println("Falha ao inserir histórico.");
        }
    }

    private static void atualizarHistorico(Scanner scanner, GoogleDAO googleDAO) {
        System.out.println("Insira o site cujo histórico deseja atualizar:");
        String siteAtualizar = scanner.next();
        LocalDateTime novoHorarioAcesso = LocalDateTime.now();
        boolean atualizarSucesso = googleDAO.updateHistorico(siteAtualizar, novoHorarioAcesso);
        if (atualizarSucesso) {
            System.out.println("Histórico atualizado com sucesso.");
        } else {
            System.out.println("Falha ao atualizar histórico.");
        }
    }

    private static void excluirHistorico(Scanner scanner, GoogleDAO googleDAO) {
        System.out.println("Insira o site cujo histórico deseja excluir:");
        String siteExcluir = scanner.next();
        boolean excluirSucesso = googleDAO.deleteHistorico(siteExcluir);
        if (excluirSucesso) {
            System.out.println("Histórico excluído com sucesso.");
        } else {
            System.out.println("Falha ao excluir histórico.");
        }
    }

    private static void listarHistorico(GoogleDAO googleDAO) {
        ArrayList<Historico> historicos = googleDAO.selectHistorico();
        System.out.println("Histórico de navegação:");
        for (Historico h : historicos) {
            System.out.println("Site: " + h.getSite() + ", URL: " + h.getUrl() + ", Horário de Acesso: " + h.getHorarioDeAcesso());
        }
    }

    private static void criarNovaConta(Scanner scanner, DragonCityDAO dragonCityDAO) {
        Random random = new Random();
        System.out.println("Digite o nome de usuário:");
        String username = scanner.next();
        System.out.println("Digite a senha:");
        String senha = scanner.next();

        try {
            boolean sucesso = dragonCityDAO.insertDragonCity(username, senha);
            if (sucesso) {
                System.out.println("Nova conta criada com sucesso.");
            } else {
                System.out.println("Falha ao criar nova conta.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao criar a conta: " + e.getMessage());
        }
    }



    private static void mudarNomeSenhaConta(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID da conta que deseja atualizar:");
        int idConta = scanner.nextInt();
        System.out.println("Digite o novo nome de usuário:");
        String novoUsername = scanner.next();
        System.out.println("Digite a nova senha:");
        String novaSenha = scanner.next();
        dragonCityDAO.updateDragonCity(idConta, novoUsername, novaSenha);
    }

    private static void deletarConta(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID da conta que deseja excluir:");
        int idConta = scanner.nextInt();
        dragonCityDAO.deleteDragonCity(idConta);
    }

    private static void listarContas(DragonCityDAO dragonCityDAO) {
        dragonCityDAO.selectDragonCities();
    }

    private static void comprarNovaIlha(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o nome da nova ilha:");
        String nomeIlha = scanner.next();
        System.out.println("Digite o ID da conta para qual a ilha será comprada:");
        int idConta = scanner.nextInt();
        dragonCityDAO.insertIlha(nomeIlha, idConta);
    }

    private static void venderIlha(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID da ilha que deseja vender:");
        int idIlha = scanner.nextInt();
        dragonCityDAO.deleteIlha(idIlha);
    }

    private static void listarIlhas(DragonCityDAO dragonCityDAO) {
        dragonCityDAO.selectIlhas();
    }

    private static void criarNovoHabitat(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite a quantidade de dragões que o habitat pode suportar:");
        int capacidade = scanner.nextInt();
        System.out.println("Digite o ID da ilha onde o habitat será criado:");
        int idIlha = scanner.nextInt();
        System.out.println("Digite o tipo do habitat:");
        String tipo = scanner.next();
        dragonCityDAO.insertHabitat(capacidade, idIlha, tipo);
    }

    private static void adicionarDragaoHabitat(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID do habitat onde o dragão será adicionado:");
        int idHabitat = scanner.nextInt();
        System.out.println("Digite o nome do dragão:");
        String nomeDragao = scanner.next();
        System.out.println("Digite a espécie do dragão:");
        String especie = scanner.next();
        System.out.println("Digite o nível do dragão:");
        int nivel = scanner.nextInt();
        dragonCityDAO.insertDragao(nomeDragao, especie, nivel, idHabitat);
    }

    private static void destruirHabitat(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID do habitat que deseja destruir:");
        int idHabitat = scanner.nextInt();
        dragonCityDAO.deleteHabitat(idHabitat);
    }

    private static void listarHabitats(DragonCityDAO dragonCityDAO) {
        dragonCityDAO.selectHabitat();
    }

    private static void mudarNomeDragao(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID do dragão cujo nome deseja mudar:");
        int idDragao = scanner.nextInt();
        System.out.println("Digite o novo nome:");
        String novoNome = scanner.next();
        dragonCityDAO.updateDragao(idDragao, novoNome);
    }

    private static void sacrificarDragao(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID do dragão que deseja sacrificar:");
        int idDragao = scanner.nextInt();
        dragonCityDAO.deleteDragao(idDragao);
    }

    private static void catalogarTipo(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o nome do tipo:");
        String nomeTipo = scanner.next();
        dragonCityDAO.insertTipo(nomeTipo);
    }

    private static void listarTipos(DragonCityDAO dragonCityDAO) {
        dragonCityDAO.selectTipo();
    }

    private static void associarTipoDragao(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o nome do dragão:");
        String nomeDragao = scanner.nextLine();
        System.out.println("Digite o nome do tipo:");
        String tipo = scanner.next();
        boolean sucesso = dragonCityDAO.insertTipoDragao(nomeDragao, tipo);
        if (sucesso) {
            System.out.println("Tipo associado ao dragão com sucesso.");
        } else {
            System.out.println("Falha ao associar tipo ao dragão.");
        }
    }

    private static void desassociarTipoDragao(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID do dragão:");
        int idDragao = scanner.nextInt();
        System.out.println("Digite o nome do tipo:");
        String tipo = scanner.next();
        boolean sucesso = dragonCityDAO.deleteTipoDragao(idDragao, tipo);
        if (sucesso) {
            System.out.println("Tipo desassociado do dragão com sucesso.");
        } else {
            System.out.println("Falha ao desassociar tipo do dragão.");
        }
    }

    private static void listarAssociacoesTipoDragao(DragonCityDAO dragonCityDAO) {
        ArrayList<String[]> tipoDragoes = dragonCityDAO.selectTipoDragao();
        for (String[] tipoDragao : tipoDragoes) {
            System.out.println("Nome do Dragão: " + tipoDragao[0] + ", Tipo: " + tipoDragao[1]);
        }
    }

}


