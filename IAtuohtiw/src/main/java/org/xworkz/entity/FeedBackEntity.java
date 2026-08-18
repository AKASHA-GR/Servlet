package org.xworkz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackEntity {
    private String name;
    private String email;
    private long mobile;
    private String feedback;
}
