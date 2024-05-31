package org.example.Smartphone.DragonCity;

import org.example.DAO.DragonCityDAO;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DragonCity {
    public static void criarNovaConta(Scanner scanner, DragonCityDAO dragonCityDAO) {
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



    public static void mudarNomeSenhaConta(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID da conta que deseja atualizar:");
        int idConta = scanner.nextInt();
        System.out.println("Digite o novo nome de usuário:");
        String novoUsername = scanner.next();
        System.out.println("Digite a nova senha:");
        String novaSenha = scanner.next();
        dragonCityDAO.updateDragonCity(idConta, novoUsername, novaSenha);
    }

    public static void deletarConta(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID da conta que deseja excluir:");
        int idConta = scanner.nextInt();
        dragonCityDAO.deleteDragonCity(idConta);
    }

    public static void listarContas(DragonCityDAO dragonCityDAO) {
        dragonCityDAO.selectDragonCities();
    }

    public static void comprarNovaIlha(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o nome da nova ilha:");
        String nomeIlha = scanner.next();
        System.out.println("Digite o ID da conta para qual a ilha será comprada:");
        int idConta = scanner.nextInt();
        dragonCityDAO.insertIlha(nomeIlha, idConta);
    }

    public static void venderIlha(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID da ilha que deseja vender:");
        int idIlha = scanner.nextInt();
        dragonCityDAO.deleteIlha(idIlha);
    }

    public static void listarIlhas(DragonCityDAO dragonCityDAO) {
        dragonCityDAO.selectIlhas();
    }

    public static void criarNovoHabitat(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite a quantidade de dragões que o habitat pode suportar:");
        int capacidade = scanner.nextInt();
        System.out.println("Digite o ID da ilha onde o habitat será criado:");
        int idIlha = scanner.nextInt();
        System.out.println("Digite o tipo do habitat:");
        String tipo = scanner.next();
        dragonCityDAO.insertHabitat(capacidade, idIlha, tipo);
    }

    public static void adicionarDragaoHabitat(Scanner scanner, DragonCityDAO dragonCityDAO) {
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

    public static void destruirHabitat(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID do habitat que deseja destruir:");
        int idHabitat = scanner.nextInt();
        dragonCityDAO.deleteHabitat(idHabitat);
    }

    public static void listarHabitats(DragonCityDAO dragonCityDAO) {
        dragonCityDAO.selectHabitat();
    }

    public static void mudarNomeDragao(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID do dragão cujo nome deseja mudar:");
        int idDragao = scanner.nextInt();
        System.out.println("Digite o novo nome:");
        String novoNome = scanner.next();
        dragonCityDAO.updateDragao(idDragao, novoNome);
    }

    public static void sacrificarDragao(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o ID do dragão que deseja sacrificar:");
        int idDragao = scanner.nextInt();
        dragonCityDAO.deleteDragao(idDragao);
    }

    public static void catalogarTipo(Scanner scanner, DragonCityDAO dragonCityDAO) {
        System.out.println("Digite o nome do tipo:");
        String nomeTipo = scanner.next();
        dragonCityDAO.insertTipo(nomeTipo);
    }

    public static void listarTipos(DragonCityDAO dragonCityDAO) {
        dragonCityDAO.selectTipo();
    }

    public static void associarTipoDragao(Scanner scanner, DragonCityDAO dragonCityDAO) {
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

    public static void desassociarTipoDragao(Scanner scanner, DragonCityDAO dragonCityDAO) {
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

    public static void listarAssociacoesTipoDragao(DragonCityDAO dragonCityDAO) {
        ArrayList<String[]> tipoDragoes = dragonCityDAO.selectTipoDragao();
        for (String[] tipoDragao : tipoDragoes) {
            System.out.println("Nome do Dragão: " + tipoDragao[0] + ", Tipo: " + tipoDragao[1]);
        }
    }

}


