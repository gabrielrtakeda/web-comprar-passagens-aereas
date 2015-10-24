package br.com.gabrielrtakeda.postgreedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreeAcessoBD {
	public static Connection obtemConexao() throws SQLException {
        	try {
				Class.forName("org.postgresql.Driver");
				return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto","root","root");
			}
    		catch (ClassNotFoundException e) {
				e.printStackTrace();
			   return null;
        }
        }
	}




