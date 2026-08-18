package org.xworkz.dao;

import org.xworkz.entity.SignUpEntity;

public class SignUpDAOImpl implements SignUpDAO{
    @Override
    public boolean save(SignUpEntity signUpEntity) {
        System.out.println("The save method is running on SignUpDAOImpl.");
        System.out.println("SignUp Entity: " + signUpEntity);
        return true;
    }
}
