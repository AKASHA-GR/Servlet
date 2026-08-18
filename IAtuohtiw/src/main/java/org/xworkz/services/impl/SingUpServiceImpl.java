package org.xworkz.services.impl;

import org.xworkz.dao.SignUpDAO;
import org.xworkz.dao.SignUpDAOImpl;
import org.xworkz.dto.SignUpDTO;
import org.xworkz.entity.SignUpEntity;
import org.xworkz.services.SignUpService;

public class SingUpServiceImpl implements SignUpService {
    @Override
    public boolean validateAndSave(SignUpDTO signUpDTO) {
        System.out.println("Validating and saving SignUpDTO: " + signUpDTO);

        if(signUpDTO != null){
            System.out.println("SignUpDTO is not null");

            SignUpEntity signUpEntity = new SignUpEntity();
            signUpEntity.setUserID(signUpDTO.getUserID());
            signUpEntity.setEmail(signUpDTO.getEmail());
            signUpEntity.setPassword(signUpDTO.getPassword());
            signUpEntity.setConfirmPassword(signUpDTO.getConfirmPassword());

            SignUpDAOImpl signUpDAO = new SignUpDAOImpl();
            return signUpDAO.save(signUpEntity);

        }

        return false;
    }
}
