package br.com.gabrielrtakeda.to;

import java.io.Serializable;
import br.com.gabrielrtakeda.to.AbstractTO;

public class LoginTO extends AbstractTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String usuario;
    private String senha;
    private int perfil;

    public LoginTO setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return this.id;
    }

    public LoginTO setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public LoginTO setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getSenha() {
        return this.senha;
    }

    public LoginTO setPerfil(int perfil) {
        this.perfil = perfil;
        return this;
    }

    public int getPerfil() {
        return this.perfil;
    }
}





