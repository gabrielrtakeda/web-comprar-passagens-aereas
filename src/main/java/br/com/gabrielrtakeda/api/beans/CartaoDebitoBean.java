package br.com.gabrielrtakeda.api.beans;

import java.util.List;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CartaoDebitoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String banco;
    private String agencia;
    private String contaCorrente;
    private String nomeTitular;
    private String cpf;
    private String ddd;
    private String telefone;

    public CartaoDebitoBean() {}

    public int getId() { return this.id; }
    public CartaoDebitoBean setId(int id) {
        this.id = id;
        return this;
    }

    public String getBanco() { return this.banco; }
    public CartaoDebitoBean setBanco(String banco) {
        this.banco = banco;
        return this;
    }

    public String getAgencia() { return this.agencia; }
    public CartaoDebitoBean setAgencia(String agencia) {
        this.agencia = agencia;
        return this;
    }

    public String getContaCorrente() { return this.contaCorrente; }
    public CartaoDebitoBean setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
        return this;
    }

    public String getNomeTitular() { return this.nomeTitular; }
    public CartaoDebitoBean setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
        return this;
    }

    public String getCpf() { return this.cpf; }
    public CartaoDebitoBean setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getDdd() { return this.ddd; }
    public CartaoDebitoBean setDdd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getTelefone() { return this.telefone; }
    public CartaoDebitoBean setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

}
