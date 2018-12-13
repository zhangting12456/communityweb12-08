package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.InformationSupport;
import com.example.communitywebsite.dao.InformationSupportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationSupportService {
    @Autowired
    private InformationSupportMapper supportMapper;

    public boolean addSupport(InformationSupport support){
        int n = supportMapper.insert(support);
        if(n ==0){
            return false;
        }else{
            return true;
        }
    }
    public boolean selectByAidAndUid(InformationSupport support){
        int n = supportMapper.selectByAidAndUid(support);
        if(n == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean deleteByAidAndUid(InformationSupport support){
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
