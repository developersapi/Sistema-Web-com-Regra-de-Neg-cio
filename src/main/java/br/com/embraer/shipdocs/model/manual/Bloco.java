package br.com.embraer.shipdocs.model.manual;

import br.com.embraer.shipdocs.model.EntidadeBase;

import javax.persistence.*;

@Entity(name = "bloco")
@Table(name = "bloco")
public class Bloco extends EntidadeBase {

    @Column(name = "numeroBloco")
    private String numeroBloco;

    /**
     * Construtor padrão
     */
    public Bloco() {
    }

    public Bloco(String numeroBloco) {
        this.numeroBloco = numeroBloco;
    }
}
