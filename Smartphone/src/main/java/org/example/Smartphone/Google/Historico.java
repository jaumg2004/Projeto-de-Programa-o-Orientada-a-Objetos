package org.example.Smartphone.Google;
import java.time.Date;

public class Historico {
    private String site;
    private String url;
    private Date horarioDeAcesso;

    public Historico(String site, String url, Date horarioDeAcesso) {
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

    public Date getHorarioDeAcesso() {
        return horarioDeAcesso;
    }

    public void setHorarioDeAcesso(Date horarioDeAcesso) {
        this.horarioDeAcesso = horarioDeAcesso;
    }

}
