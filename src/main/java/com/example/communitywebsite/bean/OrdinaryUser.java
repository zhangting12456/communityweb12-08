package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrdinaryUser {
   private int uid;
   private String username;
   private String password;
   private String email;
   private String phone;
   private int CommunityId;
   private String CommunityDuties;
   private String HeadImage ;
   private String sex;
   private String createDate;
   private int Jurisdiction;
}
