package com.example.final_project;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/PhotoServlet")
@MultipartConfig(maxFileSize = 16177215)
public class PhotoServlet extends HttpServlet {
    public PhotoServlet() {
        super();
    }


    protected static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
        String jdbcUsername = "root";
        String jdbcPassword = "Root1234";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static int uploadPhoto(InputStream file) throws SQLException {

        final String SQL_QUERY = "INSERT INTO image (photo) values (?)";
        int row =0;

        Connection connection  = getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SQL_QUERY);

            if (file != null) {
                preparedStatement.setBlob(1, file);
            }
            row = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();

        }

        return row;
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream inputStream = null;
        String message = null;
        Part filePart = request.getPart("photo");
        if (filePart != null) {

             inputStream = filePart.getInputStream();
        }
        int row = 0;
        try {
            row = PhotoServlet.uploadPhoto(inputStream);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (row > 0) {
            message= "File uploaded and saved into database";
        }

    }

}
