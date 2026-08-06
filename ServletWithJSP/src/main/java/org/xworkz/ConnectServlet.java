package org.xworkz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/connect")
public class ConnectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward GET requests to conect.jsp
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("conect.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);

        // Simple validation (in production, validate against database)
        String message;
        String messageType = "success";

        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            if (username.length() < 3) {
                message = "Username must be at least 3 characters long";
                messageType = "error";
            } else if (password.length() < 4) {
                message = "Password must be at least 4 characters long";
                messageType = "error";
            } else {
                message = "Login successful! Welcome, " + username;
            }
        } else {
            message = "Please fill in all fields";
            messageType = "error";
        }

        request.setAttribute("message", message);
        request.setAttribute("messageType", messageType);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("conect.jsp");
        requestDispatcher.forward(request, response);
    }
}
