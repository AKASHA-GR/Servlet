package com.xworkz.vehicleRegistration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/vehicle",loadOnStartup = 1)
public class VehicleServlet extends HttpServlet {
    
    private static final Pattern VEHICLE_NUMBER_PATTERN =
        Pattern.compile("^[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$");

    private static final String[] VALID_FUEL_TYPES =
        {"PETROL", "DIESEL", "CNG", "ELECTRIC", "HYBRID", "LPG"};

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        
        String name = req.getParameter("name");
        String number = req.getParameter("number");
        String type = req.getParameter("type");
        String date = req.getParameter("date");
        String insurance = req.getParameter("insurance");
        String fuel = req.getParameter("fuel");

        System.out.println("Raw number: '" + number + "'");
        System.out.println("Trimmed number: '" + number.trim() + "'");
        System.out.println("Uppercase number: '" + number.trim().toUpperCase() + "'");

        StringBuilder errors = new StringBuilder();

        if (name == null || name.trim().isEmpty()) {
            errors.append("Owner Name is required.<br>");
        }

        if (number == null || number.trim().isEmpty()) {
            errors.append("Vehicle Number is required.<br>");
        } else if (!isValidVehicleNumber(number.trim().toUpperCase())) {
            errors.append("Invalid Vehicle Number format. Expected format: KA01AB1234<br>");
        }

        if (type == null || type.trim().isEmpty()) {
            errors.append("Vehicle Type is required.<br>");
        }

        if (date == null || date.trim().isEmpty()) {
            errors.append("Registration Date is required.<br>");
        }

        if (insurance == null || insurance.trim().isEmpty()) {
            errors.append("Insurance Valid Till date is required.<br>");
        } else if (!isFutureDate(insurance)) {
            errors.append("Insurance date must be in the future.<br>");
        }

        if (fuel == null || fuel.trim().isEmpty()) {
            errors.append("Fuel Type is required.<br>");
        } else if (!isValidFuelType(fuel.trim().toUpperCase())) {
            errors.append("Invalid Fuel Type. Valid types: PETROL, DIESEL, CNG, ELECTRIC, HYBRID, LPG<br>");
        }

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Vehicle Registration</h1>");

        if (errors.length() > 0) {
            out.println("<div style='color: red;'>");
            out.println("<h3>Validation Errors:</h3>");
            out.println(errors.toString());
            out.println("</div>");
            out.println("<br><a href='Vehicle.html'>Go Back</a>");
        } else {
            out.println("<div style='color: green;'>");
            out.println("<h3>Vehicle Registered Successfully!</h3>");
            out.println("<p><strong>Owner Name:</strong> " + name + "</p>");
            out.println("<p><strong>Vehicle Number:</strong> " + number.toUpperCase() + "</p>");
            out.println("<p><strong>Vehicle Type:</strong> " + type + "</p>");
            out.println("<p><strong>Registration Date:</strong> " + date + "</p>");
            out.println("<p><strong>Insurance Valid Till:</strong> " + insurance + "</p>");
            out.println("<p><strong>Fuel Type:</strong> " + fuel.toUpperCase() + "</p>");
            out.println("</div>");
            out.println("<br><a href='Vehicle.html'>Register Another Vehicle</a>");
        }
        
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

    private boolean isValidVehicleNumber(String number) {
        System.out.println("Pattern: " + VEHICLE_NUMBER_PATTERN.pattern());
        System.out.println("Input: " + number);
        boolean matches = VEHICLE_NUMBER_PATTERN.matcher(number).matches();
        System.out.println("Matches: " + matches);
        return matches;
    }

    private boolean isFutureDate(String dateStr) {
        try {
            LocalDate insuranceDate = LocalDate.parse(dateStr);
            return insuranceDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isValidFuelType(String fuel) {
        for (String validType : VALID_FUEL_TYPES) {
            if (validType.equals(fuel)) {
                return true;
            }
        }
        return false;
    }
}
