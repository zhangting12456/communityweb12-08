package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.CommunityUser;

import java.util.List;

public interface CommunityUserMapper {
    List<CommunityUser> getCommunityByName(String username);
}
