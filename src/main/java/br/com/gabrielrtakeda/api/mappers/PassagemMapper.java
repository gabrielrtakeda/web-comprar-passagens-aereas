package br.com.gabrielrtakeda.api.mappers;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.gabrielrtakeda.api.mappers.PassageiroMapper;

@XmlRootElement
public class PassagemMapper {
    public String vooId;
    public List<PassageiroMapper> passageiros;

    public PassagemMapper(String passagem) {
        System.out.println(passagem);
    }
}
