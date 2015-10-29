package br.com.gabrielrtakeda.dao;

import br.com.gabrielrtakeda.dao.mysql.MySQLDAOFactory;
import br.com.gabrielrtakeda.dao.AeronaveDAOInterface;
import br.com.gabrielrtakeda.dao.LoginDAOInterface;
import br.com.gabrielrtakeda.dao.VooDAOInterface;
import br.com.gabrielrtakeda.dao.PassagemDAOInterface;
import br.com.gabrielrtakeda.dao.PassageiroDAOInterface;
import br.com.gabrielrtakeda.dao.CartaoCreditoDAOInterface;
import br.com.gabrielrtakeda.dao.CartaoDebitoDAOInterface;
import br.com.gabrielrtakeda.dao.AeroportoDAOInterface;
import br.com.gabrielrtakeda.dao.ReembolsoDAOInterface;

import br.com.gabrielrtakeda.postgreedao.PostgreeDAOFactory;
import br.com.gabrielrtakeda.config.DatabaseDriverType;

public abstract class AbstractDAOFactory {

    public abstract LoginDAOInterface getLoginDAO();
    public abstract AeronaveDAOInterface getAeronaveDAO();
    public abstract VooDAOInterface getVooDAO();
    public abstract PassagemDAOInterface getPassagemDAO();
    public abstract PassageiroDAOInterface getPassageiroDAO();
    public abstract CartaoCreditoDAOInterface getCartaoCreditoDAO();
    public abstract CartaoDebitoDAOInterface getCartaoDebitoDAO();
    public abstract AeroportoDAOInterface getAeroportoDAO();
    public abstract ReembolsoDAOInterface getReembolsoDAO();

    public static AbstractDAOFactory getDAOFactory(DatabaseDriverType driverType) {
        if(driverType == DatabaseDriverType.POSTGRESQL)
            return new PostgreeDAOFactory();
        else
            return new MySQLDAOFactory();
    }
}







