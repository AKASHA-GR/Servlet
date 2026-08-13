package org.xworkz.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class SignUpDTO implements Serializable {

    private String userID;
    private String Email;
    private String password;
    private String confirmPassword;

}
