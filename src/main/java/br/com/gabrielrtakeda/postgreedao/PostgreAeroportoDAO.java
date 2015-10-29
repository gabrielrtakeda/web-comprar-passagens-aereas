package br.com.gabrielrtakeda.postgreedao;

import java.sql.SQLException;
import java.util.List;

import br.com.gabrielrtakeda.dao.AeroportoDAOInterface;
import br.com.gabrielrtakeda.to.AeroportoTO;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public class PostgreAeroportoDAO implements AeroportoDAOInterface {

    public AeroportoTO get(int id)
    throws NotFoundException, SQLException {
        return null;
    }
}
