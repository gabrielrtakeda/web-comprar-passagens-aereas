package br.com.gabrielrtakeda.to;

import java.util.List;
import java.io.Serializable;

import br.com.gabrielrtakeda.to.AbstractTO;

public class CartaoCreditoTO extends AbstractTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nomeTitular;
    private String cpf;
    private String numeroCartao;
    private String dataVencimentoMes;
    private String dataVencimentoAno;
    private String codigoSeguranca;

    public CartaoCreditoTO() {}

    public int getId() { return this.id; }
    public CartaoCreditoTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getNomeTitular() { return this.nomeTitular; }
    public CartaoCreditoTO setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
        return this;
    }

    public String getCpf() { return this.cpf; }
    public CartaoCreditoTO setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getNumeroCartao() { return this.numeroCartao; }
    public CartaoCreditoTO setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
        return this;
    }

    public String getDataVencimentoMes() { return this.dataVencimentoMes; }
    public CartaoCreditoTO setDataVencimentoMes(String dataVencimentoMes) {
        this.dataVencimentoMes = dataVencimentoMes;
        return this;
    }

    public String getDataVencimentoAno() { return this.dataVencimentoAno; }
    public CartaoCreditoTO setDataVencimentoAno(String dataVencimentoAno) {
        this.dataVencimentoAno = dataVencimentoAno;
        return this;
    }

    public String getCodigoSeguranca() { return this.codigoSeguranca; }
    public CartaoCreditoTO setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
        return this;
    }

}
