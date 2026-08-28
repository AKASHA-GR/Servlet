package com.xworkz.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profileUpdate")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String updatedName = req.getParameter("name");

        HttpSession session = req.getSession();
        session.setAttribute("NameUpdate",updatedName);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Profile.jsp");
        requestDispatcher.forward(req,resp);
    }
}
