package com.example.final_project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/validatelogin")
public class ValidateLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ValidateLoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ValidateLoginDao validateloginDao = new ValidateLoginDao();

        try {
            ValidateLogin user = validateloginDao.validateLogin(email,password);
                      if (user != null && (request.getParameter("first") != null)) {
                 response.sendRedirect("data-form.jsp");
                System.out.println("got the user from db");
            } else if( request.getParameter("second") != null){
                response.sendRedirect("register.jsp");
                System.out.println("take me to create account page");
            }else{
                response.sendRedirect("validatelogin.jsp");
                System.out.println("take me to login page again");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}