package br.com.gabrielrtakeda.model;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

import br.com.gabrielrtakeda.api.beans.CartaoCreditoBean;
import br.com.gabrielrtakeda.dao.CartaoCreditoDAOInterface;
import br.com.gabrielrtakeda.dao.AbstractDAOFactory;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;
import br.com.gabrielrtakeda.strategy.DAOStrategy;
import br.com.gabrielrtakeda.to.CartaoCreditoTO;

public class CartaoCreditoModel {

    CartaoCreditoDAOInterface dao;

    public CartaoCreditoModel() {
        AbstractDAOFactory factory = DAOStrategy.get();
        dao = factory.getCartaoCreditoDAO();
    }

    public CartaoCreditoTO insert(CartaoCreditoBean cartaoCreditoBean) {
        CartaoCreditoTO cartaoCreditoTO = new CartaoCreditoTO();

        try {
            cartaoCreditoTO = dao.insert(this.toTransferObject(cartaoCreditoBean));
        }
        catch (NotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return cartaoCreditoTO;
    }

    private CartaoCreditoTO toTransferObject(
        CartaoCreditoBean cartaoCreditoBean
    ) {
        return new CartaoCreditoTO()
            .setNomeTitular(cartaoCreditoBean.getNomeTitular())
            .setCpf(cartaoCreditoBean.getCpf())
            .setNumeroCartao(cartaoCreditoBean.getNumeroCartao())
            .setDataVencimentoMes(cartaoCreditoBean.getDataVencimentoMes())
            .setDataVencimentoAno(cartaoCreditoBean.getDataVencimentoAno())
            .setCodigoSeguranca(cartaoCreditoBean.getCodigoSeguranca());
    }
}
