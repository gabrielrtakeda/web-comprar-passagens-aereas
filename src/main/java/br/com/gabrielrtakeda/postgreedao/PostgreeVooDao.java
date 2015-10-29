package br.com.gabrielrtakeda.postgreedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gabrielrtakeda.to.VooTO;
import br.com.gabrielrtakeda.dao.VooDAOInterface;
import br.com.gabrielrtakeda.postgreedao.PostgreeAcessoBD;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public class PostgreeVooDao implements VooDAOInterface {

    Connection conn=null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public PostgreeVooDao() {
        try{
            conn = PostgreeAcessoBD.obtemConexao();
        }
        catch(Exception ex){
            System.out.println("Erro ao setar a string"+ex);
        }
    }

    @Override
    public VooTO insert(
        int aeronaveId,
        String codigo,
        int origem,
        int destino,
        String escalas,
        String dataHora,
        int assentosDisponiveis,
        String situacao,
        double valor
    ) throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public VooTO update(VooTO to)
    throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<VooTO> getAll()
    throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public VooTO get(int id)
    throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<VooTO> getListByCodigo(String codigo)
    throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<VooTO> getListDisponivel(
        int quantidadePassageiros,
        int origemAeroportoId,
        int destinoAeroportoId,
        String dataHora
    ) throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<VooTO> getListDisponivel(
        int quantidadePassageiros,
        int origemAeroportoId,
        int destinoAeroportoId,
        double valor
    ) throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public VooTO delete(VooTO to)
    throws NotFoundException, SQLException {
        return null;
    }

}
