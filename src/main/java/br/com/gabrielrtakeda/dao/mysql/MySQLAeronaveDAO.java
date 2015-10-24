package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gabrielrtakeda.model.Aeronave;
import br.com.gabrielrtakeda.model.Voo;
import br.com.gabrielrtakeda.dao.AeronaveDAOInterface;
import br.com.gabrielrtakeda.to.AeronaveTO;
import br.com.gabrielrtakeda.dao.mysql.MySQLConnection;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MySQLAeronaveDAO implements AeronaveDAOInterface {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public MySQLAeronaveDAO() {
        try {
            conn = MySQLConnection.get();
        }
        catch(Exception ex){
            System.out.println("Erro ao setar a string"+ex);
        }
    }

    @Override
    public AeronaveTO insert(
        String codigo,
        String nome,
        int quantidadeFileiras,
        int quantidadeAssentosFileira
    ) throws NotFoundException, SQLException {

        AeronaveTO to = new AeronaveTO(
            codigo,
            nome,
            quantidadeFileiras,
            quantidadeAssentosFileira
        );

        String query = String.format(
              "INSERT INTO AERONAVE("
            + "    codigo,"
            + "    nome,"
            + "    quantidade_fileiras,"
            + "    quantidade_assentos_fileira"
            + ") VALUES ('%s', '%s', %d, %d);",
            to.getCodigo(),
            to.getNome(),
            to.getQuantidadeFileiras(),
            to.getQuantidadeAssentosFileira()
        );

        System.out.println(query);

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
    public AeronaveTO update(
        int id,
        String codigo,
        String nome,
        int quantidadeFileiras,
        int quantidadeAssentosFileira
    ) throws NotFoundException, SQLException {

        AeronaveTO to = new AeronaveTO(
            id,
            codigo,
            nome,
            quantidadeFileiras,
            quantidadeAssentosFileira
        );

        String query = String.format(
              "UPDATE AERONAVE SET"
            + "    codigo='%s',"
            + "    nome='%s',"
            + "    quantidade_fileiras=%d,"
            + "    quantidade_assentos_fileira=%d"
            + " WHERE id = %d;",
            to.getCodigo(),
            to.getNome(),
            to.getQuantidadeFileiras(),
            to.getQuantidadeAssentosFileira(),
            to.getId()
        );
        System.out.println(query);

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
    public ArrayList<AeronaveTO> getAll()
    throws NotFoundException, SQLException {

        ArrayList<AeronaveTO> list = new ArrayList<AeronaveTO>();

        String query = ""
            + " SELECT"
            + "     id,"
            + "     codigo,"
            + "     nome,"
            + "     quantidade_fileiras,"
            + "     quantidade_assentos_fileira"
            + " FROM AERONAVE;";

        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();


        try {
            pst = conn.prepareStatement(query);
            pst.execute();

            while(rs.next()) {
                list.add(
                    new AeronaveTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
                    )
                );
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
    public AeronaveTO get(int id)
    throws NotFoundException, SQLException {

        AeronaveTO to = new AeronaveTO();

        String query = String.format(
              " SELECT"
            + "     id,"
            + "     codigo,"
            + "     nome,"
            + "     quantidade_fileiras,"
            + "     quantidade_assentos_fileira"
            + " FROM AERONAVE"
            + " WHERE id = %d"
            + " ORDER BY id DESC;",
            id
        );

        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();

        try {
            pst = conn.prepareStatement(query);
            pst.execute();

            while(rs.next()) {
                to.setStatusOperation(true);
                to.setId(rs.getInt(1))
                    .setCodigo(rs.getString(2))
                    .setNome(rs.getString(3))
                    .setQuantidadeFileiras(rs.getInt(4))
                    .setQuantidadeAssentosFileira(rs.getInt(5));
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
    public ArrayList<AeronaveTO> getByCodigo(String codigo)
    throws NotFoundException, SQLException {

        ArrayList<AeronaveTO> list = new ArrayList<AeronaveTO>();

        String query = String.format(
              " SELECT"
            + "     id,"
            + "     codigo,"
            + "     nome,"
            + "     quantidade_fileiras,"
            + "     quantidade_assentos_fileira"
            + " FROM AERONAVE"
            + " WHERE CODIGO = '%s'"
            + " ORDER BY id DESC;",
            codigo
        );
        System.out.println(query);

        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();


        try {
            pst = conn.prepareStatement(query);
            pst.execute();

            while(rs.next()) {
                AeronaveTO to = new AeronaveTO()
                    .setId(rs.getInt(1))
                    .setCodigo(rs.getString(2))
                    .setNome(rs.getString(3))
                    .setQuantidadeFileiras(rs.getInt(4))
                    .setQuantidadeAssentosFileira(rs.getInt(5));
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
    public AeronaveTO delete(String id)
    throws NotFoundException, SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    // @Override
    // public Aeronave update(
    //     String id,
    //     String codigo,
    //     String nome,
    //     int quantidadeAssentos
    // ) throws NotFoundException, SQLException, NotFoundException {

    //     String query = "
    //         UPDATE AERONAVE SET
    //             CODIGO='" + codigo + "',
    //             NOME='" + nome + "',
    //             QUANT_PASSAGEIROS=" + quantidadeAssentos + "
    //         WHERE aeronave_id = " + id + ";";
    //     AeronaveTO to = new AeronaveTO();

    //     try {
    //         pst = conn.prepareStatement(query);
    //         pst.execute();
    //     }
    //     catch (SQLException sqe) {
    //         to.setStatusOperacao(1);//falha
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
    // public ArrayList<Aeronave> getAeronave()
    // throws NotFoundException, SQLException, NotFoundException {

    //     AeronaveTO to = new AeronaveTO();
    //     ArrayList<Aeronave>lista = new ArrayList<>();
    //     try{

    //         String query = "Select * from aeronave ";
    //         pst = conn.prepareStatement(query);
    //         rs = pst.executeQuery();
    //         while(rs.next()) {
    //             int id = rs.getInt(1);
    //             String codigos = rs.getString(2);
    //             String nomes = rs.getString(3);
    //             int qa = rs.getInt(4);
    //             Aeronave aero = new Aeronave(id, codigos, nomes, qa);
    //             lista.add(aero);
    //         }
    //     }
    //     catch (SQLException sqe) {
    //         to.setStatusOperacao(1);//falha
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
    //         to.aeronave = lista;
    //         return to.aeronave;
    //     }
    // }

    // @Override
    // public Aeronave getAeronaveById(int id)
    // throws NotFoundException, SQLException, NotFoundException {
    //     return null;
    // }

    // @Override
    // public Aeronave delAeronave(String id)
    // throws NotFoundException, SQLException, NotFoundException {
    //     String query = "delete from aeronave where aeronave_id = "+ id + ";";

    //     AeronaveTO to = new AeronaveTO();
    //     try{
    //         pst = conn.prepareStatement(query);
    //         pst.execute();
    //     }
    //     catch (SQLException sqe) {
    //         to.setStatusOperacao(1);
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
}
