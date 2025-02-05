package com.hotel.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final DatabaseConnection instance = new DatabaseConnection();
    private final String username = "postgres";
    private final String password = "2435";
    private final String url = "jdbc:postgresql://localhost:5432/hotel";
    private final String driver = "org.postgresql.Driver";

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }
}
