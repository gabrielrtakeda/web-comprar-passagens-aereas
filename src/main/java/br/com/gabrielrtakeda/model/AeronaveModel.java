package br.com.gabrielrtakeda.model;

import java.util.ArrayList;

import br.com.gabrielrtakeda.dao.AbstractDAOFactory;
import br.com.gabrielrtakeda.to.AeronaveTO;
import br.com.gabrielrtakeda.dao.AeronaveDAOInterface;
import br.com.gabrielrtakeda.strategy.DAOStrategy;

public class AeronaveModel {

    AeronaveDAOInterface dao;
    String errorMessage;

    public AeronaveModel() {
        AbstractDAOFactory factory = DAOStrategy.get();
        dao = factory.getAeronaveDAO();
    }

    public AeronaveTO insert(
        String codigo,
        String nome,
        int quantidadeFileiras,
        int quantidadeAssentosFileira
    ) {
        AeronaveTO to = new AeronaveTO();
        try {
            to = dao.insert(
                codigo,
                nome,
                quantidadeFileiras,
                quantidadeAssentosFileira
            );
        }
        catch(Exception ex) {
            System.out.println("Erro ao inserir aeronave");
        }

        return to;
    }

    public ArrayList<AeronaveTO> selectByCodigo(String codigo) {
        ArrayList<AeronaveTO> list = new ArrayList<AeronaveTO>();
        try {
            list = dao.getByCodigo(codigo);
        }
        catch(Exception ex) {
            System.out.println("Erro ao selecionar aeronave por código");
        }

        return list;
    }

    public AeronaveTO update(
        int id,
        String codigo,
        String nome,
        int quantidadeFileiras,
        int quantidadeAssentosFileira
    ) {
        AeronaveTO to = new AeronaveTO();
        try {
            to = dao.update(
                id,
                codigo,
                nome,
                quantidadeFileiras,
                quantidadeAssentosFileira
            );
        }
        catch(Exception ex) {
            System.out.println("Erro ao atualizar aeronave");
        }

        return to;
    }

    public AeronaveTO delete(int id) {
        AeronaveTO to = new AeronaveTO();
        try { to = dao.delete(id); }
        catch (Exception e) { e.printStackTrace(); }
        return to;
    }
}
