package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gabrielrtakeda.model.Voo;
import br.com.gabrielrtakeda.dao.VooDAOInterface;
import br.com.gabrielrtakeda.to.VooTO;
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
            .setAeronaveId(aeronaveId)
            .setCodigo(codigo)
            .setOrigemAeroportoId(origem)
            .setDestinoAeroportoId(destino)
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
            to.getAeronaveId(),
            to.getCodigo(),
            to.getOrigemAeroportoId(),
            to.getDestinoAeroportoId(),
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
    public VooTO update(
        String id,
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

    public ArrayList<VooTO> getAll()
    throws NotFoundException, SQLException {
        return null;
    }

    public VooTO getById(int id)
    throws NotFoundException, SQLException {
        return null;
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
                    .setAeronaveId(rs.getInt(2))
                    .setCodigo(rs.getString(3))
                    .setOrigemAeroportoId(rs.getInt(4))
                    .setDestinoAeroportoId(rs.getInt(5))
                    .setEscalas(rs.getString(6))
                    .setDataHora(rs.getString(7))
                    .setAssentosDisponiveis(rs.getInt(8))
                    .setSituacao(rs.getString(9))
                    .setValor(rs.getDouble(10))
                    .setAeronaveNome(rs.getString(11))
                    .setOrigemAeroportoNome(rs.getString(12))
                    .setDestinoAeroportoNome(rs.getString(13));
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

    public VooTO delete(String id)
    throws NotFoundException, SQLException {
        return null;
    }

    // @Override
    // public Voo atualizaVoo(
    //     String id,
    //     String codigo,
    //     String origem,
    //     String destino,
    //     int escalas,
    //     String dataHora,
    //     String aeronave,
    //     String situacao
    // ) throws NotFoundException, SQLException {

    //     String query = String.format("UPDATE VOO SET CODIGO =(cod_voo, origem, destino, escalas, data, tipo_aeronave, situacao) VALUES('"+id+"','"+codigo+"' , '"+origem+"' , "+destino+"', '"+escalas+"' , '"+dataHora+"', '"+aeronave+"', '"+situacao+");");
    //     VooTO to = new VooTO();
    //     try{
    //         pst = conn.prepareStatement(query);
    //         pst.execute();
    //     }
    //     catch (SQLException sqe) {
    //         to.setStatusOperation(1);//falha
    //         sqe.printStackTrace();
    //     }
    //     finally {
    //         if (rs != null) {
    //             try {
    //                 rs.close();
    //             } catch (SQLException sqe) {
    //                 sqe.printStackTrace();
    //             }
    //         }
    //         if (pst != null) {
    //             try {
    //                 pst.close();
    //             } catch (SQLException sqe) {
    //                 sqe.printStackTrace();
    //             }
    //         }
    //     }
    //     return null;
    // }

    // @Override
    // public ArrayList<Voo> getVoo() throws NotFoundException, SQLException {
    //     VooTO to = new VooTO();
    //     ArrayList<Voo>lista = new ArrayList<>();
    //     try{

    //         String query = "Select * from voo ";
    //         pst = conn.prepareStatement(query);
    //         rs = pst.executeQuery();
    //         while(rs.next()) {
    //             int id = rs.getInt(1);
    //             String codigo = rs.getString(2);
    //             String origem = rs.getString(3);
    //             String destino = rs.getString(4);
    //             int escalas = rs.getInt(5);
    //             String dataHora = rs.getString(6);
    //             String aeronave = rs.getString(7);
    //             String situacao = rs.getString(8);
    //             Voo voo = new Voo(id , codigo, origem, destino , escalas, dataHora, aeronave, situacao);
    //             lista.add(voo);
    //         }

    //     //to.setStatusOperation(0);//status ok
    //     }
    //     catch (SQLException sqe) {
    //         to.setStatusOperation(1);//falha
    //         sqe.printStackTrace();
    //     }
    //     finally {
    //         if (rs != null) {
    //             try {
    //                 rs.close();
    //             } catch (final SQLException sqe) {
    //                 sqe.printStackTrace();
    //             }
    //         }
    //         if (pst != null) {
    //             try {
    //                 pst.close();
    //             } catch (final SQLException sqe) {
    //                 sqe.printStackTrace();
    //             }
    //         }
    //         to.voo = lista;
    //         return (ArrayList<Voo>) to.voo;

    //     }
    // }

    // @Override
    // public Voo getVooById(int id)
    // throws NotFoundException, SQLException {
    //     return null;
    // }

    // @Override
    // public Voo delVoo(String id)
    // throws NotFoundException, SQLException {
    //     String query = "delete from aeronave where aeronave_id = "+ id + ";";

    //     VooTO to = new VooTO();
    //     try{
    //         pst = conn.prepareStatement(query);
    //         pst.execute();
    //     }
    //     catch (SQLException sqe) {
    //         to.setStatusOperation(1);//falha
    //         sqe.printStackTrace();
    //     }
    //     finally {
    //         if (rs != null) {
    //             try {
    //                 rs.close();
    //             } catch (SQLException sqe) {
    //                 sqe.printStackTrace();
    //             }
    //         }
    //         if (pst != null) {
    //             try {
    //                 pst.close();
    //             } catch (SQLException sqe) {
    //                 sqe.printStackTrace();
    //             }
    //         }
    //     }
    //     return null;
    // }

    // @Override
    // public ArrayList<Voo> getAeronaveByNome()
    // throws NotFoundException, SQLException {
    //     return null;
    // }
}
