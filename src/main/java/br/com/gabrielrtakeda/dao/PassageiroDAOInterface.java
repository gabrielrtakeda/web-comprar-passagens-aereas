package br.com.gabrielrtakeda.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.gabrielrtakeda.to.PassageiroTO;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public interface PassageiroDAOInterface {

    public abstract PassageiroTO insert(PassageiroTO passageiroBean)
    throws NotFoundException, SQLException;

    public abstract List<PassageiroTO> insertMultiple(
        List<PassageiroTO> passageiroTOList
    ) throws NotFoundException, SQLException;

    public abstract PassageiroTO get(int id)
    throws NotFoundException, SQLException;
}


