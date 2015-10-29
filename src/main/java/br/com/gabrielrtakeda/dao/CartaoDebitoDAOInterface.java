package br.com.gabrielrtakeda.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.gabrielrtakeda.to.CartaoDebitoTO;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public interface CartaoDebitoDAOInterface {

    public abstract CartaoDebitoTO insert(CartaoDebitoTO cartaoDebitoTO)
    throws NotFoundException, SQLException;
}
