package org.xworkz.controller;

import org.xworkz.dto.SignUpDTO;
import org.xworkz.services.SignUpService;
import org.xworkz.services.impl.SingUpServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        System.out.println(signUpDTO);

        SignUpService signUpService = new SingUpServiceImpl();
        boolean isValid = signUpService.validateAndSave(signUpDTO);

        req.setAttribute("message","You signUp successfully.");

        HttpSession session = req.getSession();
        session.setAttribute("signup", "i am Akasha,this is SignUp page");

req.setAttribute("Hi","I am AKASHA G R");


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Signup.jsp");
        requestDispatcher.forward(req,resp);
    }
}
