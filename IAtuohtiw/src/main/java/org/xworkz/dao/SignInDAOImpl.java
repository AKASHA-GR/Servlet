package org.xworkz.dao;

import org.xworkz.entity.SignInEntity;

import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignInDAOImpl implements SignInDAO {
    @Override
    public boolean save(SignInEntity signInEntity){
        System.out.println("The save method is running on SignInDAOImpl.");
        System.out.println("SignIn Entity: " + signInEntity);


        boolean result = false;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback_db", "root", "Akasha@123");

            System.out.println("Database connection established successfully");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sign_in (userName, email) VALUES (?, ?)");
            preparedStatement.setString(1, signInEntity.getUserName());
            preparedStatement.setString(2, signInEntity.getEmail());

            System.out.println("Executing SQL: INSERT INTO sign_in (user_name, email) VALUES ('" + signInEntity.getUserName() + "', '" + signInEntity.getEmail() + "')");

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            if(rowsAffected > 0){
                result = true;
            }

        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }

        finally {
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
