package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private String username = "root";
    private String password = "root";
    private String connectionToUrl = "jdbc:mysql://localhost:3306/javamentor";
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(connectionToUrl, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
