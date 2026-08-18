package org.xworkz.dao;

import org.xworkz.entity.FeedBackEntity;

public class FeedBackDAOImpl implements FeedBackDAO {
    @Override
    public boolean save(FeedBackEntity feedBackEntity) {
        System.out.println("The Runing save method on FeedbackDAOImpl.");
        System.out.println("FeedBack Entity:"+feedBackEntity);
        return true;
    }
}
