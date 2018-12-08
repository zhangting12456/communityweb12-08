package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Apply {
    private int id ;
    private int uid;
    private String applyReasons;
//    申请通过--2，申请待审核---1，申请未通过---0
    private int applyResult;
    private String applyDate;
}
