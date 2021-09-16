package br.com.embraer.shipdocs.model;

import javax.persistence.Entity;

@Entity(name = "funcionario")
public class Funcionario extends Usuario{

    public Funcionario(String nome, String email, String senha) {
        super(nome, email, senha);
    }
}
