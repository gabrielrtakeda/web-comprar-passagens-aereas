package br.com.gabrielrtakeda.dao.mysql;

import br.com.gabrielrtakeda.dao.AbstractDAOFactory;

import br.com.gabrielrtakeda.dao.LoginDAOInterface;
import br.com.gabrielrtakeda.dao.AeronaveDAOInterface;
import br.com.gabrielrtakeda.dao.VooDAOInterface;
import br.com.gabrielrtakeda.dao.PassagemDAOInterface;
import br.com.gabrielrtakeda.dao.PassageiroDAOInterface;
import br.com.gabrielrtakeda.dao.CartaoCreditoDAOInterface;
import br.com.gabrielrtakeda.dao.CartaoDebitoDAOInterface;
import br.com.gabrielrtakeda.dao.AeroportoDAOInterface;
import br.com.gabrielrtakeda.dao.ReembolsoDAOInterface;

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

    @Override
    public PassagemDAOInterface getPassagemDAO() {
        return new MySQLPassagemDAO();
    }

    @Override
    public PassageiroDAOInterface getPassageiroDAO() {
        return new MySQLPassageiroDAO();
    }

    @Override
    public CartaoCreditoDAOInterface getCartaoCreditoDAO() {
        return new MySQLCartaoCreditoDAO();
    }

    @Override
    public CartaoDebitoDAOInterface getCartaoDebitoDAO() {
        return new MySQLCartaoDebitoDAO();
    }

    @Override
    public AeroportoDAOInterface getAeroportoDAO() {
        return new MySQLAeroportoDAO();
    }

    @Override
    public ReembolsoDAOInterface getReembolsoDAO() {
        return new MySQLReembolsoDAO();
    }
}
