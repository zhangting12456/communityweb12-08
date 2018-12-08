package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommunityUser {
    private int id;
    private int uid;
    private int cid;
    private CommunityHome community;
//    private String communityname;
}
