package com.xworkz.eventPage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/event")
public class EventServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String organizer = req.getParameter("organizer");
        String date = req.getParameter("date");
        String venue = req.getParameter("venue");
        String capacity = req.getParameter("capacity");
        String fee = req.getParameter("fee");

        StringBuilder errors = new StringBuilder();

        if (name == null || name.trim().isEmpty()) {
            errors.append("Event Name is required.<br>");
        }

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Event Registration</h1>");

    }
}
