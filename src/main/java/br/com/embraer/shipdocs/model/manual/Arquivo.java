package br.com.embraer.shipdocs.model.manual;

import br.com.embraer.shipdocs.model.EntidadeBase;

import javax.persistence.*;

@Entity(name = "arquivo")
@Table(name = "arquivo")
public class Arquivo extends EntidadeBase {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private byte[] conteudo;

    @Column(nullable = false)
    private TipoArquivo tipoArquivo;

    /*
    *   Construtor padrão
    */
    public Arquivo(){}

    public Arquivo(String nome, byte[] conteudo, TipoArquivo tipoArquivo) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.tipoArquivo = tipoArquivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }
}
