package org.example.DAO;

import java.sql.*;

public class TelefoneDAO extends ConnectionDAO {

    // INSERT
    public boolean insertChamada(Chamada chamada) {
        connectToDB();
        String sql = "INSERT INTO Chamadas (idChamadas, Horários, `Quantidade de ligações`) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, chamada.getIdChamadas());
            pst.setTimestamp(2, new java.sql.Timestamp(chamada.getHorarios().getTime()));
            pst.setInt(3, chamada.getQuantidadeDeLigacoes());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnection();
        }
        return sucesso;
    }

    // UPDATE
    public boolean updateChamada(int idChamadas, int novaQuantidade) {
        connectToDB();
        String sql = "UPDATE Chamadas SET `Quantidade de ligações` = ? WHERE idChamadas = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, novaQuantidade);
            pst.setInt(2, idChamadas);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnection();
        }
        return sucesso;
    }

    // DELETE
    public boolean deleteChamada(int idChamadas) {
        connectToDB();
        String sql = "DELETE FROM Chamadas WHERE idChamadas = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idChamadas);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnection();
        }
        return sucesso;
    }
}
