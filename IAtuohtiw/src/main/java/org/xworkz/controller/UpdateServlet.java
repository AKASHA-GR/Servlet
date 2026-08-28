package org.xworkz.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("name");
        String email = req.getParameter("email");

        HttpSession session = req.getSession();
        session.setAttribute("name", userName);
        session.setAttribute("email", email);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Update.jsp");
        requestDispatcher.forward(req, resp);
    }
}
