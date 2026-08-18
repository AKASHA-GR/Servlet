package org.xworkz.services.impl;

import org.xworkz.dao.SignInDAO;
import org.xworkz.dao.SignInDAOImpl;
import org.xworkz.dto.SignInDTO;
import org.xworkz.entity.SignInEntity;
import org.xworkz.services.SingInService;

public class SingInServiceImpl implements SingInService {
    @Override
    public boolean validateAndSave(SignInDTO signInDTO) {

        System.out.println("Validating and saving SignInDTO: " + signInDTO);

        if(signInDTO != null){

            SignInEntity signInEntity = new SignInEntity();
            signInEntity.setUserName(signInDTO.getUserName());
            signInEntity.setEmail(signInDTO.getEmail());

        }

        SignInDAO signInDAO = new SignInDAOImpl();
        signInDAO.save(new SignInEntity());

        return true;
    }
}
