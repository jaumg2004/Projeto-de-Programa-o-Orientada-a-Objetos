package org.example.Smartphone.Google;
import java.time.Datetime;

public class Historico {
    private String site;
    private String url;
    private Datetime horarioDeAcesso;

    public Historico(String site, String url, Datetime horarioDeAcesso) {
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

    public Datetime getHorarioDeAcesso() {
        return horarioDeAcesso;
    }

    public void setHorarioDeAcesso(Datetime horarioDeAcesso) {
        this.horarioDeAcesso = horarioDeAcesso;
    }

}
