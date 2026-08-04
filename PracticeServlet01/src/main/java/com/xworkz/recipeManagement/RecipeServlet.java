package com.xworkz.recipeManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/recipe",loadOnStartup = 1)
public class RecipeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String recipeName = req.getParameter("recipeName");
        String cuisineType = req.getParameter("cuisineType");
        String cookingTime = req.getParameter("cookingTime");
        String difficultyLevel = req.getParameter("difficultyLevel");
        String ingredientsCount = req.getParameter("ingredientsCount");
        String calories = req.getParameter("calories");

        StringBuilder error = new StringBuilder();
        PrintWriter out = resp.getWriter();

        if(recipeName == null || recipeName.isEmpty()) {
            error.append("Recipe name is required\n");
        }

        if(cuisineType == null || cuisineType.isEmpty()) {
            error.append("Cuisine type is required\n");
        }

        if(cookingTime == null || cookingTime.isEmpty()) {
            error.append("Cooking time is required\n");
        }

        if(difficultyLevel == null || difficultyLevel.isEmpty()) {
            error.append("Difficulty level is required\n");
        }

        if(ingredientsCount == null || ingredientsCount.isEmpty()) {
            error.append("Ingredients count is required\n");
        }

        if(calories == null || calories.isEmpty()) {
            error.append("Calories are required\n");
        }

        if(error.length() > 0) {
            out.println(error.toString());
        } else {
            out.println("<style>");
            out.println("body {font-family: Arial, sans-serif;}");
            out.println("h1 {color: #007bff;}");
            out.println("h2 {color: #6c757d;}");
            out.println("</style>");
            out.println("<h1>Recipe added successfully</h1>");
            out.println("<h2>The recipe details are:</h2>");
            out.println("<ul>");
            out.println("<li><strong>Recipe Name:</strong> " + recipeName + "</li>");
            out.println("<li><strong>Cuisine Type:</strong> " + cuisineType + " (Meaning of cuisine type: a specific style of cooking, such as Italian, Indian, or Chinese)</li>");
            out.println("<li><strong>Cooking Time:</strong> " + cookingTime + "</li>");
            out.println("<li><strong>Difficulty Level:</strong> " + difficultyLevel + "</li>");
            out.println("<li><strong>Ingredients Count:</strong> " + ingredientsCount + "</li>");
            out.println("<li><strong>Calories:</strong> " + calories + "</li>");
            out.println("</ul>");
            out.println("<a href='Recipe.html'>Add another recipe</a>");
        }
    }
}
