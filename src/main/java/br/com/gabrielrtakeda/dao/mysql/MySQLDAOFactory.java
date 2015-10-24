package br.com.gabrielrtakeda.dao.mysql;

import br.com.gabrielrtakeda.dao.LoginDAOInterface;
import br.com.gabrielrtakeda.dao.VooDAOInterface;
import br.com.gabrielrtakeda.dao.AeronaveDAOInterface;
import br.com.gabrielrtakeda.dao.AbstractDAOFactory;
import br.com.gabrielrtakeda.dao.mysql.MySQLLoginDAO;
import br.com.gabrielrtakeda.dao.mysql.MySQLAeronaveDAO;
import br.com.gabrielrtakeda.dao.mysql.MySQLVooDAO;

public class MySQLDAOFactory extends AbstractDAOFactory {

    @Override
    public LoginDAOInterface getLoginDAO() {
        return new MySQLLoginDAO();
    }

    @Override
    public AeronaveDAOInterface getAeronaveDAO() {
        return new MySQLAeronaveDAO();
    }

    @Override
    public VooDAOInterface getVooDAO() {
        return new MySQLVooDAO();
    }
}
