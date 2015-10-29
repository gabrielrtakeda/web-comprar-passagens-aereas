package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gabrielrtakeda.to.AeroportoTO;

import br.com.gabrielrtakeda.dao.AeroportoDAOInterface;
import br.com.gabrielrtakeda.dao.mysql.MySQLConnection;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MySQLAeroportoDAO implements AeroportoDAOInterface {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public MySQLAeroportoDAO() {
        try { conn = MySQLConnection.get(); }
        catch (Exception e) { e.printStackTrace(); }
    }

    public AeroportoTO get(int id)
    throws NotFoundException, SQLException {

        AeroportoTO to = new AeroportoTO();

        String query = String.format(
              " SELECT"
            + "    nome,"
            + "    status"
            + " FROM AEROPORTO"
            + " WHERE id = %d",
            id
        );

        pst = conn.prepareStatement(query);
        rs = pst.executeQuery();

        System.out.println(query);

        try {
            pst = conn.prepareStatement(query);
            pst.execute();

            while(rs.next()) {
                to.setId(id)
                    .setNome(rs.getString(1))
                    .setStatus(rs.getString(2));
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
