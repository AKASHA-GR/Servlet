package com.xworkz.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(loadOnStartup = 1, urlPatterns = "/login")
public class LoginServlet extends GenericServlet {

    public LoginServlet() {
        System.out.println("LoginServlet constructor");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        System.out.println("this is login");

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        System.out.println("name = "+name);
        System.out.println("password = "+password);

        PrintWriter out = res.getWriter();
        out.println("The name is = "+name);
        out.println("This is login page and you have logged in successfully");

    }
}
