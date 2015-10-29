package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.gabrielrtakeda.to.CartaoCreditoTO;
import br.com.gabrielrtakeda.dao.CartaoCreditoDAOInterface;
import br.com.gabrielrtakeda.dao.mysql.MySQLConnection;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;
import br.com.gabrielrtakeda.to.VooTO;

import java.util.ArrayList;
import java.util.List;

public class MySQLCartaoCreditoDAO implements CartaoCreditoDAOInterface {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public MySQLCartaoCreditoDAO() {
        try { conn = MySQLConnection.get(); }
        catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public CartaoCreditoTO insert(CartaoCreditoTO cartaoCreditoTO)
    throws NotFoundException, SQLException {

        String query = String.format(
              "INSERT INTO Projeto.CARTAO_CREDITO ("
            + "    nome_titular,"
            + "    cpf,"
            + "    numero_cartao,"
            + "    data_vencimento_mes,"
            + "    data_vencimento_ano,"
            + "    codigo_seguranca"
            + ") VALUES"
            + "('%s', '%s', '%s', '%s', '%s', '%s');",
            cartaoCreditoTO.getNomeTitular(),
            cartaoCreditoTO.getCpf(),
            cartaoCreditoTO.getNumeroCartao(),
            cartaoCreditoTO.getDataVencimentoMes(),
            cartaoCreditoTO.getDataVencimentoAno(),
            cartaoCreditoTO.getCodigoSeguranca()
        );

        System.out.println(query);

        try {
            pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.execute();
            rs = pst.getGeneratedKeys();

            if (rs.next())
                cartaoCreditoTO.setId(rs.getInt(1));

            cartaoCreditoTO.setStatusOperation(true);
        }
        catch (SQLException sqe) {
            sqe.printStackTrace();
            cartaoCreditoTO.setStatusOperation(false);
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
        return cartaoCreditoTO;
    }
}
