package br.com.embraer.shipdocs.model.usuario;

import javax.persistence.Entity;

@Entity(name = "administrador")
public class Administrador extends Usuario {

    /*
    *   Construtor padrão
    */
    public Administrador(){}

    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }
}
