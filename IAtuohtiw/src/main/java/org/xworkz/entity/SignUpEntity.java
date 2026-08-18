package org.xworkz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpEntity {
    private String userID;
    private String Email;
    private String password;
    private String confirmPassword;
}
