package br.com.embraer.shipdocs.model.manual;

import br.com.embraer.shipdocs.model.EntidadeBase;

import javax.persistence.*;

@Entity(name = "subsecao")
@Table(name = "subsecao")
public class SubSecao extends EntidadeBase {

    @Column()
    private String codigoSubSecao;

    public String getCodigoSubSecao() {
        return codigoSubSecao;
    }

    // Construtor padrão
    public SubSecao() {
    }

    public SubSecao(String codigoSubSecao) {
        this.codigoSubSecao = codigoSubSecao;
    }

    public void setCodigoSubSecao(String codigoSubSecao) {
        this.codigoSubSecao = codigoSubSecao;
    }
}
