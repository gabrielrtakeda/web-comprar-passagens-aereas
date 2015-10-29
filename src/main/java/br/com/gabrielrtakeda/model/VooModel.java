package br.com.gabrielrtakeda.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gabrielrtakeda.to.VooTO;
import br.com.gabrielrtakeda.to.AeronaveTO;
import br.com.gabrielrtakeda.to.AeroportoTO;

import br.com.gabrielrtakeda.dao.VooDAOInterface;
import br.com.gabrielrtakeda.dao.AeronaveDAOInterface;
import br.com.gabrielrtakeda.dao.AeroportoDAOInterface;

import br.com.gabrielrtakeda.dao.AbstractDAOFactory;
import br.com.gabrielrtakeda.config.Configuration;
import br.com.gabrielrtakeda.config.DatabaseDriverType;
import br.com.gabrielrtakeda.strategy.DAOStrategy;

public class VooModel {

    VooDAOInterface dao;
    AeronaveDAOInterface aeronaveDAO;
    AeroportoDAOInterface aeroportoDAO;

    public VooModel() throws Exception {
        AbstractDAOFactory factory = DAOStrategy.get();
        dao = factory.getVooDAO();
        aeronaveDAO = factory.getAeronaveDAO();
        aeroportoDAO = factory.getAeroportoDAO();
    }

    public VooTO insert(
        int aeronaveId,
        String codigo,
        String situacao,
        String dataHora,
        String escalas,
        int origem,
        int destino,
        double valor
    ){
        VooTO to = new VooTO();
        AeronaveTO aeronaveTO = new AeronaveTO();
        try {
            aeronaveTO = aeronaveDAO.get(aeronaveId);
            int aeronaveQuantidadeTotalAssentos =
                aeronaveTO.getQuantidadeFileiras() *
                aeronaveTO.getQuantidadeAssentosFileira();

            to = dao.insert(
                aeronaveId,
                codigo,
                origem,
                destino,
                escalas,
                dataHora,
                aeronaveQuantidadeTotalAssentos,
                situacao,
                valor
            );
        }
        catch(Exception e) {
            System.out.println("Erro ao inserir Voo.");
            e.printStackTrace();
        }
        return to;
    }

    public VooTO update(
        int id,
        int aeronaveId,
        String codigo,
        String situacao,
        String datahora,
        String escalas,
        int origemAeroportoId,
        int destinoAeroportoId,
        double valor
    ) {
        VooTO to = new VooTO()
            .setId(id)
            .setAeronave(new AeronaveTO().setId(aeronaveId))
            .setCodigo(codigo)
            .setSituacao(situacao)
            .setDataHora(datahora)
            .setEscalas(escalas)
            .setOrigemAeroporto(new AeroportoTO().setId(origemAeroportoId))
            .setDestinoAeroporto(new AeroportoTO().setId(destinoAeroportoId))
            .setValor(valor);

        try { to = dao.update(to); }
        catch (Exception e) { e.printStackTrace(); }

        return to;
    }

    public ArrayList<VooTO> getListByCodigo(String codigo) {
        ArrayList<VooTO> list = new ArrayList<VooTO>();
        try {
            ArrayList<VooTO> tempList = new ArrayList<VooTO>();
            tempList = dao.getListByCodigo(codigo);

            for (VooTO to : tempList) {
                to.setAeronave(
                    aeronaveDAO.get(
                        to.getAeronave().getId()
                    )
                ).setOrigemAeroporto(
                    aeroportoDAO.get(
                        to.getOrigemAeroporto().getId()
                    )
                ).setDestinoAeroporto(
                    aeroportoDAO.get(
                        to.getDestinoAeroporto().getId()
                    )
                );
                list.add(to);
            }
        }
        catch(Exception e) {
            System.out.println("Erro ao selecionar vôo por código");
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<VooTO> getListDisponivel(
        int quantidadePassageiros,
        int origemAeroportoId,
        int destinoAeroportoId,
        String dataHora
    ) {
        ArrayList<VooTO> list = new ArrayList<VooTO>();
        try {
            list = dao.getListDisponivel(
                quantidadePassageiros,
                origemAeroportoId,
                destinoAeroportoId,
                dataHora
            );
        }
        catch(Exception e) {
            System.out.println("Erro ao selecionar Vôo disponível");
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<VooTO> getListDisponivel(
        int quantidadePassageiros,
        int origemAeroportoId,
        int destinoAeroportoId,
        double valor
    ) {
        ArrayList<VooTO> list = new ArrayList<VooTO>();
        try {
            ArrayList<VooTO> tempList = new ArrayList<VooTO>();
            tempList = dao.getListDisponivel(
                quantidadePassageiros,
                origemAeroportoId,
                destinoAeroportoId,
                valor
            );

            for (VooTO to : tempList) {
                System.out.println("VooModel.getListDisponivel(), valor");
                System.out.println(to.getAeronave().getId());
                to.setAeronave(
                    aeronaveDAO.get(
                        to.getAeronave().getId()
                    )
                ).setOrigemAeroporto(
                    aeroportoDAO.get(
                        to.getOrigemAeroporto().getId()
                    )
                ).setDestinoAeroporto(
                    aeroportoDAO.get(
                        to.getDestinoAeroporto().getId()
                    )
                );
                list.add(to);
            }
        }
        catch(Exception e) {
            System.out.println("Erro ao selecionar Vôo disponível");
            e.printStackTrace();
        }

        return list;
    }

    public VooTO delete(int id) {
        VooTO to = new VooTO().setId(id);
        try { to = dao.delete(to); }
        catch (Exception e) { e.printStackTrace(); }

        return to;
    }
}
