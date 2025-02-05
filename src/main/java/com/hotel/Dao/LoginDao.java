package com.hotel.Dao;

import com.hotel.config.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public Integer login(String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "select * from customers where email=? and password=?";

        PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }

        throw new RuntimeException();
    }
}
