package br.com.embraer.shipdocs.model.codelist;

import br.com.embraer.shipdocs.model.EntidadeBase;
import br.com.embraer.shipdocs.model.manual.Bloco;
import br.com.embraer.shipdocs.model.manual.Secao;
import br.com.embraer.shipdocs.model.manual.Traco;

import javax.persistence.*;

@Entity(name = "Codelist")
@Table(name = "Codelist")
public class Codelist extends EntidadeBase {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Secao secao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Bloco bloco;

    @Column
    private String nomeBloco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Traco traco;

    public Codelist() {
    }

    public Codelist(Secao secao, Bloco bloco, String nomeBloco, Traco traco) {
        this.secao = secao;
        this.bloco = bloco;
        this.nomeBloco = nomeBloco;
        this.traco = traco;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public String getNomeBloco() {
        return nomeBloco;
    }

    public void setNomeBloco(String nomeBloco) {
        this.nomeBloco = nomeBloco;
    }

    public Traco getTraco() {
        return traco;
    }

    public void setTraco(Traco traco) {
        this.traco = traco;
    }
}
