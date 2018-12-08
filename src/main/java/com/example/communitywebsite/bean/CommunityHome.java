package com.example.communitywebsite.bean;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommunityHome {
    private int id;
    private String communityname;
    private String createname;
    private String communityurl ;
    private String createdate;
    private String classification;
    private String modula;
    private String logo;
    private int  template;
    private CommunityProfile profile;
}
