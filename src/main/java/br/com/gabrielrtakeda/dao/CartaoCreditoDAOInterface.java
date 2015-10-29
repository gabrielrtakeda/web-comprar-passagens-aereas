package br.com.gabrielrtakeda.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.gabrielrtakeda.to.CartaoCreditoTO;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public interface CartaoCreditoDAOInterface {

    public abstract CartaoCreditoTO insert(CartaoCreditoTO cartaoCreditoTO)
    throws NotFoundException, SQLException;
}


