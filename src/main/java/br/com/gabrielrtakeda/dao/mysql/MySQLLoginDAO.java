package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gabrielrtakeda.to.LoginTO;
import br.com.gabrielrtakeda.dao.LoginDAOInterface;
import br.com.gabrielrtakeda.dao.mysql.MySQLConnection;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;

public class MySQLLoginDAO implements LoginDAOInterface {

    Connection conn = null;

    public MySQLLoginDAO() {}

    public LoginTO select(String usuario, String senha)
    throws NotFoundException, SQLException {
        ResultSet rs = null;
        PreparedStatement pst = null;
        LoginTO to = new LoginTO();
        try {
            conn = MySQLConnection.get();

            StringBuilder builder = new StringBuilder();
            builder
                .append("SELECT * FROM LOGIN")
                .append(" WHERE")
                .append(" usuario='%s'")
                .append(" AND senha='%s'");
            String query = String.format(
                builder.toString(),
                usuario, senha
            );

            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                to.setId(rs.getInt(1));
                to.setUsuario(rs.getString(2));
                to.setSenha(rs.getString(3));
                to.setPerfil(rs.getInt(4));
                to.setStatusOperation(true);
            }
            rs.close();
            pst.close();
        }
        catch(SQLException sqe) {
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




