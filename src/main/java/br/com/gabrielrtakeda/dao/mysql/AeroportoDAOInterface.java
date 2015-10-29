package br.com.gabrielrtakeda.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gabrielrtakeda.to.AeroportoTO;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public interface AeroportoDAOInterface {

    public abstract AeroportoTO get(int id)
    throws NotFoundException, SQLException;
}
