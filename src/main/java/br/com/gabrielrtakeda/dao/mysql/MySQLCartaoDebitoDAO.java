package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.gabrielrtakeda.to.CartaoDebitoTO;
import br.com.gabrielrtakeda.dao.CartaoDebitoDAOInterface;
import br.com.gabrielrtakeda.dao.mysql.MySQLConnection;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;
import br.com.gabrielrtakeda.to.VooTO;

import java.util.ArrayList;
import java.util.List;

public class MySQLCartaoDebitoDAO implements CartaoDebitoDAOInterface {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public MySQLCartaoDebitoDAO() {
        try { conn = MySQLConnection.get(); }
        catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public CartaoDebitoTO insert(CartaoDebitoTO cartaoDebitoTO)
    throws NotFoundException, SQLException {

        String query = String.format(
              "INSERT INTO Projeto.CARTAO_DEBITO ("
            + "    banco,"
            + "    agencia,"
            + "    conta_corrente,"
            + "    nome_titular,"
            + "    cpf,"
            + "    ddd,"
            + "    telefone"
            + ") VALUES"
            + "('%s', '%s', '%s', '%s', '%s', '%s', '%s');",
            cartaoDebitoTO.getBanco(),
            cartaoDebitoTO.getAgencia(),
            cartaoDebitoTO.getContaCorrente(),
            cartaoDebitoTO.getNomeTitular(),
            cartaoDebitoTO.getCpf(),
            cartaoDebitoTO.getDdd(),
            cartaoDebitoTO.getTelefone()
        );

        System.out.println(query);

        try {
            pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.execute();
            rs = pst.getGeneratedKeys();

            if (rs.next())
                cartaoDebitoTO.setId(rs.getInt(1));

            cartaoDebitoTO.setStatusOperation(true);
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
            cartaoDebitoTO.setStatusOperation(false);
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
        return cartaoDebitoTO;
    }
}
