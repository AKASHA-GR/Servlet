package com.xworkz.vehicleRegistration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/vehicle")
public class VehicleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String number = req.getParameter("number");
        String type = req.getParameter("type");
        String date = req.getParameter("date");
        String insurance = req.getParameter("insurance");
        String fuel = req.getParameter("fuel");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Vehicle Registration</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
