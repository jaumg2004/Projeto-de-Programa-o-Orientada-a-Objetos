package org.example.Smartphone.Telefone;

public class PessoaHasChamadas {
    private Pessoa pessoa;
    private Chamadas chamadas;

    // Construtor, getters e setters
    public PessoaHasChamadas(Pessoa pessoa, Chamadas chamadas) {
        this.pessoa = pessoa;
        this.chamadas = chamadas;
    }

    // Getters e setters
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Chamadas getChamadas() {
        return chamadas;
    }

    public void setChamadas(Chamadas chamadas) {
        this.chamadas = chamadas;
    }
}
