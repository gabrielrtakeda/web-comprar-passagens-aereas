package br.com.gabrielrtakeda.to;

import java.io.Serializable;

import br.com.gabrielrtakeda.to.AbstractTO;

public class VooTO extends AbstractTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private AeronaveTO aeronave;
    private String codigo;
    private AeroportoTO origemAeroporto;
    private AeroportoTO destinoAeroporto;
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

    public AeronaveTO getAeronave() { return this.aeronave; }
    public VooTO setAeronave(AeronaveTO aeronave) {
        this.aeronave = aeronave;
        return this;
    }

    public String getCodigo() { return this.codigo; }
    public VooTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public AeroportoTO getOrigemAeroporto() { return this.origemAeroporto; }
    public VooTO setOrigemAeroporto(AeroportoTO origemAeroporto) {
        this.origemAeroporto = origemAeroporto;
        return this;
    }
    public AeroportoTO getDestinoAeroporto() { return this.destinoAeroporto; }
    public VooTO setDestinoAeroporto(AeroportoTO destinoAeroporto) {
        this.destinoAeroporto = destinoAeroporto;
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
