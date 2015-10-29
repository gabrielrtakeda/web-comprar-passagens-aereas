package br.com.gabrielrtakeda.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.gabrielrtakeda.to.ReembolsoTO;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public interface ReembolsoDAOInterface {

    public abstract ReembolsoTO insert(ReembolsoTO to, double percentage)
    throws NotFoundException, SQLException;
}
