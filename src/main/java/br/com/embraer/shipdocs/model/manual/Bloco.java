package br.com.embraer.shipdocs.model.manual;

import br.com.embraer.shipdocs.model.EntidadeBase;

import javax.persistence.*;

@Entity(name = "bloco")
@Table(name = "bloco")
public class Bloco extends EntidadeBase {

    @Column(name = "numeroBloco")
    private String numeroBloco;

    @Column(name = "codigoBloco")
    private String codigoBloco;

    /**
     * Construtor padrão
     */
    public Bloco() {
    }

    public Bloco(String numeroBloco, String codigoBloco) {
        this.numeroBloco = numeroBloco;
        this.codigoBloco = codigoBloco;
    }

    public String getNumeroBloco() {
        return numeroBloco;
    }

    public void setNumeroBloco(String numeroBloco) {
        this.numeroBloco = numeroBloco;
    }

    public String getCodigoBloco() {
        return codigoBloco;
    }

    public void setCodigoBloco(String codigoBloco) {
        this.codigoBloco = codigoBloco;
    }
}
