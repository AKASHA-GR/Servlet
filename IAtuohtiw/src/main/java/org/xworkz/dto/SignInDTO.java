package org.xworkz.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class SignInDTO implements Serializable{
    private String name;
    private String email;
    private String password;
    private String mobileNumber;


}
