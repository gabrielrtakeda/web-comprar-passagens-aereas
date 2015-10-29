package br.com.gabrielrtakeda.to;

import java.util.List;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.gabrielrtakeda.to.AbstractTO;
import br.com.gabrielrtakeda.to.VooTO;
import br.com.gabrielrtakeda.to.PassageiroTO;

@XmlRootElement
public class PassagemTO extends AbstractTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private VooTO voo;
    private PassageiroTO passageiroResponsavel;
    private PassageiroTO passageiro;
    private String bilhete;
    private double valor;

    public PassagemTO() {}

    public int getId() { return this.id; }
    public PassagemTO setId(int id) {
        this.id = id;
        return this;
    }

    public VooTO getVoo() { return this.voo; }
    public PassagemTO setVoo(VooTO voo) {
        this.voo = voo;
        return this;
    }

    public PassageiroTO getPassageiroResponsavel() {
        return this.passageiroResponsavel;
    }
    public PassagemTO setPassageiroResponsavel(
        PassageiroTO passageiroResponsavel
    ) {
        this.passageiroResponsavel = passageiroResponsavel;
        return this;
    }

    public PassageiroTO getPassageiro() { return this.passageiro; }
    public PassagemTO setPassageiro(PassageiroTO passageiro) {
        this.passageiro = passageiro;
        return this;
    }

    public String getBilhete() { return this.bilhete; }
    public PassagemTO setBilhete(String bilhete) {
        this.bilhete = bilhete;
        return this;
    }

    public double getValor() { return this.valor; }
    public PassagemTO setValor(double valor) {
        this.valor = valor;
        return this;
    }
}
