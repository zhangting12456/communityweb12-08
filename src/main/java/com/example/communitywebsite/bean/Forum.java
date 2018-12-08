package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Forum {
    private int fid;
    private int cid;
    private String forumtitle;
    private String fcreatedate;
    private String fcreatename;
    private String forumcontext;
    private int uid;
    private String communityname;
    private String username;
}
