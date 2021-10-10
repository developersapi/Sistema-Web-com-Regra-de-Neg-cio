package br.com.embraer.shipdocs.model.manual;

import br.com.embraer.shipdocs.model.EntidadeBase;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity(name = "secao")
@Table(name = "secao")
public class Secao extends EntidadeBase {

    @Column(nullable = false)
    private String codigoSecao;

    @ManyToOne
    @JoinColumn(nullable = true)
    private SubSecao subSecao;

    /**
     * Construtor padrão
     * */
    public Secao() {
    }

    public Secao(String codigoSecao, @Nullable SubSecao subSecao) {
        this.codigoSecao = codigoSecao;
        this.subSecao = subSecao;
    }

    public String getCodigoSecao() {
        return codigoSecao;
    }

    public void setCodigoSecao(String codigoSecao) {
        this.codigoSecao = codigoSecao;
    }

    public SubSecao getSubSecao() {
        return subSecao;
    }

    public void setSubSecao(SubSecao subSecao) {
        this.subSecao = subSecao;
    }
}
