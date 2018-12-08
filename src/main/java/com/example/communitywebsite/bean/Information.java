package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Information {
    private int iId;
    private String Ititle;
    private String Idate;
    private String InfoContent;
    private int cId;
    private String communityname;
}
