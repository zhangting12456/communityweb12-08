package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InformationComment {
    private int id;
    private int iid;
    private String commentcontext;
    private String commentdate;
    private int uid;
    private String username;
    private String HeadImage;
}
