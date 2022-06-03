package com.example.final_project;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegisterDao registerDao;

    public void init() {
        registerDao = new RegisterDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String password = request.getParameter("password");
            Register newUser = new Register(email, name, age, password);
            registerDao.insertUser(newUser);
           RequestDispatcher dispatcher = request.getRequestDispatcher("validatelogin.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}

