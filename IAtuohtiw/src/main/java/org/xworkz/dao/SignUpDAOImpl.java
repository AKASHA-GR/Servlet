package org.xworkz.dao;

import org.xworkz.entity.SignUpEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpDAOImpl implements SignUpDAO{
    @Override
    public boolean save(SignUpEntity signUpEntity) {
        System.out.println("The save method is running on SignUpDAOImpl.");
        System.out.println("SignUp Entity: " + signUpEntity);

        boolean result = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback_db", "root", "Akasha@123");
            System.out.println("Database connection established successfully");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sign_up (userID, email, password, confirmPassword) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, signUpEntity.getUserID());
            preparedStatement.setString(2, signUpEntity.getEmail());
            preparedStatement.setString(3, signUpEntity.getPassword());
            preparedStatement.setString(4, signUpEntity.getConfirmPassword());

            int rowAffected =preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowAffected);

            result = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return result;
    }
}
