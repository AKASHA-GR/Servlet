package org.xworkz.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class SignInDTO implements Serializable{
    private String userName;
    private String email;



}
