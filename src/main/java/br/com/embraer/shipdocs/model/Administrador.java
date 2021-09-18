package br.com.embraer.shipdocs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "administrador")
public class Administrador extends Usuario{

    /*
    *   Construtor padrão
    */
    public Administrador(){}

    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }
}
