package br.com.gabrielrtakeda.to;

import java.util.List;
import java.io.Serializable;

import br.com.gabrielrtakeda.to.AbstractTO;

public class CartaoDebitoTO extends AbstractTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String banco;
    private String agencia;
    private String contaCorrente;
    private String nomeTitular;
    private String cpf;
    private String ddd;
    private String telefone;

    public CartaoDebitoTO() {}

    public int getId() { return this.id; }
    public CartaoDebitoTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getBanco() { return this.banco; }
    public CartaoDebitoTO setBanco(String banco) {
        this.banco = banco;
        return this;
    }

    public String getAgencia() { return this.agencia; }
    public CartaoDebitoTO setAgencia(String agencia) {
        this.agencia = agencia;
        return this;
    }

    public String getContaCorrente() { return this.contaCorrente; }
    public CartaoDebitoTO setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
        return this;
    }

    public String getNomeTitular() { return this.nomeTitular; }
    public CartaoDebitoTO setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
        return this;
    }

    public String getCpf() { return this.cpf; }
    public CartaoDebitoTO setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getDdd() { return this.ddd; }
    public CartaoDebitoTO setDdd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getTelefone() { return this.telefone; }
    public CartaoDebitoTO setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

}
