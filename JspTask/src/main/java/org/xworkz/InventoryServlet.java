package org.xworkz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/include")
public class InventoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("product_name");
        Double price = Double.parseDouble(request.getParameter("product_price"));
        int quantity = Integer.parseInt(request.getParameter("product_quantity"));
        String description = request.getParameter("product_description");
        byte[] image = request.getParameter("product_image").getBytes();

        String message = "Product added successfully";
        request.setAttribute("message", message);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(request, response);

    }
}
