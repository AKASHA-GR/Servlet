package org.xworkz.dao;

import org.xworkz.dto.SignUpDTO;
import org.xworkz.entity.SignUpEntity;

public interface SignUpDAO {
    public boolean save(SignUpEntity signUpEntity);
}
