package br.com.gabrielrtakeda.to;

import java.io.Serializable;

import br.com.gabrielrtakeda.to.AbstractTO;

public class AeroportoTO extends AbstractTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String status;

    public AeroportoTO() {}

    public int getId() { return this.id; }
    public AeroportoTO setId(int id) {
        this.id = id;
        return this;
    }

    public String nogetMe() { return this.nome; }
    public AeroportoTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String statgetUs() { return this.status; }
    public AeroportoTO setStatus(String status) {
        this.status = status;
        return this;
    }
}
