package br.com.gabrielrtakeda.to;

import java.io.Serializable;
import br.com.gabrielrtakeda.to.AbstractTO;

public class AeronaveTO extends AbstractTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String codigo;
    private String nome;
    private int quantidadeFileiras;
    private int quantidadeAssentosFileira;

    public AeronaveTO() {}

    public AeronaveTO(
        String codigo,
        String nome,
        int quantidadeFileiras,
        int quantidadeAssentosFileira
    ) {
        this.setCodigo(codigo)
            .setNome(nome)
            .setQuantidadeFileiras(quantidadeFileiras)
            .setQuantidadeAssentosFileira(quantidadeAssentosFileira);
    }

    public AeronaveTO(
        int id,
        String codigo,
        String nome,
        int quantidadeFileiras,
        int quantidadeAssentosFileira
    ) {
        this.setId(id)
            .setCodigo(codigo)
            .setNome(nome)
            .setQuantidadeFileiras(quantidadeFileiras)
            .setQuantidadeAssentosFileira(quantidadeAssentosFileira);
    }

    public int getId() { return this.id; }
    public AeronaveTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getCodigo() { return this.codigo; }
    public AeronaveTO setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getNome() { return this.nome; }
    public AeronaveTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public int getQuantidadeFileiras() { return this.quantidadeFileiras; }
    public AeronaveTO setQuantidadeFileiras(int quantidadeFileiras) {
        this.quantidadeFileiras = quantidadeFileiras;
        return this;
    }

    public int getQuantidadeAssentosFileira() { return this.quantidadeAssentosFileira; }
    public AeronaveTO setQuantidadeAssentosFileira(int quantidadeAssentosFileira) {
        this.quantidadeAssentosFileira = quantidadeAssentosFileira;
        return this;
    }
}
