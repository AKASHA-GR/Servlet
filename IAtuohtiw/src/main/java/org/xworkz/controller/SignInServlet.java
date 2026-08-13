package org.xworkz.controller;

import org.xworkz.dto.SignInDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String mobile = req.getParameter("mobile");


        SignInDTO signInDTO = new SignInDTO(name,email,password,mobile);
        System.out.println(name+" "+email+" "+password+" "+mobile);

        req.setAttribute("message","You signIn successfully.");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("signIn.jsp");
        requestDispatcher.forward(req,resp);
    }
}
