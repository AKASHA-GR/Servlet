package org.xworkz.controller;

import org.xworkz.dto.FeedBackDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/feedback")
public class FeedBackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String comment = req.getParameter("comment");

        FeedBackDTO feedBackDTO = new FeedBackDTO(name,email,Long.parseLong(mobile),comment);
        System.out.println(name+" "+email+" "+mobile+" "+comment);

        req.setAttribute("message","Thank you for your feedback, " + name + "! We appreciate your input.");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("feedback.jsp");
        requestDispatcher.forward(req,resp);
    }
}
