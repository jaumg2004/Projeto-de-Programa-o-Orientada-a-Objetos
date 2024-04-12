package org.example.Smartphone.Telefone;

public class Pessoa extends Telefone {
    private String nome;
    private String numero;
    private Chamadas chamadas;
    private String eMail;

    public Pessoa(int idTelefone, Smartphone smartphone, String nome, String numero, Chamadas chamadas, String eMail) {
        super(idTelefone, smartphone);
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

    public Chamadas getChamadas() {
        return chamadas;
    }

    public void setChamadas(Chamadas chamadas) {
        this.chamadas = chamadas;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }
}


