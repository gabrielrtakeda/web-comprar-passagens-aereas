package br.com.gabrielrtakeda.dao;

import java.sql.SQLException;

import br.com.gabrielrtakeda.to.VooTO;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

import java.util.ArrayList;

public interface VooDAOInterface {

    public abstract VooTO insert(
        int aeronaveId,
        String codigo,
        int origem,
        int destino,
        String escalas,
        String dataHora,
        int assentosDisponiveis,
        String situacao,
        double valor
    ) throws NotFoundException, SQLException;

    public abstract VooTO update(VooTO to)
    throws NotFoundException, SQLException;

    public abstract ArrayList<VooTO> getAll()
    throws NotFoundException, SQLException;

    public abstract VooTO get(int id)
    throws NotFoundException, SQLException;

    public abstract ArrayList<VooTO> getListByCodigo(String codigo)
    throws NotFoundException, SQLException;

    public abstract ArrayList<VooTO> getListDisponivel(
        int quantidadePassageiros,
        int origemAeroportoId,
        int destinoAeroportoId,
        String dataHora
    ) throws NotFoundException, SQLException;

    public abstract ArrayList<VooTO> getListDisponivel(
        int quantidadePassageiros,
        int origemAeroportoId,
        int destinoAeroportoId,
        double valor
    ) throws NotFoundException, SQLException;

    public abstract VooTO delete(VooTO to)
    throws NotFoundException, SQLException;
}
