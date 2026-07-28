package com.xworkz.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(loadOnStartup = 1, urlPatterns = "/registration")
public class RegistrationServlet extends GenericServlet {

    public RegistrationServlet() {
        System.out.println("RegistrationServlet constructor");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("this is registration");

        PrintWriter out = res.getWriter();
        out.println("The registration is successful");


    }
}
