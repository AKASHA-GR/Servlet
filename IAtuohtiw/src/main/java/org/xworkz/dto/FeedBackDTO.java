package org.xworkz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor

public class FeedBackDTO implements Serializable {
    private String name;
    private String email;
    private long mobile;
    private String feedback;

}
