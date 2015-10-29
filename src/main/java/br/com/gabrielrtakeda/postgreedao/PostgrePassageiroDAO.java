package br.com.gabrielrtakeda.postgreedao;

import java.sql.SQLException;
import java.util.List;

import br.com.gabrielrtakeda.dao.PassageiroDAOInterface;
import br.com.gabrielrtakeda.to.PassageiroTO;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public class PostgrePassageiroDAO implements PassageiroDAOInterface  {

    @Override
    public PassageiroTO insert(PassageiroTO passageiroBean)
    throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public List<PassageiroTO> insertMultiple(
        List<PassageiroTO> passageiroTOList
    ) throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public PassageiroTO get(int id)
    throws NotFoundException, SQLException {
        return null;
    }

    // @Override
    // public AeronaveTO update(
    //     int id,
    //     String codigo,
    //     String nome,
    //     int quantidadeFileiras,
    //     int quantidadeAssentosFileira
    // ) throws NotFoundException, SQLException {
    //     return null;
    // }

    // @Override
    // public ArrayList<AeronaveTO> getAll()
    // throws NotFoundException, SQLException {
    //     return null;
    // }

    // @Override
    // public AeronaveTO get(int id)
    // throws NotFoundException, SQLException {
    //     return null;
    // }

    // @Override
    // public ArrayList<AeronaveTO> getByCodigo(String codigo)
    // throws NotFoundException, SQLException {
    //     return null;
    // }

    // @Override
    // public AeronaveTO delete(String id)
    // throws NotFoundException, SQLException {
    //     return null;
    // }

}
