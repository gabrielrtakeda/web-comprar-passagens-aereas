package br.com.gabrielrtakeda.to;

import java.io.Serializable;

import br.com.gabrielrtakeda.to.AbstractTO;
import br.com.gabrielrtakeda.model.Voo;

public class VooTO extends AbstractTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int aeronaveId;
    private String aeronaveNome;
    private String codigo;
    private int origemAeroportoId;
    private String origemAeroportoNome;
    private int destinoAeroportoId;
    private String destinoAeroportoNome;
    private String escalas;
    private String dataHora;
    private int assentosDisponiveis;
    private String situacao;
    private double valor;

    public VooTO() {}

    public int getId() { return this.id; }
    public VooTO setId(int id) {
        this.id = id;
        return this;
    }

    public int getAeronaveId() { return this.aeronaveId; }
    public VooTO setAeronaveId(int aeronaveId) {
        this.aeronaveId = aeronaveId;
        return this;
    }

    public String getAeronaveNome() { return this.aeronaveNome; }
    public VooTO setAeronaveNome(String aeronaveNome) {
        this.aeronaveNome = aeronaveNome;
        return this;
    }

    public String getCodigo() { return this.codigo; }
    public VooTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public int getOrigemAeroportoId() { return this.origemAeroportoId; }
    public VooTO setOrigemAeroportoId(int origemAeroportoId) {
        this.origemAeroportoId = origemAeroportoId;
        return this;
    }

    public String getOrigemAeroportoNome() { return this.origemAeroportoNome; }
    public VooTO setOrigemAeroportoNome(String origemAeroportoNome) {
        this.origemAeroportoNome = origemAeroportoNome;
        return this;
    }

    public int getDestinoAeroportoId() { return this.destinoAeroportoId; }
    public VooTO setDestinoAeroportoId(int destinoAeroportoId) {
        this.destinoAeroportoId = destinoAeroportoId;
        return this;
    }

    public String getDestinoAeroportoNome() { return this.destinoAeroportoNome; }
    public VooTO setDestinoAeroportoNome(String destinoAeroportoNome) {
        this.destinoAeroportoNome = destinoAeroportoNome;
        return this;
    }

    public String getEscalas() { return this.escalas; }
    public VooTO setEscalas(String escalas) {
        this.escalas = escalas;
        return this;
    }

    public String getDataHora() { return this.dataHora; }
    public VooTO setDataHora(String dataHora) {
        this.dataHora = dataHora;
        return this;
    }

    public int getAssentosDisponiveis() { return this.assentosDisponiveis; }
    public VooTO setAssentosDisponiveis(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
        return this;
    }

    public String getSituacao() { return this.situacao; }
    public VooTO setSituacao(String situacao) {
        this.situacao = situacao;
        return this;
    }

    public double getValor() { return this.valor; }
    public VooTO setValor(double valor) {
        this.valor = valor;
        return this;
    }
}
