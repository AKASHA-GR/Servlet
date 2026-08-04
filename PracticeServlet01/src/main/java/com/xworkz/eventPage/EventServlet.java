package com.xworkz.eventPage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet(urlPatterns = "/event",loadOnStartup = 1)
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

        if (organizer == null || organizer.trim().isEmpty()) {
            errors.append("Organizer Name is required.<br>");
        }

        if (date == null || date.trim().isEmpty()) {
            errors.append("Event Date is required.<br>");
        } else if (!isFutureDate(date)) {
            errors.append("Event Date must be in the future.<br>");
        }

        if (venue == null || venue.trim().isEmpty()) {
            errors.append("Venue is required.<br>");
        }

        if (capacity == null || capacity.trim().isEmpty()) {
            errors.append("Capacity is required.<br>");
        } else if (!isPositiveNumber(capacity)) {
            errors.append("Capacity must be a positive number.<br>");
        }

        if (fee == null || fee.trim().isEmpty()) {
            errors.append("Registration Fee is required.<br>");
        } else if (!isPositiveNumber(fee)) {
            errors.append("Registration Fee must be a positive number.<br>");
        }

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Event Registration</h1>");

        if (errors.length() > 0) {
            out.println("<div style='color: red;'>");
            out.println("<h3>Validation Errors:</h3>");
            out.println(errors.toString());
            out.println("</div>");
            out.println("<br><a href='/Event.html'>Go Back</a>");
        } else {
            out.println("<div style='color: green;'>");
            out.println("<h3>Event Registered Successfully!</h3>");
            out.println("<p><strong>Event Name:</strong> " + name + "</p>");
            out.println("<p><strong>Organizer:</strong> " + organizer + "</p>");
            out.println("<p><strong>Event Date:</strong> " + date + "</p>");
            out.println("<p><strong>Venue:</strong> " + venue + "</p>");
            out.println("<p><strong>Capacity:</strong> " + capacity + "</p>");
            out.println("<p><strong>Registration Fee:</strong> " + fee + "</p>");
            out.println("</div>");
            out.println("<br><a href='/Event.html'>Register Another Event</a>");
        }

        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

    private boolean isFutureDate(String dateStr) {
        try {
            LocalDate eventDate = LocalDate.parse(dateStr);
            return eventDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isPositiveNumber(String numberStr) {
        try {
            double number = Double.parseDouble(numberStr);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
