package br.com.gabrielrtakeda.to;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.gabrielrtakeda.to.AbstractTO;
import br.com.gabrielrtakeda.to.VooTO;

@XmlRootElement
public class PassageiroTO extends AbstractTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private VooTO voo;
    private boolean responsavel;
    private double valorPassagem;
    private String tipoPassageiro;
    private String formaTratamento;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String email;
    private String ddd;
    private String telefone;

    public PassageiroTO() {}

    public int getId() { return this.id; }
    public PassageiroTO setId(int id) {
        this.id = id;
        return this;
    }

    public VooTO getVoo() { return this.voo; }
    public PassageiroTO setVoo(VooTO voo) {
        this.voo = voo;
        return this;
    }

    public boolean getResponsavel() { return this.responsavel; }
    public PassageiroTO setResponsavel(boolean responsavel) {
        this.responsavel = responsavel;
        return this;
    }

    public double getValorPassagem() { return this.valorPassagem; }
    public PassageiroTO setValorPassagem(double valorPassagem) {
        this.valorPassagem = valorPassagem;
        return this;
    }

    public String getTipoPassageiro() { return this.tipoPassageiro; }
    public PassageiroTO setTipoPassageiro(String tipoPassageiro) {
        this.tipoPassageiro = tipoPassageiro;
        return this;
    }

    public String getFormaTratamento() { return this.formaTratamento; }
    public PassageiroTO setFormaTratamento(String formaTratamento) {
        this.formaTratamento = formaTratamento;
        return this;
    }

    public String getNome() { return this.nome; }
    public PassageiroTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() { return this.sobrenome; }
    public PassageiroTO setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public String getDataNascimento() { return this.dataNascimento; }
    public PassageiroTO setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getEmail() { return this.email; }
    public PassageiroTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDdd() { return this.ddd; }
    public PassageiroTO setDdd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getTelefone() { return this.telefone; }
    public PassageiroTO setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }
}
