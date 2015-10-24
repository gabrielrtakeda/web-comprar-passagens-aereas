package br.com.gabrielrtakeda.dao;

import java.sql.SQLException;

import br.com.gabrielrtakeda.dao.exception.NotFoundException;
import br.com.gabrielrtakeda.to.LoginTO;

public interface LoginDAOInterface {

    public abstract LoginTO select(String usuario, String senha)
        throws NotFoundException, SQLException;
}
