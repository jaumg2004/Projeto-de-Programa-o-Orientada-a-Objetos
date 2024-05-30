package org.example.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class DragonCityDAO extends ConnectionDAO {

    // INSERT na tabela Dragon City
    public boolean insertDragonCity(String username, String senha) {
        connectToDB();
        Random random = new Random();
        int idDragonCity = random.nextInt()*10000000;
        System.out.println("Id da conta: "+idDragonCity);
        String sql = "INSERT INTO sakila.`Dragon City` (idDragonCity, Username, Senha) VALUES (?, ?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idDragonCity);
            pst.setString(2, username);
            pst.setString(3, senha);
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

    // UPDATE na tabela Dragon City
    public boolean updateDragonCity(int idDragonCity, String newUsername, String newSenha) {
        connectToDB();
        String sql = "UPDATE sakila.`Dragon City` SET Username = ?, Senha = ? WHERE idDragonCity = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, newUsername);
            pst.setString(2, newSenha);
            pst.setInt(3, idDragonCity);
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

    // DELETE na tabela Dragon City
    public boolean deleteDragonCity(int idDragonCity) {
        connectToDB();
        String sql = "DELETE FROM sakila.`Dragon City` WHERE idDragonCity = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idDragonCity);
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

    // SELECT na tabela Dragon City
    public ArrayList<String[]> selectDragonCities() {
        ArrayList<String[]> dragonCityEntries = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM sakila.`Dragon City`";
        boolean sucesso;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] entry = new String[3];
                entry[0] = String.valueOf(rs.getInt("idDragon City"));
                entry[1] = rs.getString("Username");
                entry[2] = rs.getString("Senha");
                dragonCityEntries.add(entry);
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
        return dragonCityEntries;
    }

    // INSERT na tabela Ilhas
    public boolean insertIlha(String nomeIlha, int dragonCityId) {
        connectToDB();
        Random random = new Random();
        int idIlha = random.nextInt()*10000000;
        System.out.println("Id da ilha: "+idIlha);
        String sql = "INSERT INTO sakila.Ilhas (idIlhas, `Nome da ilha`, `Dragon City_idDragon City`) VALUES (?, ?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idIlha);
            pst.setString(2, nomeIlha);
            pst.setInt(3, dragonCityId);
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

    // DELETE na tabela Ilhas
    public boolean deleteIlha(int idIlha) {
        connectToDB();
        String sql = "DELETE FROM sakila.Ilhas WHERE idIlhas = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idIlha);
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

    // SELECT na tabela Ilhas
    public ArrayList<String[]> selectIlhas() {
        ArrayList<String[]> ilhas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM sakila.Ilhas";
        boolean sucesso;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] ilha = new String[3];
                ilha[0] = String.valueOf(rs.getInt("idIlhas"));
                ilha[1] = rs.getString("Nome da ilha");
                ilha[2] = String.valueOf(rs.getInt("Dragon City_idDragon City"));
                ilhas.add(ilha);
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
        return ilhas;
    }

    // INSERT na tabela Tipo
    public boolean insertTipo(String tipo) {
        connectToDB();
        String sql = "INSERT INTO sakila.Tipo (Tipo) VALUES (?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, tipo);
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


    // SELECT na tabela Tipo
    public ArrayList<String> selectTipo() {
        ArrayList<String> tipos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM sakila.Tipo";
        boolean sucesso;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                tipos.add(rs.getString("Tipo"));
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
        return tipos;
    }

    // INSERT na tabela Dragões
    public boolean insertDragao(String nome, String especie, Integer nivel, int habitatIdHabitat) {
        connectToDB();
        Random random = new Random();
        int idDragoes = random.nextInt()*10000000;
        System.out.println("Id da ilha: "+idDragoes);
        String sql = "INSERT INTO sakila.Dragões (idDragões, Nome, Espécie, Nível, Habitat_idHabitat) VALUES (?, ?, ?, ?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idDragoes);
            pst.setString(2, nome);
            pst.setString(3, especie);
            pst.setObject(4, nivel, Types.INTEGER);
            pst.setInt(5, habitatIdHabitat);
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

    // UPDATE na tabela Dragões
    public boolean updateDragao(int idDragoes, String novoNome) {
        connectToDB();
        String sql = "UPDATE sakila.Dragões SET Nome = ? WHERE idDragões = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, novoNome);
            pst.setInt(2, idDragoes);
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

    // DELETE na tabela Dragões
    public boolean deleteDragao(int idDragoes) {
        connectToDB();
        String sql = "DELETE FROM sakila.Dragões WHERE idDragões = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idDragoes);
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

    // SELECT na tabela Dragões
    public ResultSet selectDragoes() {
        connectToDB();
        String sql = "SELECT * FROM sakila.Dragões";
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return rs; // Note: Connection must be closed outside after processing ResultSet
    }

    // INSERT na tabela Habitat
    public boolean insertHabitat(int quantDragoes, int ilhasIdIlhas, String tipoTipo) {
        connectToDB();
        Random random = new Random();
        int idHabitat = random.nextInt()*10000000;
        System.out.println("Id da ilha: "+idHabitat);
        String sql = "INSERT INTO sakila.Habitat (idHabitat, QuantDragoes, Ilhas_idIlhas, Tipo_Tipo) VALUES (?, ?, ?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idHabitat);
            pst.setInt(2, quantDragoes);
            pst.setInt(3, ilhasIdIlhas);
            pst.setString(4, tipoTipo);
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

    // UPDATE na tabela Habitat
    public boolean updateHabitat(int idHabitat, int newQuantDragoes) {
        connectToDB();
        String sql = "UPDATE sakila.Habitat SET QuantDragoes = ? WHERE idHabitat = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, newQuantDragoes);
            pst.setInt(2, idHabitat);
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

    // DELETE na tabela Habitat
    public boolean deleteHabitat(int idHabitat) {
        connectToDB();
        String sql = "DELETE FROM sakila.Habitat WHERE idHabitat = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idHabitat);
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

    // SELECT na tabela Habitat
    public ArrayList<String[]> selectHabitat() {
        ArrayList<String[]> habitats = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM sakila.Habitat";
        boolean sucesso;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] habitat = new String[4];
                habitat[0] = String.valueOf(rs.getInt("idHabitat"));
                habitat[1] = String.valueOf(rs.getInt("QuantDragoes"));
                habitat[2] = String.valueOf(rs.getInt("Ilhas_idIlhas"));
                habitat[3] = rs.getString("Tipo_Tipo");
                habitats.add(habitat);
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
        return habitats;
    }

    // INSERT into Tipo_has_Dragões table
    public boolean insertTipoDragao(String nomeDragao, String tipo) {
        connectToDB();
        String sql = "INSERT INTO sakila.Tipo_has_Dragões (Dragões_nomeDragões, Tipo_Tipo) VALUES (?, ?)";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nomeDragao);
            pst.setString(2, tipo);
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

    // DELETE from Tipo_has_Dragões table
    public boolean deleteTipoDragao(int idDragao, String tipo) {
        connectToDB();
        String sql = "DELETE FROM sakila.Tipo_has_Dragões WHERE Dragões_idDragões = ? AND Tipo_Tipo = ?";
        boolean sucesso;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idDragao);
            pst.setString(2, tipo);
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

    // SELECT from Tipo_has_Dragões table
    public ArrayList<String[]> selectTipoDragao() {
        ArrayList<String[]> tipoDragoes = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM sakila.Tipo_has_Dragões";
        boolean sucesso;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] tipoDragao = new String[2];
                tipoDragao[0] = String.valueOf(rs.getInt("Dragões_idDragões"));
                tipoDragao[1] = rs.getString("Tipo_Tipo");
                tipoDragoes.add(tipoDragao);
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
        return tipoDragoes;
    }

}