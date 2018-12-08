package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.Activity;
import com.example.communitywebsite.dao.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
//    查询前5条数据
    public List<Activity> getFiveActivity(){
        return activityMapper.getFiveActivity();
    }
//    查询所有的数据
    public List<Activity> getAll(){
        return activityMapper.getAll();
    }
//    通过id查询数据
    public Activity getOneById(int id){
        return activityMapper.getOneById(id);
    }
}
