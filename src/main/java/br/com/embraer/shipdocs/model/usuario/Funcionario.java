package br.com.embraer.shipdocs.model.usuario;

import javax.persistence.Entity;

@Entity(name = "funcionario")
public class Funcionario extends Usuario {

    /**
     *  Construtor padrão
     */
    public Funcionario() {}

    public Funcionario(String nome, String email, String senha) {
        super(nome, email, senha);
    }
}
