package br.com.gabrielrtakeda.api.beans;

import java.util.List;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.gabrielrtakeda.to.PassageiroTO;

@XmlRootElement
public class ComprarPassagemBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private double valorTotal;
    private List<PassageiroTO> passagens;

    public ComprarPassagemBean() {}

    public double getValorTotal() { return this.valorTotal; }
    public ComprarPassagemBean setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public List<PassageiroTO> getPassageiros() { return this.passagens; }
    public ComprarPassagemBean setPassageiros(List<PassageiroTO> passagens) {
        this.passagens = passagens;
        return this;
    }
}
