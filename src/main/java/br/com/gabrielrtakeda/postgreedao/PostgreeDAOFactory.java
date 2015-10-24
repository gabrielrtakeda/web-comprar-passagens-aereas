package br.com.gabrielrtakeda.postgreedao;

import br.com.gabrielrtakeda.dao.AeronaveDAOInterface;
import br.com.gabrielrtakeda.dao.AbstractDAOFactory;
import br.com.gabrielrtakeda.dao.LoginDAOInterface;
import br.com.gabrielrtakeda.dao.VooDAOInterface;


public class PostgreeDAOFactory extends AbstractDAOFactory{

    @Override
    public LoginDAOInterface getLoginDAO() {
        return new PostgreeLoginDao();
    }

    public AeronaveDAOInterface getAeronaveDAO(){
        return new PostgreeAeronaveDao();
    }

    @Override
    public VooDAOInterface getVooDAO() {
        return null;
    }
}
