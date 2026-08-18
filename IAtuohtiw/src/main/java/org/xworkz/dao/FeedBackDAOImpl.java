package org.xworkz.dao;

import org.xworkz.entity.FeedBackEntity;

public class FeedBackDAOImpl extends FeedBackDAO {
    @Override
    public boolean save(FeedBackEntity feedBackEntity) {
        System.out.println("The Runing save method on Feedback");
        System.out.println();
        return false;
    }
}
