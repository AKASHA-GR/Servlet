package org.xworkz.services;

import org.xworkz.dto.SignInDTO;

public interface SingInService {
    public boolean validateAndSave(SignInDTO signInDTO
    );
}
