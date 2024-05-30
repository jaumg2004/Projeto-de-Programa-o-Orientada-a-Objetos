package org.example.Smartphone.Google;

import java.time.LocalDateTime;

public class Historico {
    private String site;
    private String url;
    private LocalDateTime horarioDeAcesso;

    public Historico(String site, String url, LocalDateTime horarioDeAcesso) {
        this.site = site;
        this.url = url;
        this.horarioDeAcesso = horarioDeAcesso;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getHorarioDeAcesso() {
        return horarioDeAcesso;
    }

    public void setHorarioDeAcesso(LocalDateTime horarioDeAcesso) {
        this.horarioDeAcesso = horarioDeAcesso;
    }

}
