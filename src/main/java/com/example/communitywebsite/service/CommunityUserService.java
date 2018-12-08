package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.CommunityUser;
import com.example.communitywebsite.dao.CommunityUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityUserService {
    @Autowired
    private CommunityUserMapper communityUserMapper;

    public List<CommunityUser> getCommunityUser(String username){
        return communityUserMapper.getCommunityByName(username);
    }
}
