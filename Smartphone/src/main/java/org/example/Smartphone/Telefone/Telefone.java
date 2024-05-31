package org.example.Smartphone.Telefone;

import org.example.DAO.TelefoneDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Telefone {
    public static void inserirChamada(TelefoneDAO telefoneDAO) {
        Date dataHora = new Date(System.currentTimeMillis());
        Chamada novaChamada = new Chamada(0, dataHora, 0);
        boolean inseriuChamada = telefoneDAO.insertChamada(novaChamada);
        if (inseriuChamada) {
            System.out.println("Chamada inserida com sucesso. ID: " + novaChamada.getIdChamadas());
        } else {
            System.out.println("Falha ao inserir a chamada.");
        }
    }

    public static void atualizarChamada(Scanner scanner, TelefoneDAO telefoneDAO) {
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

    public static void excluirChamada(Scanner scanner, TelefoneDAO telefoneDAO) {
        System.out.println("Digite o ID da chamada a ser excluída:");
        int idChamada = scanner.nextInt();
        boolean excluiuChamada = telefoneDAO.deleteChamada(idChamada);
        if (excluiuChamada) {
            System.out.println("Chamada excluída com sucesso.");
        } else {
            System.out.println("Falha ao excluir a chamada.");
        }
    }

    public static void inserirPessoa(Scanner scanner, TelefoneDAO telefoneDAO) {
        Random random = new Random();
        String nome = scanner.nextLine();
        String numero = scanner.nextLine();
        String email = scanner.nextLine();
        int chamada = random.nextInt()*10000000;
        Pessoa novaPessoa = new Pessoa(nome, numero, email, chamada);
        boolean inseriuPessoa = telefoneDAO.insertPessoa(novaPessoa);
        if (inseriuPessoa) {
            System.out.println("Pessoa inserida com sucesso.");
            System.out.println("ID do novo contato: " + chamada);
        } else {
            System.out.println("Falha ao inserir pessoa.");
        }
    }

    public static void atualizarPessoa(Scanner scanner, TelefoneDAO telefoneDAO) {
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


    public static void excluirPessoa(Scanner scanner, TelefoneDAO telefoneDAO) {
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


    public static void listarPessoas(TelefoneDAO telefoneDAO) {
        ArrayList<Pessoa> pessoas = telefoneDAO.selectPessoas();
        System.out.println("Lista de pessoas:");
        for (Pessoa p : pessoas) {
            System.out.println("Nome: " + p.getNome() + ", Número de telefone: " + p.getNumero() + ", Email: " + p.getEmail() + ", Número de chamadas: " + p.getChamadasIdChamadas());
        }
    }


    public static void incluirPessoaChamada(Scanner scanner, TelefoneDAO telefoneDAO) {
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


    public static void excluirPessoaChamada(Scanner scanner, TelefoneDAO telefoneDAO) {
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


    public static void listarAssociacoesPessoaChamada(TelefoneDAO telefoneDAO) {
        ArrayList<PessoaHasChamada> associacoes = telefoneDAO.selectPessoaHasChamadas();
        System.out.println("Lista de associações pessoa-chamada:");
        for (PessoaHasChamada p : associacoes) {
            System.out.println("ID Pessoa: " + p.getPessoaNome() + ", ID Chamada: " + p.getChamadasIdChamadas());
        }
    }

}
