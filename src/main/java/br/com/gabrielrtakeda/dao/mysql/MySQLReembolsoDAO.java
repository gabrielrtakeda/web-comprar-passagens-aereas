package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.gabrielrtakeda.to.ReembolsoTO;

import br.com.gabrielrtakeda.dao.ReembolsoDAOInterface;
import br.com.gabrielrtakeda.dao.mysql.MySQLConnection;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MySQLReembolsoDAO implements ReembolsoDAOInterface {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public MySQLReembolsoDAO() {
        try { conn = MySQLConnection.get(); }
        catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public ReembolsoTO insert(ReembolsoTO to, double percentage)
    throws NotFoundException, SQLException {

        String query = String.format(
              "INSERT INTO Projeto.REEMBOLSO ("
            + "    voo_id,"
            + "    valor,"
            + "    banco,"
            + "    agencia,"
            + "    conta_corrente,"
            + "    nome_titular,"
            + "    cpf"
            + ") VALUES (%d, %f, '%s', '%s', '%s', '%s', '%s');",
            to.getVoo().getId(),
            to.getValor() * percentage,
            to.getBanco(),
            to.getAgencia(),
            to.getContaCorrente(),
            to.getNomeTitular(),
            to.getCpf()
        );
        System.out.println(query);

        try {
            pst = conn.prepareStatement(query);
            pst.execute();
            to.setStatusOperation(true)
                .setSuccessMessage(
                    String.format(
                        "Reembolso inserido com %s%% do valor pago.",
                        (percentage * 100))
                );
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
            to.setStatusOperation(false)
                .setErrorMessage(
                      "Ops! Ocorreu um erro ao tentar inserir o reembolso."
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
