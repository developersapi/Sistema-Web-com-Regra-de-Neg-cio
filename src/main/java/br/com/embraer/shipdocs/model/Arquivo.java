package br.com.embraer.shipdocs.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity(name = "arquivo")
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
