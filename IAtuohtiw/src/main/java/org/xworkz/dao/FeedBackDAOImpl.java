package org.xworkz.dao;

import org.xworkz.entity.FeedBackEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;

public class FeedBackDAOImpl implements FeedBackDAO {
    @Override
    public boolean save(FeedBackEntity feedBackEntity) {
        System.out.println("The Runing save method on FeedbackDAOImpl.");
        System.out.println("FeedBack Entity:"+feedBackEntity);


        boolean result = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback_db", "root", "Akasha@123");
            System.out.println("Database connection established successfully");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO feedback (name, email, feedback, mobile) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, feedBackEntity.getName());
            preparedStatement.setString(2, feedBackEntity.getEmail());
            preparedStatement.setString(3, feedBackEntity.getFeedback());
            preparedStatement.setString(4, String.valueOf(feedBackEntity.getMobile()));


            int rowEffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowEffected);

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
