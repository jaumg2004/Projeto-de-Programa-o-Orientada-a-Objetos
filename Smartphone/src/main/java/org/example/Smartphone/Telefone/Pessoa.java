package org.example.Smartphone.Telefone;

public class Pessoa{
    private String nome;
    private String numero;
    private Chamada chamadas;
    private String eMail;

    public Pessoa(String nome, String numero, Chamada chamadas, String eMail) {
        this.nome = nome;
        this.numero = numero;
        this.chamadas = chamadas;
        this.eMail = eMail;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Chamada getChamadas() {
        return chamadas;
    }

    public void setChamadas(Chamada chamadas) {
        this.chamadas = chamadas;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}

