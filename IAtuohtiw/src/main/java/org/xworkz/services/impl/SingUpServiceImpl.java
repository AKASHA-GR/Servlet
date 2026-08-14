package org.xworkz.services.impl;

import org.xworkz.services.SignUpService;

public class SingUpServiceImpl implements SignUpService {
    @Override
    public boolean validateAndSave(String userID, String email, String password, String confirmPassword) {

        if (userID == null || email == null || password == null || confirmPassword == null) {
            return false;
        }
        if (!password.equals(confirmPassword)) {
            return false;
        }
        return true;
    }
}
