package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gabrielrtakeda.to.VooTO;
import br.com.gabrielrtakeda.to.AeronaveTO;
import br.com.gabrielrtakeda.to.AeroportoTO;

import br.com.gabrielrtakeda.dao.VooDAOInterface;
import br.com.gabrielrtakeda.dao.mysql.MySQLConnection;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MySQLVooDAO implements VooDAOInterface {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public MySQLVooDAO() {
        try {
            conn = MySQLConnection.get();
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

        VooTO to = new VooTO()
            .setAeronave(new AeronaveTO().setId(aeronaveId))
            .setCodigo(codigo)
            .setOrigemAeroporto(new AeroportoTO().setId(origem))
            .setDestinoAeroporto(new AeroportoTO().setId(destino))
            .setEscalas(escalas)
            .setDataHora(dataHora)
            .setAssentosDisponiveis(assentosDisponiveis)
            .setSituacao(situacao)
            .setValor(valor);

        String query = String.format(
              "INSERT INTO VOO("
            + "     aeronave_id,"
            + "     codigo,"
            + "     origem_aeroporto_id,"
            + "     destino_aeroporto_id,"
            + "     escalas,"
            + "     datahora,"
            + "     assentos_disponiveis,"
            + "     situacao,"
            + "     valor"
            + ") VALUES(%d, '%s', '%s', '%s', '%s', '%s', %d, '%s', %f);",
            to.getAeronave().getId(),
            to.getCodigo(),
            to.getOrigemAeroporto().getId(),
            to.getDestinoAeroporto().getId(),
            to.getEscalas(),
            to.getDataHora(),
            to.getAssentosDisponiveis(),
            to.getSituacao(),
            to.getValor()
        );

        try {
            pst = conn.prepareStatement(query);
            pst.execute();
            to.setStatusOperation(true);
        }
        catch (SQLException sqe) {
            to.setStatusOperation(false);
            sqe.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
        }
        return to;
    }

    @Override
    public VooTO update(VooTO to)
    throws NotFoundException, SQLException {

        String query = String.format(
              " UPDATE VOO SET"
            + "    aeronave_id=%d,"
            + "    codigo='%s',"
            + "    origem_aeroporto_id=%d,"
            + "    destino_aeroporto_id=%d,"
            + "    escalas='%s',"
            + "    datahora='%s',"
            + "    situacao='%s',"
            + "    valor=%f"
            + " WHERE id = %d;",
            to.getAeronave().getId(),
            to.getCodigo(),
            to.getOrigemAeroporto().getId(),
            to.getDestinoAeroporto().getId(),
            to.getEscalas(),
            to.getDataHora(),
            to.getSituacao(),
            to.getValor(),
            to.getId()
        );

        System.out.println(query);
        pst = conn.prepareStatement(query);

        try {
            pst.executeUpdate();
            to.setStatusOperation(true)
                .setSuccessMessage("Vôo atualizado com sucesso!");
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
            to.setStatusOperation(false)
                .setErrorMessage(
                      "Ops! Ocorreu um erro ao atualizar o vôo. Aguarde um"
                    + " momento e tente novamente."
                );
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
        }
        return to;
    }

    public ArrayList<VooTO> getAll()
    throws NotFoundException, SQLException {
        return null;
    }

    public VooTO get(int id)
    throws NotFoundException, SQLException {

        VooTO to = new VooTO();

        String query = String.format(
              " SELECT"
            + "    aeronave_id,"
            + "    codigo,"
            + "    origem_aeroporto_id,"
            + "    destino_aeroporto_id,"
            + "    escalas,"
            + "    datahora,"
            + "    assentos_disponiveis,"
            + "    situacao,"
            + "    valor"
            + " FROM VOO"
            + " WHERE id = %d",
            id
        );

        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();

        try {
            pst = conn.prepareStatement(query);
            pst.execute();

            while(rs.next()) {
                to.setId(id)
                    .setAeronave(new AeronaveTO().setId(rs.getInt(1)))
                    .setCodigo(rs.getString(2))
                    .setOrigemAeroporto(new AeroportoTO().setId(rs.getInt(3)))
                    .setDestinoAeroporto(new AeroportoTO().setId(rs.getInt(4)))
                    .setEscalas(rs.getString(5))
                    .setDataHora(rs.getString(6))
                    .setAssentosDisponiveis(rs.getInt(7))
                    .setSituacao(rs.getString(8))
                    .setValor(rs.getDouble(9));
                to.setStatusOperation(true);
            }
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
            to.setStatusOperation(false);
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
        }
        return to;
    }

    @Override
    public ArrayList<VooTO> getListByCodigo(String codigo)
    throws NotFoundException, SQLException {

        ArrayList<VooTO> list = new ArrayList<VooTO>();

        String query = String.format(
              " SELECT"
            + "    id,"
            + "    aeronave_id,"
            + "    codigo,"
            + "    origem_aeroporto_id,"
            + "    destino_aeroporto_id,"
            + "    escalas,"
            + "    datahora,"
            + "    assentos_disponiveis,"
            + "    situacao,"
            + "    valor"
            + " FROM VOO"
            + " WHERE codigo = '%s'",
            codigo
        );

        System.out.println(query);

        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();


        try {
            pst = conn.prepareStatement(query);
            pst.execute();

            while(rs.next()) {
                VooTO to = new VooTO()
                    .setId(rs.getInt(1))
                    .setAeronave(new AeronaveTO().setId(rs.getInt(2)))
                    .setCodigo(rs.getString(3))
                    .setOrigemAeroporto(new AeroportoTO().setId(rs.getInt(4)))
                    .setDestinoAeroporto(new AeroportoTO().setId(rs.getInt(5)))
                    .setEscalas(rs.getString(6))
                    .setDataHora(rs.getString(7))
                    .setAssentosDisponiveis(rs.getInt(8))
                    .setSituacao(rs.getString(9))
                    .setValor(rs.getDouble(10));
                to.setStatusOperation(true);

                list.add(to);
            }
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
        }
        return list;
    }

    public ArrayList<VooTO> getListDisponivel(
        int quantidadePassageiros,
        int origemAeroportoId,
        int destinoAeroportoId,
        String dataHora
    ) throws NotFoundException, SQLException {

        ArrayList<VooTO> list = new ArrayList<VooTO>();

        String query = String.format(
              " SELECT "
            + "     v.id,"
            + "     v.aeronave_id,"
            + "     v.codigo,"
            + "     v.origem_aeroporto_id,"
            + "     v.destino_aeroporto_id,"
            + "     v.escalas,"
            + "     v.datahora,"
            + "     v.assentos_disponiveis,"
            + "     v.situacao,"
            + "     v.valor,"
            + "     an.nome as 'aeronave_nome',"
            + "     apo.nome as 'origem_aeroporto_nome',"
            + "     apd.nome as 'destino_aeroporto_nome'"
            + " FROM VOO as v"
            + " LEFT JOIN AERONAVE as an"
            + "     ON v.aeronave_id = an.id"
            + " LEFT JOIN AEROPORTO as apd"
            + "     ON v.destino_aeroporto_id = apd.id"
            + " LEFT JOIN AEROPORTO as apo"
            + "     ON v.origem_aeroporto_id = apo.id"
            + " WHERE"
            + "         v.assentos_disponiveis >= %d"
            + "     AND v.origem_aeroporto_id = %d"
            + "     AND v.destino_aeroporto_id = %d"
            + "     AND v.datahora = '%s'"
            + "     AND v.situacao = 'Confirmado';",
            quantidadePassageiros,
            origemAeroportoId,
            destinoAeroportoId,
            dataHora
        );

        System.out.println(query);

        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();


        try {
            pst = conn.prepareStatement(query);
            pst.execute();

            while(rs.next()) {
                VooTO to = new VooTO()
                    .setId(rs.getInt(1))
                    .setAeronave(
                        new AeronaveTO()
                            .setId(rs.getInt(2))
                            .setNome(rs.getString(11))
                    )
                    .setCodigo(rs.getString(3))
                    .setOrigemAeroporto(
                        new AeroportoTO()
                            .setId(rs.getInt(4))
                            .setNome(rs.getString(12))
                    )
                    .setDestinoAeroporto(
                        new AeroportoTO()
                            .setId(rs.getInt(5))
                            .setNome(rs.getString(13))
                    )
                    .setEscalas(rs.getString(6))
                    .setDataHora(rs.getString(7))
                    .setAssentosDisponiveis(rs.getInt(8))
                    .setSituacao(rs.getString(9))
                    .setValor(rs.getDouble(10));
                to.setStatusOperation(true);

                list.add(to);
            }
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
        }
        return list;
    }

    public ArrayList<VooTO> getListDisponivel(
        int quantidadePassageiros,
        int origemAeroportoId,
        int destinoAeroportoId,
        double valor
    ) throws NotFoundException, SQLException {

        ArrayList<VooTO> list = new ArrayList<VooTO>();

        String query = String.format(
              " SELECT"
            + "    id,"
            + "    aeronave_id,"
            + "    codigo,"
            + "    origem_aeroporto_id,"
            + "    destino_aeroporto_id,"
            + "    escalas,"
            + "    datahora,"
            + "    assentos_disponiveis,"
            + "    situacao,"
            + "    valor"
            + " FROM VOO"
            + " WHERE"
            + "        assentos_disponiveis >= %d"
            + "    AND origem_aeroporto_id = %d"
            + "    AND destino_aeroporto_id = %d"
            + "    AND valor = %f"
            + "    AND datahora >= DATE_ADD(NOW(), INTERVAL 2 HOUR);",
            quantidadePassageiros,
            origemAeroportoId,
            destinoAeroportoId,
            valor
        );

        System.out.println(query);

        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();


        try {
            pst = conn.prepareStatement(query);
            pst.execute();

            while(rs.next()) {
                VooTO to = new VooTO()
                    .setId(rs.getInt(1))
                    .setAeronave(new AeronaveTO().setId(rs.getInt(2)))
                    .setCodigo(rs.getString(3))
                    .setOrigemAeroporto(new AeroportoTO().setId(rs.getInt(4)))
                    .setDestinoAeroporto(new AeroportoTO().setId(rs.getInt(5)))
                    .setEscalas(rs.getString(6))
                    .setDataHora(rs.getString(7))
                    .setAssentosDisponiveis(rs.getInt(8))
                    .setSituacao(rs.getString(9))
                    .setValor(rs.getDouble(10));
                to.setStatusOperation(true);

                list.add(to);
            }
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public VooTO delete(VooTO to)
    throws NotFoundException, SQLException {

        String query = String.format(
            "DELETE FROM VOO WHERE id = %d",
            to.getId()
        );
        System.out.println(query);

        try {
            pst = conn.prepareStatement(query);
            pst.execute();
            to.setStatusOperation(true)
                .setSuccessMessage("Vôo deletado com sucesso!");
        }
        catch (SQLException sqe) {
            to.setStatusOperation(false)
                .setErrorMessage(
                      "Ops! Ocorreu um erro ao deletar o vôo. Aguarde um"
                    + " momento e tente novamente."
                );
            sqe.printStackTrace();
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException sqe) {
                    sqe.printStackTrace();
                }
            }
        }
        return to;
    }
}
