package org.xworkz.services.impl;

import org.xworkz.services.SingInService;

public class SingInServiceImpl implements SingInService {
    @Override
    public boolean validateAndSave(String userName, String email) {
        if(userName == null || email == null){
            return false;
        }
        return true;
    }
}
