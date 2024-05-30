package org.example.DAO;

import org.example.Smartphone.Google.Historico;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.*;

public class GoogleDAO extends ConnectionDAO {

    // INSERT na tabela Historico
    public boolean insertHistorico(Historico historico) {
        connectToDB();
        String sql = "INSERT INTO sakila.Historico (Site, URL, `Horario de acesso`) VALUES (?, ?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, historico.getSite());
            pst.setString(2, historico.getUrl());
            pst.setTimestamp(3, Timestamp.valueOf(historico.getHorarioDeAcesso()));
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        return sucesso;
    }

    // UPDATE na tabela Historico
    public boolean updateHistorico(String site, LocalDateTime novoHorarioAcesso) {
        connectToDB();
        String sql = "UPDATE Historico SET `Horario de acesso` = ? WHERE Site = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setTimestamp(1, Timestamp.valueOf(novoHorarioAcesso));
            pst.setString(2, site);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        return sucesso;
    }

    // DELETE na tabela Historico
    public boolean deleteHistorico(String site) {
        connectToDB();
        String sql = "DELETE FROM sakila.Historico WHERE Site = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, site);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        return sucesso;
    }

    // SELECT na tabela Historico
    public ArrayList<Historico> selectHistorico() {
        ArrayList<Historico> historicos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM sakila.Historico";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String site = rs.getString("Site");
                String url = rs.getString("URL");
                Timestamp timestamp = rs.getTimestamp("Horario de acesso");
                LocalDateTime horarioAcesso = timestamp.toLocalDateTime();
                Historico historico = new Historico(site, url, horarioAcesso);
                historicos.add(historico);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            closeConnections();
        }
        return historicos;
    }
}
