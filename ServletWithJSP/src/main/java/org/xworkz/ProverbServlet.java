package org.xworkz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/proverb")
public class ProverbServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String proverb = request.getParameter("proverb");
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        String meaning = request.getParameter("meaning");


        System.out.println("Proverb: " + proverb);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Meaning: " + meaning);

        String message = "The Proverb " +proverb+ " has been added successfully";
        request.setAttribute("message", message);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("proverb.jsp");
        requestDispatcher.forward(request, response);


    }
}

