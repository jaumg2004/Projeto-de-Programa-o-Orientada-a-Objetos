package org.example.DAO;

import java.sql.*;

public abstract class ConnectionDAO {

    Connection con; // Conexão
    PreparedStatement pst; // Declaração (query) preparada - código em SQL
    Statement st; // Declaração (query) - código em SQL
    ResultSet rs; // Resposta do banco

    String database = "Sakila"; // Nome do BD
    String user = "root";
    String password = "joao106260";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

    public void connectToDB() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException exc) {
            System.out.println("Erro ao conectar com o banco de dados: " + exc.getMessage());
        }
    }

    protected void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet fechado com sucesso.");
            }
            if (st != null) {
                st.close();
                System.out.println("Statement fechado com sucesso.");
            }
            if (pst != null) {
                pst.close();
                System.out.println("PreparedStatement fechado com sucesso.");
            }
            if (con != null) {
                con.close();
                System.out.println("Conexão com o banco de dados fechada com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }
}
