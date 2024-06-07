package org.example.weather._core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getInstance() {
        String username = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/weatherdb"; // database의 이름을 넣는다.

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
