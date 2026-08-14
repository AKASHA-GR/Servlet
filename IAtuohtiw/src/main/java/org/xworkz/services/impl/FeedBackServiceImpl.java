package org.xworkz.services.impl;

import org.xworkz.services.FeedBackService;

public class FeedBackServiceImpl implements FeedBackService {
    @Override
    public boolean ValidateAndSave(String name, String email, String feedback) {
        if(name == null || email == null || feedback == null){
            return false;
        }
        return true;
    }
}
