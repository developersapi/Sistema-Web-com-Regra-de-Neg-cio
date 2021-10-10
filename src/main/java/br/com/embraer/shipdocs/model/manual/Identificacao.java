package br.com.embraer.shipdocs.model.manual;

import br.com.embraer.shipdocs.model.EntidadeBase;

import javax.persistence.*;

@Entity(name = "identificacao")
public class Identificacao extends EntidadeBase {

    @Column(nullable = false)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "traco")
    private Traco traco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bloco")
    private Bloco bloco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secao")
    private Secao secao;

    /**
     * Construtor padrão
     */
    public Identificacao() {
    }

    public Identificacao(String nome, Traco traco, Bloco bloco, Secao secao) {
        this.nome = nome;
        this.traco = traco;
        this.bloco = bloco;
        this.secao = secao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Traco getTraco() {
        return traco;
    }

    public void setTraco(Traco traco) {
        this.traco = traco;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }
}
