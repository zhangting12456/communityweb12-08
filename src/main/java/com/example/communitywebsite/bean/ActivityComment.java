package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActivityComment {
    private int id;
    private int aid;
    private String comment;
    private int uid;
    private String date;
    private String username;
    private String HeadImage;
}
