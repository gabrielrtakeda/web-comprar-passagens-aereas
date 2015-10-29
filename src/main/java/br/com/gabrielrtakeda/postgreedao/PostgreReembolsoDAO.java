package br.com.gabrielrtakeda.postgreedao;

import java.sql.SQLException;
import java.util.List;

import br.com.gabrielrtakeda.to.ReembolsoTO;

import br.com.gabrielrtakeda.dao.ReembolsoDAOInterface;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public class PostgreReembolsoDAO implements ReembolsoDAOInterface  {

    @Override
    public ReembolsoTO insert(ReembolsoTO to, double percentage)
    throws NotFoundException, SQLException {
        return null;
    }
}
