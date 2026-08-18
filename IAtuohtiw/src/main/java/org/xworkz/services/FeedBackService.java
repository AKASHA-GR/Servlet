package org.xworkz.services;

import org.xworkz.dto.FeedBackDTO;

public interface FeedBackService {
    public boolean ValidateAndSave(FeedBackDTO feedBackDTO);
}
