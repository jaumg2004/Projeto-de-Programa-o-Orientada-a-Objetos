package org.example.DAO;
import java.util.Timestamp;
import java.sql.*;

public class GoogleDAO extends ConnectionDAO{

    // INSERT na tabela Historico
    public boolean insertHistorico(String site, String url, Timestamp horarioAcesso) {
        connectToDB();
        String sql = "INSERT INTO sakila.Historico (Site, URL, `Horario de acesso`) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, site);
            pst.setString(2, url);
            pst.setTimestamp(3, horarioAcesso);
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

    // UPDATE na tabela Historico
    public boolean updateHistorico(String site, Timestamp novoHorarioAcesso) {
        connectToDB();
        String sql = "UPDATE Historico SET `Horario de acesso` = ? WHERE Site = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setTimestamp(1, novoHorarioAcesso);  // Correct assignment of Timestamp
            pst.setString(2, site);
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

    // DELETE na tabela Historico
    public boolean deleteHistorico(String site) {
        connectToDB();
        String sql = "DELETE FROM sakila.Historico WHERE Site = ?";
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
                con.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        return sucesso;
    }

    // SELECT na tabela Historico
    public ArrayList<String[]> selectHistorico() {
        ArrayList<String[]> historicos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM sakila.Historico";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] historico = new String[3];
                historico[0] = rs.getString("Site");
                historico[1] = rs.getString("URL");
                historico[2] = rs.getTimestamp("Horario de acesso").toString();
                historicos.add(historico);
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
        return historicos;
    }

}

