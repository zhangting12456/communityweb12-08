package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.ActivitySupport;
import com.example.communitywebsite.dao.ActivitySupportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivitySupportService {
    @Autowired
    private ActivitySupportMapper supportMapper;

    public boolean addSupport(ActivitySupport support){
        int n = supportMapper.insert(support);
        if(n ==0){
            return false;
        }else{
            return true;
        }
    }
    public boolean selectByAidAndUid(ActivitySupport support){
        int n = supportMapper.selectByAidAndUid(support);
        if(n == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean deleteByAidAndUid(ActivitySupport support){
        int n = supportMapper.deleteByAidAndUid(support);
        if(n == 0){
            return false;
        }else{
            return true;
        }
    }
    public int countByAid(int aid){
        return supportMapper.countByAid(aid);
    }
}
