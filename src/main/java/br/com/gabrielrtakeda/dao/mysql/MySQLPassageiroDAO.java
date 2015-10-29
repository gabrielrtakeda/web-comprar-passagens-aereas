package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.gabrielrtakeda.dao.PassageiroDAOInterface;
import br.com.gabrielrtakeda.to.PassageiroTO;
import br.com.gabrielrtakeda.dao.mysql.MySQLConnection;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MySQLPassageiroDAO implements PassageiroDAOInterface {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public MySQLPassageiroDAO() {
        try {
            conn = MySQLConnection.get();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PassageiroTO insert(PassageiroTO passageiroBean)
    throws NotFoundException, SQLException {

        String query = String.format(
              " INSERT INTO PASSAGEIRO ("
            + "    tipo,"
            + "    forma_tratamento,"
            + "    nome,"
            + "    sobrenome,"
            + "    data_nascimento,"
            + "    email,"
            + "    ddd,"
            + "    telefone_celular"
            + " ) VALUES ('%s', '%s', '%s', '%s', '%s',"
            +   this.notNullField(passageiroBean.getEmail()) + ","
            +   this.notNullField(passageiroBean.getDdd()) + ","
            +   this.notNullField(passageiroBean.getTelefone())
            + ");",
            passageiroBean.getTipoPassageiro(),
            passageiroBean.getFormaTratamento(),
            passageiroBean.getNome(),
            passageiroBean.getSobrenome(),
            passageiroBean.getDataNascimento(),
            passageiroBean.getEmail(),
            passageiroBean.getDdd(),
            passageiroBean.getTelefone()
        );

        System.out.println(query);

        try {
            pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.execute();
            rs = pst.getGeneratedKeys();

            System.out.println("Debug RETURN_GENERATED_KEYS");
            if (rs.next()) {
                System.out.println(rs.getInt(1));
                passageiroBean.setId(rs.getInt(1));
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
        return passageiroBean;
    }

    @Override
    public List<PassageiroTO> insertMultiple(
        List<PassageiroTO> passageiroTOList
    ) throws NotFoundException, SQLException {

        List<PassageiroTO>
            insertedPassageiroTOList = new ArrayList<PassageiroTO>();

        for (PassageiroTO passageiroBean : passageiroTOList) {
            try {
                PassageiroTO
                    insertedPassageiroTO = this.insert(passageiroBean);

                System.out.println("MySQLPassageiroDAO: insertMultiple()");
                System.out.println("insertedPassageiroTO.getId()");
                System.out.println(insertedPassageiroTO.getId());

                insertedPassageiroTOList.add(insertedPassageiroTO);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return insertedPassageiroTOList;
    }

    private String notNullField(String field) {
         return field == null ? "%s" : "'%s'";
    }

    @Override
    public PassageiroTO get(int id)
    throws NotFoundException, SQLException {

        PassageiroTO to = new PassageiroTO();

        String query = String.format(
              " SELECT"
            + "    tipo,"
            + "    forma_tratamento,"
            + "    nome,"
            + "    sobrenome,"
            + "    data_nascimento,"
            + "    email,"
            + "    ddd,"
            + "    telefone_celular"
            + " FROM PASSAGEIRO"
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
                    .setTipoPassageiro(rs.getString(1))
                    .setFormaTratamento(rs.getString(2))
                    .setNome(rs.getString(3))
                    .setSobrenome(rs.getString(4))
                    .setDataNascimento(rs.getString(5))
                    .setEmail(rs.getString(6))
                    .setDdd(rs.getString(7))
                    .setTelefone(rs.getString(8));
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
}
