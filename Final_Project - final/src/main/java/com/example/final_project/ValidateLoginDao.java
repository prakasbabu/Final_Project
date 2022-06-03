package com.example.final_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ValidateLoginDao {

    public ValidateLogin validateLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
        String dbUser = "root";
        String dbPassword = "Root1234";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "select * from loginstorage where email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        ValidateLogin user = null;

        if (result.next()) {
            user = new ValidateLogin();
           user.setEmail(result.getString("email"));
           user.setPassword(result.getString("password"));
        }

        connection.close();
        return user;
    }

}
