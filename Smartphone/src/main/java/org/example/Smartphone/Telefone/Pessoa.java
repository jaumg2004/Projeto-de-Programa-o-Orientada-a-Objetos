package org.example.Smartphone.Telefone;

public class Pessoa {
    private String nome;
    private String numero;
    private String email;
    private int chamadasIdChamadas;

    public Pessoa(String nome, String numero, String email, int chamadasIdChamadas) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.chamadasIdChamadas = chamadasIdChamadas;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }

    public int getChamadasIdChamadas() {
        return chamadasIdChamadas;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setChamadasIdChamadas(int chamadasIdChamadas) {
        this.chamadasIdChamadas = chamadasIdChamadas;
    }

}


