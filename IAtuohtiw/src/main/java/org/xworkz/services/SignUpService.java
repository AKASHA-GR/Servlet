package org.xworkz.services;

public interface SignUpService {
    public boolean validateAndSave(String userID, String email, String password, String confirmPassword);
}
