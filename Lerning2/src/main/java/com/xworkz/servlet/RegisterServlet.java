package com.xworkz.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String emile = req.getParameter("emile");
        String passsword = req.getParameter("password");

        req.setAttribute("register","you registered successfully.");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Register.jsp");
        requestDispatcher.forward(req,resp);
    }
}
