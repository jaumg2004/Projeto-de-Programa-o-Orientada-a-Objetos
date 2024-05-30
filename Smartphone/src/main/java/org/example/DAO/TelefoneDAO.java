package org.example.DAO;

import org.example.Smartphone.Telefone.*;
import java.sql.*;
import java.util.ArrayList;

public class TelefoneDAO extends ConnectionDAO {

    // INSERT Chamada
    public boolean insertChamada(Chamada chamada) {
        connectToDB();
        String sql = "INSERT INTO Chamadas (Horarios, Quantidade_de_ligacoes) VALUES (?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setTimestamp(1, new Timestamp(chamada.getHorarios().getTime()));
            pst.setInt(2, chamada.getQuantidadeDeLigacoes());
            pst.execute();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                chamada.setIdChamadas(rs.getInt(1));
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    // UPDATE Chamada
    public boolean updateChamada(int idChamadas, int novaQuantidade) {
        connectToDB();
        String sql = "UPDATE Chamadas SET Quantidade_de_ligacoes = ? WHERE idChamadas = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, novaQuantidade);
            pst.setInt(2, idChamadas);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    // DELETE Chamada
    public boolean deleteChamada(int idChamadas) {
        connectToDB();
        String sql = "DELETE FROM Chamadas WHERE idChamadas = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idChamadas);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    // INSERT Pessoa
    public boolean insertPessoa(Pessoa pessoa) {
        connectToDB();
        String sql = "INSERT INTO Pessoa (Nome, Numero, Email, Chamadas_idChamadas) VALUES (?, ?, ?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getNumero());
            pst.setString(3, pessoa.getEmail());
            pst.setInt(4, pessoa.getChamadasIdChamadas());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    // UPDATE Pessoa
    public boolean updatePessoa(Pessoa pessoa) {
        connectToDB();
        String sql = "UPDATE Pessoa SET Numero = ?, Email = ?, Chamadas_idChamadas = ? WHERE Nome = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pessoa.getNumero());
            pst.setString(2, pessoa.getEmail());
            pst.setInt(3, pessoa.getChamadasIdChamadas());
            pst.setString(4, pessoa.getNome());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    // DELETE Pessoa
    public boolean deletePessoa(String nome) {
        connectToDB();
        String sql = "DELETE FROM Pessoa WHERE Nome = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    // SELECT Pessoa
    public ArrayList<Pessoa> selectPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Pessoa";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(
                        rs.getString("Nome"),
                        rs.getString("Numero"),
                        rs.getString("Email"),
                        rs.getInt("Chamadas_idChamadas")
                );
                pessoas.add(pessoa);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            closeConnections();
        }
        return pessoas;
    }


    // INSERT PessoaHasChamada
    public boolean insertPessoaHasChamada(PessoaHasChamada pessoaHasChamada) {
        connectToDB();
        String sql = "INSERT INTO Pessoa_has_Chamadas (Pessoa_Nome, Chamadas_idChamadas) VALUES (?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pessoaHasChamada.getPessoaNome());
            pst.setInt(2, pessoaHasChamada.getChamadasIdChamadas());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }


    // DELETE PessoaHasChamada
    public boolean deletePessoaHasChamada(String pessoaNome, int chamadasIdChamadas) {
        connectToDB();
        String sql = "DELETE FROM Pessoa_has_Chamadas WHERE Pessoa_Nome = ? AND Chamadas_idChamadas = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, pessoaNome);
            pst.setInt(2, chamadasIdChamadas);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            sucesso = false;
        } finally {
            closeConnections();
        }
        return sucesso;
    }

    // SELECT PessoaHasChamada
    public ArrayList<PessoaHasChamada> selectPessoaHasChamadas() {
        ArrayList<PessoaHasChamada> pessoaHasChamadas = new ArrayList<>();
        try {
            connectToDB();
            String sql = "SELECT * FROM Pessoa_has_Chamadas";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                PessoaHasChamada pessoaHasChamada = new PessoaHasChamada(
                        rs.getString("Pessoa_Nome"),
                        rs.getInt("Chamadas_idChamadas")
                );
                pessoaHasChamadas.add(pessoaHasChamada);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao selecionar as associações pessoa-chamada: " + ex.getMessage());
        } finally {
            closeConnections();
        }
        return pessoaHasChamadas;
    }



}
