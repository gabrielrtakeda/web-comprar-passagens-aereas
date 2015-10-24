package br.com.gabrielrtakeda.api.mappers;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PassageiroMapper {
    public boolean responsavel;
    public String tipoPassageiro;
    public String formaTratamento;
    public String nome;
    public String sobrenome;
    public String dataNascimento;
    public String email;
    public String ddd;
    public String telefone;

    public PassageiroMapper(String passageiro) {
        System.out.println(passageiro);
    }
}
