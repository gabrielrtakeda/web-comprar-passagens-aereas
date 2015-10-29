package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gabrielrtakeda.to.PassagemTO;
import br.com.gabrielrtakeda.to.PassageiroTO;
import br.com.gabrielrtakeda.dao.PassagemDAOInterface;
import br.com.gabrielrtakeda.dao.mysql.MySQLConnection;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;
import br.com.gabrielrtakeda.to.VooTO;

import java.util.ArrayList;
import java.util.List;

public class MySQLPassagemDAO implements PassagemDAOInterface {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public MySQLPassagemDAO() {
        try {
            conn = MySQLConnection.get();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PassagemTO insert(PassagemTO to)
    throws NotFoundException, SQLException {

        String query = String.format(
              " INSERT INTO PASSAGEM ("
            + "    voo_id,"
            + "    passageiro_responsavel_id,"
            + "    passageiro_id,"
            + "    bilhete,"
            + "    valor"
            + ") VALUES (%d, %d, %d, '%s', %f);",
            to.getVoo().getId(),
            to.getPassageiroResponsavel().getId(),
            to.getPassageiro().getId(),
            to.getBilhete(),
            to.getValor()
        );

        System.out.println(query);

        try {
            pst = conn.prepareStatement(query);
            pst.execute();
            to.setStatusOperation(true);
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

    public List<PassagemTO> insertMultiple(List<PassagemTO> passagemTOList)
    throws NotFoundException, SQLException {
        List<PassagemTO> insertedPassagemTOList = new ArrayList<PassagemTO>();

        System.out.println("MySQLPassagemDAO.insertMultiple()");

        for (PassagemTO to : passagemTOList) {
            try {
                insertedPassagemTOList.add(
                    this.insert(to)
                );
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return insertedPassagemTOList;
    }

    @Override
    public PassagemTO get(int id)
    throws NotFoundException, SQLException {

        PassagemTO to = new PassagemTO();

        String query = String.format(
              " SELECT"
            + "    id,"
            + "    voo_id,"
            + "    passageiro_responsavel_id,"
            + "    passageiro_id,"
            + "    bilhete,"
            + "    valor"
            + " FROM PASSAGEM"
            + " WHERE id = '%d';",
            id
        );

        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();

        try {
            pst = conn.prepareStatement(query);
            pst.execute();

            while(rs.next()) {
                to.setId(rs.getInt(1))
                    .setVoo(new VooTO().setId(rs.getInt(2)))
                    .setPassageiroResponsavel(new PassageiroTO().setId(rs.getInt(3)))
                    .setPassageiro(new PassageiroTO().setId(rs.getInt(4)))
                    .setBilhete(rs.getString(5))
                    .setValor(rs.getDouble(6));
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
    public PassagemTO getByBilhete(String bilhete)
    throws NotFoundException, SQLException {

        PassagemTO to = new PassagemTO();

        String query = String.format(
              " SELECT"
            + "    id,"
            + "    voo_id,"
            + "    passageiro_responsavel_id,"
            + "    passageiro_id,"
            + "    bilhete,"
            + "    valor"
            + " FROM PASSAGEM"
            + " WHERE bilhete = '%s';",
            bilhete
        );
        System.out.println(query);

        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();

        try {
            pst = conn.prepareStatement(query);
            pst.execute();

            int rows = 0;
            while(rs.next()) {
                to.setId(rs.getInt(1))
                    .setVoo(new VooTO().setId(rs.getInt(2)))
                    .setPassageiroResponsavel(new PassageiroTO().setId(rs.getInt(3)))
                    .setPassageiro(new PassageiroTO().setId(rs.getInt(4)))
                    .setBilhete(rs.getString(5))
                    .setValor(rs.getDouble(6));
                to.setStatusOperation(true)
                    .setSuccessMessage("Dados de passagem retornados com sucesso!");
                rows = rs.getRow();
            }
            if (rows == 0)
                to.setStatusOperation(false)
                    .setErrorMessage("Não há nenhuma passagem com este bilhete. /:");
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
            to.setStatusOperation(false)
                .setErrorMessage(
                      "Ops! Ocorreu um erro ao tentar retornar os dados da "
                    + "passagem por bilhete. Aguarde um momento e tente novamente."
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

    public PassagemTO updateVoo(PassagemTO to)
    throws NotFoundException, SQLException {

        String query = String.format(
              " UPDATE PASSAGEM"
            + " SET voo_id=%d"
            + " WHERE id = %d;",
            to.getVoo().getId(),
            to.getId()
        );

        pst = conn.prepareStatement(query);

        try {
            pst.executeUpdate();
            to.setStatusOperation(true);
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
    public PassagemTO delete(PassagemTO to)
    throws NotFoundException, SQLException {

        String query = String.format("DELETE FROM PASSAGEM WHERE id = %d", to.getId());
        System.out.println(query);

        try {
            pst = conn.prepareStatement(query);
            pst.execute();
            to.setStatusOperation(true);
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
            to.setStatusOperation(false)
                .setErrorMessage(
                      "Ops! Ocorreu um erro ao tentar cancelar a passagem."
                    + "Aguarde um momento e tente novamente."
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
}
