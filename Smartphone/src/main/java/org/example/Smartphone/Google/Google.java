package org.example.Smartphone.Google;

import org.example.DAO.GoogleDAO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Google {
    public static void inserirHistorico(Scanner scanner, GoogleDAO googleDAO) {
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

    public static void atualizarHistorico(Scanner scanner, GoogleDAO googleDAO) {
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

    public static void excluirHistorico(Scanner scanner, GoogleDAO googleDAO) {
        System.out.println("Insira o site cujo histórico deseja excluir:");
        String siteExcluir = scanner.next();
        boolean excluirSucesso = googleDAO.deleteHistorico(siteExcluir);
        if (excluirSucesso) {
            System.out.println("Histórico excluído com sucesso.");
        } else {
            System.out.println("Falha ao excluir histórico.");
        }
    }

    public static void listarHistorico(GoogleDAO googleDAO) {
        ArrayList<Historico> historicos = googleDAO.selectHistorico();
        System.out.println("Histórico de navegação:");
        for (Historico h : historicos) {
            System.out.println("Site: " + h.getSite() + ", URL: " + h.getUrl() + ", Horário de Acesso: " + h.getHorarioDeAcesso());
        }
    }
}
