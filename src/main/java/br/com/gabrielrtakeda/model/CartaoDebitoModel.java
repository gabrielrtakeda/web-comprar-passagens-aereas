package br.com.gabrielrtakeda.model;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

import br.com.gabrielrtakeda.api.beans.CartaoDebitoBean;
import br.com.gabrielrtakeda.dao.CartaoDebitoDAOInterface;
import br.com.gabrielrtakeda.dao.AbstractDAOFactory;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;
import br.com.gabrielrtakeda.strategy.DAOStrategy;
import br.com.gabrielrtakeda.to.CartaoDebitoTO;

public class CartaoDebitoModel {

    CartaoDebitoDAOInterface dao;

    public CartaoDebitoModel() {
        AbstractDAOFactory factory = DAOStrategy.get();
        dao = factory.getCartaoDebitoDAO();
    }

    public CartaoDebitoTO insert(CartaoDebitoBean cartaoDebitoBean) {
        CartaoDebitoTO cartaoDebitoTO = new CartaoDebitoTO();

        try {
            cartaoDebitoTO = dao.insert(this.toTransferObject(cartaoDebitoBean));
        }
        catch (NotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return cartaoDebitoTO;
    }

    private CartaoDebitoTO toTransferObject(
        CartaoDebitoBean cartaoDebitoBean
    ) {
        return new CartaoDebitoTO()
            .setBanco(cartaoDebitoBean.getBanco())
            .setAgencia(cartaoDebitoBean.getAgencia())
            .setContaCorrente(cartaoDebitoBean.getContaCorrente())
            .setNomeTitular(cartaoDebitoBean.getNomeTitular())
            .setCpf(cartaoDebitoBean.getCpf())
            .setDdd(cartaoDebitoBean.getDdd())
            .setTelefone(cartaoDebitoBean.getTelefone());
    }
}
