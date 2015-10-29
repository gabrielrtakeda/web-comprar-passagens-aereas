package br.com.gabrielrtakeda.postgreedao;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.gabrielrtakeda.to.PassagemTO;
import br.com.gabrielrtakeda.to.PassageiroTO;
import br.com.gabrielrtakeda.dao.PassagemDAOInterface;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public class PostgrePassagemDAO implements PassagemDAOInterface  {

    @Override
    public PassagemTO insert(PassagemTO to)
    throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public List<PassagemTO> insertMultiple(
        List<PassagemTO> passagemTOList
    ) throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public PassagemTO get(int id)
    throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public PassagemTO getByBilhete(String bilhete)
    throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public PassagemTO updateVoo(PassagemTO to)
    throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public PassagemTO delete(PassagemTO to)
    throws NotFoundException, SQLException {
        return null;
    }
}
