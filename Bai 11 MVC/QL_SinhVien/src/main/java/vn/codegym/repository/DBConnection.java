package vn.codegym.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";
    private static final String HOST = "localhost";
    private static final String DATABASE = "c11_student";
    private static final String PORT = "3306";

    private static Connection connection;
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE,USER_NAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
