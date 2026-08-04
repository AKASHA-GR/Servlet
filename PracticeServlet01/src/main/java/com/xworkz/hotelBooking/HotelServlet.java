package com.xworkz.hotelBooking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hotel",loadOnStartup = 1)
public class HotelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String GuestName = req.getParameter("name");
        String CheckInDate = req.getParameter("checkin");
        String CheckOutDate = req.getParameter("checkout");
        String RoomType = req.getParameter("roomtype");
        int Guests = Integer.parseInt(req.getParameter("guests"));
        double Amount = Double.parseDouble(req.getParameter("amount"));

        StringBuilder error = new StringBuilder();
        PrintWriter out = resp.getWriter();

        if(GuestName == null || GuestName.isEmpty()) {
            error.append("Guest Name is required\n");
        }

        if(CheckInDate == null || CheckOutDate == null){
            error.append("Check-in and Check-out dates are required\n");
        }

        if(RoomType == null){
            error.append("The room type is required!\n.");
        }

        if(Guests < 0){
            error.append("Number of guests should be a positive integer\n.");
        }

        if(Amount < 0){
            error.append("Total amount should be a positive number\n.");
        }


        if(error.length() > 0) {
            out.println(error.toString());
        } else {
            out.println("<style>");
            out.println("body {font-family: Arial, sans-serif;}");
            out.println("h1 {color: #007bff;}");
            out.println("h2 {color: #6c757d;}");
            out.println("</style>");
            out.println("<h1>Hotel registered successfully</h1>");
            out.println("<h2>Guest Details</h2>");
            out.println("<ul>");
            out.println("<li><strong>Guest Name:</strong> "+GuestName+"</li>");
            out.println("<li><strong>Check-in Date:</strong> "+CheckInDate+"</li>");
            out.println("<li><strong>Check-out Date:</strong> "+CheckOutDate+"</li>");
            out.println("<li><strong>Room Type:</strong> "+RoomType+"</li>");
            out.println("<li><strong>Number of Guests:</strong> "+Guests+"</li>");
            out.println("<li><strong>Total Amount:</strong> "+Amount+"</li>");
            out.println("</ul>");
            out.println("<a href='hotel.html'>Back to Hotel</a>");
        }
    }
}
