package org.xworkz.controller;

import org.xworkz.dto.SignUpDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("userid");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String conformPasswoed = req.getParameter("confirmPassword");

        SignUpDTO signUpDTO = new SignUpDTO(user,email,password,conformPasswoed);
        System.out.println(user+" "+email+" "+password+" "+conformPasswoed);

        req.setAttribute("message","You signUp successfully.");


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("signup.jsp");
        requestDispatcher.forward(req,resp);
    }
}
