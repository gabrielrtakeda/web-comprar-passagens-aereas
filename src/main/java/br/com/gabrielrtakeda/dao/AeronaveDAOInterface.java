package br.com.gabrielrtakeda.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gabrielrtakeda.to.AeronaveTO;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public interface AeronaveDAOInterface {

    public abstract AeronaveTO insert(
        String codigo,
        String nome,
        int quantidadeFileiras,
        int quantidadeAssentosFileira
    ) throws NotFoundException, SQLException;

    public abstract AeronaveTO update(
        int id,
        String codigo,
        String nome,
        int quantidadeFileiras,
        int quantidadeAssentosFileira
    ) throws NotFoundException, SQLException;

    public abstract ArrayList<AeronaveTO> getAll()
    throws NotFoundException, SQLException;

    public abstract AeronaveTO get(int id)
    throws NotFoundException, SQLException;

    public abstract ArrayList<AeronaveTO> getByCodigo(String codigo)
    throws NotFoundException, SQLException;

    public abstract AeronaveTO delete(String id)
    throws NotFoundException, SQLException;
}


