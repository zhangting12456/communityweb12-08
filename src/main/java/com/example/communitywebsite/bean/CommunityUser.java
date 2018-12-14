package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommunityUser {
    private int id;

    private int cid;
    private int uid;
    private CommunityHome community;
   private OrdinaryUser ordinaryUser;
}
