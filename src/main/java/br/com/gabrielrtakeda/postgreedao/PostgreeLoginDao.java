package br.com.gabrielrtakeda.postgreedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.gabrielrtakeda.to.LoginTO;
import br.com.gabrielrtakeda.dao.LoginDAOInterface;

public class PostgreeLoginDao implements LoginDAOInterface {

    public  PostgreeLoginDao() {
                // TODO Auto-generated constructor stub
    }
    Connection conn=null;
    public LoginTO select(String nome, String senha){
        ResultSet rs = null;
        PreparedStatement pst = null;
        LoginTO to = new LoginTO();

        try {
            conn = PostgreeAcessoBD.obtemConexao();
            if(conn != null){
                String query = "select perfil from login where usuario = '"+nome+"'and senha ='"+senha+"'";
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
                while (rs.next()) {
                    to.setPerfil(rs.getInt(1));
                }
                rs.close();
                pst.close();
            }
            return to;
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
        return null;
    }
}








