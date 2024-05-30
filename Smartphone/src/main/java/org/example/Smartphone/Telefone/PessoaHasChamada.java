package org.example.Smartphone.Telefone;

public class PessoaHasChamada {
    private String pessoaNome;
    private int chamadasIdChamadas;

    // Constructor
    public PessoaHasChamada(String pessoaNome, int chamadasIdChamadas) {
        this.pessoaNome = pessoaNome;
        this.chamadasIdChamadas = chamadasIdChamadas;
    }

    // Getters and Setters
    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public int getChamadasIdChamadas() {
        return chamadasIdChamadas;
    }

    public void setChamadasIdChamadas(int chamadasIdChamadas) {
        this.chamadasIdChamadas = chamadasIdChamadas;
    }

}

