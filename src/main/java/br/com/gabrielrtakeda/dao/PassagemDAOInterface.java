package br.com.gabrielrtakeda.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.gabrielrtakeda.to.PassagemTO;
import br.com.gabrielrtakeda.to.PassageiroTO;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public interface PassagemDAOInterface {

    public abstract PassagemTO insert(PassagemTO to)
    throws NotFoundException, SQLException;

    public abstract List<PassagemTO> insertMultiple(
        List<PassagemTO> passagemTOList
    ) throws NotFoundException, SQLException;

    public abstract PassagemTO get(int id)
    throws NotFoundException, SQLException;

    public abstract PassagemTO getByBilhete(String bilhete)
    throws NotFoundException, SQLException;

    public abstract PassagemTO updateVoo(PassagemTO to)
    throws NotFoundException, SQLException;

    public abstract PassagemTO delete(PassagemTO to)
    throws NotFoundException, SQLException;
}
