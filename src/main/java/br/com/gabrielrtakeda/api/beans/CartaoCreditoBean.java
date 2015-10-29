package br.com.gabrielrtakeda.api.beans;

import java.util.List;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CartaoCreditoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nomeTitular;
    private String cpf;
    private String numeroCartao;
    private String dataVencimentoMes;
    private String dataVencimentoAno;
    private String codigoSeguranca;

    public CartaoCreditoBean() {}

    public int getId() { return this.id; }
    public CartaoCreditoBean setId(int id) {
        this.id = id;
        return this;
    }

    public String getNomeTitular() { return this.nomeTitular; }
    public CartaoCreditoBean setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
        return this;
    }

    public String getCpf() { return this.cpf; }
    public CartaoCreditoBean setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getNumeroCartao() { return this.numeroCartao; }
    public CartaoCreditoBean setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
        return this;
    }

    public String getDataVencimentoMes() { return this.dataVencimentoMes; }
    public CartaoCreditoBean setDataVencimentoMes(String dataVencimentoMes) {
        this.dataVencimentoMes = dataVencimentoMes;
        return this;
    }

    public String getDataVencimentoAno() { return this.dataVencimentoAno; }
    public CartaoCreditoBean setDataVencimentoAno(String dataVencimentoAno) {
        this.dataVencimentoAno = dataVencimentoAno;
        return this;
    }

    public String getCodigoSeguranca() { return this.codigoSeguranca; }
    public CartaoCreditoBean setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
        return this;
    }

}
