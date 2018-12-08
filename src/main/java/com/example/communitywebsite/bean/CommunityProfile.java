package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommunityProfile {
    private int pid;
    private int cid;
    private String historytitle;
    private String historycontext;
}
