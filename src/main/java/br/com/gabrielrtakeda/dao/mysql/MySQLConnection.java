package br.com.gabrielrtakeda.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String host = "localhost";
    private static final String port = "3306";
    private static final String database = "projeto";
    private static final String username = "root";
    private static final String password = "root";

    public static Connection get() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(
                String.format(
                    "jdbc:mysql://%s:%s/%s",
                    MySQLConnection.host,
                    MySQLConnection.port,
                    MySQLConnection.database
                ),
                MySQLConnection.username,
                MySQLConnection.password
            );
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
