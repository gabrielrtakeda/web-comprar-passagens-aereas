package br.com.gabrielrtakeda.to;

import java.io.Serializable;

import br.com.gabrielrtakeda.to.AbstractTO;
import br.com.gabrielrtakeda.to.VooTO;

public class ReembolsoTO extends AbstractTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private VooTO voo;
    private double valor;
    private String banco;
    private String agencia;
    private String contaCorrente;
    private String nomeTitular;
    private String cpf;
    private String dateCreate;

    public ReembolsoTO() {}

    public int getId() { return this.id; }
    public ReembolsoTO setId(int id) {
        this.id = id;
        return this;
    }

    public VooTO getVoo() { return this.voo; }
    public ReembolsoTO setVoo(VooTO voo) {
        this.voo = voo;
        return this;
    }

    public double getValor() { return this.valor; }
    public ReembolsoTO setValor(double valor) {
        this.valor = valor;
        return this;
    }

    public String getBanco() { return this.banco; }
    public ReembolsoTO setBanco(String banco) {
        this.banco = banco;
        return this;
    }

    public String getAgencia() { return this.agencia; }
    public ReembolsoTO setAgencia(String agencia) {
        this.agencia = agencia;
        return this;
    }

    public String getContaCorrente() { return this.contaCorrente; }
    public ReembolsoTO setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
        return this;
    }

    public String getNomeTitular() { return this.nomeTitular; }
    public ReembolsoTO setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
        return this;
    }

    public String getCpf() { return this.cpf; }
    public ReembolsoTO setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getDateCreate() { return this.dateCreate; }
    public ReembolsoTO setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }
}
