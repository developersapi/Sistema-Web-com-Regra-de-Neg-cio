package br.com.embraer.shipdocs.model.manual;

import br.com.embraer.shipdocs.model.EntidadeBase;

import javax.persistence.*;

@Entity(name = "manual")
@Table(name = "manual")
public class Manual extends EntidadeBase {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "identificacao")
    private Identificacao identificacao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "arquivo")
    private Arquivo arquivo;

    /**
     * Construtor padrão
     */
    public Manual() {
    }

    public Manual(Identificacao identificacao, Arquivo arquivo) {
        this.identificacao = identificacao;
        this.arquivo = arquivo;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public Identificacao getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Identificacao identificacao) {
        this.identificacao = identificacao;
    }
}
