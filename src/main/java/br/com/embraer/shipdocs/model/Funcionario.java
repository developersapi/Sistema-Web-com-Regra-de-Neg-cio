package br.com.embraer.shipdocs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "funcionario")
public class Funcionario extends Usuario{

    /*
    *   Construtor padrão
    */
    public Funcionario() {}

    public Funcionario(String nome, String email, String senha) {
        super(nome, email, senha);
    }
}
