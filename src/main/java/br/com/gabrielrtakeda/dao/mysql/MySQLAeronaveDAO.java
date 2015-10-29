package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            to.setStatusOperation(true)
                .setSuccessMessage("Aeronave alterada com sucesso!");
        }
        catch (SQLException sqe) {
            to.setStatusOperation(false)
                .setErrorMessage(
                      "Ops! Ocorreu um erro ao tentar atualizar a aeronave."
                    + " Aguarde um momento e tente novamente."
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
        System.out.println("AeronaveDAO.get()");
        System.out.println(id);

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
                to.setId(rs.getInt(1))
                    .setCodigo(rs.getString(2))
                    .setNome(rs.getString(3))
                    .setQuantidadeFileiras(rs.getInt(4))
                    .setQuantidadeAssentosFileira(rs.getInt(5));
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
    public AeronaveTO delete(int id)
    throws NotFoundException, SQLException {

        AeronaveTO to = new AeronaveTO();
        String query = String.format("DELETE FROM AERONAVE WHERE id = %d", id);
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
}
