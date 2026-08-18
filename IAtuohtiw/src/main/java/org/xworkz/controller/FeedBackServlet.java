package org.xworkz.controller;

import org.xworkz.dto.FeedBackDTO;
import org.xworkz.services.FeedBackService;
import org.xworkz.services.impl.FeedBackServiceImpl;

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
        System.out.println(feedBackDTO);

        FeedBackService feedBackService = new FeedBackServiceImpl();
        boolean isValid = feedBackService.ValidateAndSave(name,email,comment);

        req.setAttribute("message","Thank you for your feedback! We appreciate your input.");




        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Feedback.jsp");
        requestDispatcher.forward(req,resp);
    }
}
