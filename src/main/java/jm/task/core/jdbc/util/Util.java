package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String username = "root";
    private static String password = "root";
    private static String connectionToUrl = "jdbc:mysql://localhost:3306/javamentor";
    static Connection connection;

   static {
        try {
            connection = DriverManager.getConnection(connectionToUrl, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
