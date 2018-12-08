package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ForumComment {
    private int id;
    private int fid;
    private int uid;
    private String comment;
    private String date;
    private String username;
    private String forumtitle;
}
