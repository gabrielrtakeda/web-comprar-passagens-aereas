package br.com.gabrielrtakeda.dao;

import br.com.gabrielrtakeda.dao.mysql.MySQLDAOFactory;
import br.com.gabrielrtakeda.dao.AeronaveDAOInterface;
import br.com.gabrielrtakeda.dao.LoginDAOInterface;
import br.com.gabrielrtakeda.dao.VooDAOInterface;
import br.com.gabrielrtakeda.postgreedao.PostgreeDAOFactory;
import br.com.gabrielrtakeda.config.DatabaseDriverType;

public abstract class AbstractDAOFactory {

    public abstract LoginDAOInterface getLoginDAO();
    public abstract AeronaveDAOInterface getAeronaveDAO();
    public abstract VooDAOInterface getVooDAO();

    public static AbstractDAOFactory getDAOFactory(DatabaseDriverType driverType) {
        if(driverType == DatabaseDriverType.POSTGRESQL)
            return new PostgreeDAOFactory();
        else
            return new MySQLDAOFactory();
    }
}







