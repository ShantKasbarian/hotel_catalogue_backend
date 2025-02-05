package com.hotel.Dao;

import com.hotel.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class RegisterDao {
    public void register(String name, String lastname, String password, String email, String phone) throws SQLException, ClassNotFoundException {
        if (
                name == null ||
                lastname == null ||
                password == null ||
                email == null ||
                phone == null
        ) {
            throw new RuntimeException("name, lastname, password, email, phone must be specified");
        }

        if (!isPasswordValid(password)) {
            throw new RuntimeException("password must contain at least 1 uppercase, 1 lowercase letter, 1 number, 1 special character");
        }

        if (!isEmailValid(email)) {
            throw new RuntimeException("email is not valid");
        }

        String sql = "insert into customers (name, lastname, email, phone) values(?,?,?,?)";

        Connection connection = DatabaseConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, lastname);
        statement.setString(3, email);
        statement.setString(4, phone);

        statement.executeUpdate();

    }

    private boolean isPasswordValid(String password) {
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern numberPattern = Pattern.compile("[0-9]");
        Pattern symbolPattern = Pattern.compile(".*[!@#$%^&*()_+].*");

        return lowerCasePattern.matcher(password).find() &&
                upperCasePattern.matcher(password).find() &&
                numberPattern.matcher(password).find() &&
                symbolPattern.matcher(password).find();

    }

    private boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

        return pattern.matcher(email).find();
    }
}
