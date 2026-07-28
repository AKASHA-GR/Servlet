package com.xworkz.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(loadOnStartup = 1, urlPatterns = "/msg")
public class MessageServlet extends GenericServlet{

    public MessageServlet(){
        System.out.println("MessageServlet constructor");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("this is message");

        String name = servletRequest.getParameter("name");
        System.out.println("The name is "+name);

        PrintWriter out =servletResponse.getWriter();
        out.println("The message is printing on the consol.");


    }
}
