package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Activity {
   private int aid;
   private String atitle;
   private String startdate;
   private String enddate;
   private String activitycontent;
   private int cid;
   private String communityname;
}
