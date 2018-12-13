package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Liuyan {
    private int id;
    private int cid;
    private int uid;
    private String content;
    private String time;
    private OrdinaryUser user;
}
