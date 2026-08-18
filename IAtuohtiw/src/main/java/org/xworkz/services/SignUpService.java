package org.xworkz.services;

import org.xworkz.dto.SignInDTO;
import org.xworkz.dto.SignUpDTO;
import org.xworkz.entity.SignInEntity;

public interface SignUpService {
    public boolean validateAndSave(SignUpDTO signUpDTO);
}
