package br.com.embraer.shipdocs.model.manual;

import br.com.embraer.shipdocs.model.EntidadeBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "traco")
@Table(name = "traco")
public class Traco extends EntidadeBase {

    @Column(nullable = false)
    private String codigoTraco;

    @Column(nullable = false)
    private String codigoPN;

    public Traco(String codigoTraco, String codigoPN) {
        this.codigoTraco = codigoTraco;
        this.codigoPN = codigoPN;
    }

    public String getCodigoTraco() {
        return codigoTraco;
    }

    public void setCodigoTraco(String codigoTraco) {
        this.codigoTraco = codigoTraco;
    }

    public String getCodigoPN() {
        return codigoPN;
    }

    public void setCodigoPN(String codigoPN) {
        this.codigoPN = codigoPN;
    }

}
