package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.ActivityComment;
import com.example.communitywebsite.dao.ActivityCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCommentService {
    @Autowired
    private ActivityCommentMapper activityCommentMapper;
//    通过aid查询评论
    public List<ActivityComment> getAllByAid(int aid){
        return activityCommentMapper.getAll(aid);
    }
//    通过aid得到前五条记录

    public List<ActivityComment> getFiveByAid(int aid){
        return activityCommentMapper.getFiveActivity(aid);
    }
//   添加活动评论
    public boolean addComment(ActivityComment comment){
        int b = activityCommentMapper.addComment(comment);
        if(b==0){
            return  false;
        }else{
            return true;
        }
    }
//   通过aid统计记录数
    public int countByAid(int aid){
        return activityCommentMapper.countByAid(aid);
    }
}
