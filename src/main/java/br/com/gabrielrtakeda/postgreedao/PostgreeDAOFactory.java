package br.com.gabrielrtakeda.postgreedao;

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

    @Override
    public PassagemDAOInterface getPassagemDAO() {
        return new PostgrePassagemDAO();
    }

    @Override
    public PassageiroDAOInterface getPassageiroDAO() {
        return new PostgrePassageiroDAO();
    }

    @Override
    public CartaoCreditoDAOInterface getCartaoCreditoDAO() {
        return new PostgreCartaoCreditoDAO();
    }

    @Override
    public CartaoDebitoDAOInterface getCartaoDebitoDAO() {
        return new PostgreCartaoDebitoDAO();
    }

    @Override
    public AeroportoDAOInterface getAeroportoDAO() {
        return new PostgreAeroportoDAO();
    }

    @Override
    public ReembolsoDAOInterface getReembolsoDAO() {
        return new PostgreReembolsoDAO();
    }
}
