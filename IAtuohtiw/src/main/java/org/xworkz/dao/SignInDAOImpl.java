package org.xworkz.dao;

import org.xworkz.entity.SignInEntity;

public class SignInDAOImpl implements SignInDAO {
    @Override
    public boolean save(SignInEntity signInEntity){
        System.out.println("The save method is running on SignInDAOImpl.");
        System.out.println("SignIn Entity: " + signInEntity);
        return true;
    }
}
