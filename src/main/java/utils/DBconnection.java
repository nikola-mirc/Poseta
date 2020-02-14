package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    private static final String CONNECTION = "jdbc:sqlite:C:/Poseta/database.sqlite";
    Connection connection;

    public DBconnection() {
        try {
            this.connection = DBconnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (this.connection == null) {
            System.exit(1);
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(CONNECTION);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}