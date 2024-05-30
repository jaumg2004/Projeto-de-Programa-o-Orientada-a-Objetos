package org.example.Smartphone.Telefone;

import java.util.Date;

public class Chamada {
    private int idChamadas;
    private Date horarios;
    private int quantidadeDeLigacoes;

    public Chamada(int idChamadas, Date horarios, int quantidadeDeLigacoes) {
        this.idChamadas = idChamadas;
        this.horarios = horarios;
        this.quantidadeDeLigacoes = quantidadeDeLigacoes;
    }

    public int getIdChamadas() {
        return idChamadas;
    }

    public void setIdChamadas(int idChamadas) {
        this.idChamadas = idChamadas;
    }

    public Date getHorarios() {
        return horarios;
    }

    public void setHorarios(Date horarios) {
        this.horarios = horarios;
    }

    public int getQuantidadeDeLigacoes() {
        return quantidadeDeLigacoes;
    }

    public void setQuantidadeDeLigacoes(int quantidadeDeLigacoes) {
        this.quantidadeDeLigacoes = quantidadeDeLigacoes;
    }
}

