package com.xworkz.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/order")
public class OrderServlet extends GenericServlet {
    public OrderServlet() {
        System.out.println("OrderServlet constructor");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String password = req.getParameter("password");

        PrintWriter out = res.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Order placed successfully</h1>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
