package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.CommunityProfile;
import com.example.communitywebsite.dao.CommunityProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityProfileService {
    @Autowired
    private CommunityProfileMapper profileMapper;
    public boolean addCommunityProfile(CommunityProfile profile){
        int b = profileMapper.addCommunityProfile(profile);
        if(b!=0){
            return true;
        }else{
            return false;
        }
    }
}
