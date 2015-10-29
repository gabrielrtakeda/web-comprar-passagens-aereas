package br.com.gabrielrtakeda.api.beans;

import java.util.List;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.gabrielrtakeda.to.VooTO;

@XmlRootElement
public class ReembolsoBean implements Serializable {

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

    public ReembolsoBean() {}

    public int getId() { return this.id; }
    public ReembolsoBean setId(int id) {
        this.id = id;
        return this;
    }

    public VooTO getVoo() { return this.voo; }
    public ReembolsoBean setVoo(VooTO voo) {
        this.voo = voo;
        return this;
    }

    public double getValor() { return this.valor; }
    public ReembolsoBean setValor(double valor) {
        this.valor = valor;
        return this;
    }

    public String getBanco() { return this.banco; }
    public ReembolsoBean setBanco(String banco) {
        this.banco = banco;
        return this;
    }

    public String getAgencia() { return this.agencia; }
    public ReembolsoBean setAgencia(String agencia) {
        this.agencia = agencia;
        return this;
    }

    public String getContaCorrente() { return this.contaCorrente; }
    public ReembolsoBean setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
        return this;
    }

    public String getNomeTitular() { return this.nomeTitular; }
    public ReembolsoBean setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
        return this;
    }

    public String getCpf() { return this.cpf; }
    public ReembolsoBean setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getDateCreate() { return this.dateCreate; }
    public ReembolsoBean setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }
}
