package com.xworkz.travelTripPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/trip", loadOnStartup = 1)
public class TravelTripServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destinationName = req.getParameter("destination_name");
        String travelDate = req.getParameter("travel_date");
        String returnDate = req.getParameter("return_date");
        int travelersCount = Integer.parseInt(req.getParameter("travelers_count"));
        double budget = Double.parseDouble(req.getParameter("budget"));
        String transportMode = req.getParameter("transport_mode");

        StringBuilder error = new StringBuilder();
        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        if(destinationName == null || destinationName.isEmpty()) {
            error.append("Destination name is required\n");
        }

        if(travelDate == null && returnDate == null) {
            error.append("At least one of travel date or return date is required\n");
        }

        if (travelersCount <= 0) {
            error.append("Number of travelers must be a positive integer\n");
        }

        if (budget <= 0) {
            error.append("Budget must be a positive number\n");
        }

        if (transportMode == null || transportMode.isEmpty()) {
            error.append("Transport mode is required\n");
        }

        if(error.length() >0){
            out.println(error.toString());
        }else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Travel Trip Details</title>");
            out.println("<style>");
            out.println("body {font-family: Arial, sans-serif;}");
            out.println("h1 {color: #007bff;}");
            out.println("p {margin-bottom: 0;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Travel Trip Details</h1>");
            out.println("<p><strong>Destination Name:</strong> " + destinationName + "</p>");
            out.println("<p><strong>Travel Date:</strong> " + travelDate + "</p>");
            out.println("<p><strong>Return Date:</strong> " + returnDate + "</p>");
            out.println("<p><strong>Number of Travelers:</strong> " + travelersCount + "</p>");
            out.println("<p><strong>Budget:</strong> " + budget + "</p>");
            out.println("<p><strong>Transport Mode:</strong> " + transportMode + "</p>");
            out.println("</body>");
            out.println("</html>");
        }



    }
}
