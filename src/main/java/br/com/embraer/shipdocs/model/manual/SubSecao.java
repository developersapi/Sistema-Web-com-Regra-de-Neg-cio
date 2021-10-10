package br.com.embraer.shipdocs.model.manual;

import br.com.embraer.shipdocs.model.EntidadeBase;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "subsecao")
@Table(name = "subsecao")
public class SubSecao extends EntidadeBase {

    private String codigoSubSecao;

    public String getCodigoSubSecao() {
        return codigoSubSecao;
    }

    public void setCodigoSubSecao(String codigoSubSecao) {
        this.codigoSubSecao = codigoSubSecao;
    }
}
