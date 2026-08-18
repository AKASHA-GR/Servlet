package org.xworkz.services.impl;

import org.xworkz.dao.FeedBackDAO;
import org.xworkz.dao.FeedBackDAOImpl;
import org.xworkz.dto.FeedBackDTO;
import org.xworkz.entity.FeedBackEntity;
import org.xworkz.services.FeedBackService;

public class FeedBackServiceImpl implements FeedBackService {

    @Override
    public boolean ValidateAndSave(FeedBackDTO feedBackDTO) {
        System.out.println("Validating and saving FeedBackDTO: " + feedBackDTO);

        if(feedBackDTO != null){
            System.out.println("FeedBackDTO is not null");

            FeedBackEntity feedBackEntity = new FeedBackEntity();
            feedBackEntity.setName(feedBackDTO.getName());
            feedBackEntity.setEmail(feedBackDTO.getName());
            feedBackEntity.setFeedback(feedBackDTO.getFeedback());
            feedBackEntity.setMobile(feedBackDTO.getMobile());

            FeedBackDAO feedBackDAO = new FeedBackDAOImpl();
            feedBackDAO.save(feedBackEntity);
        }
        return true;
    }
}
