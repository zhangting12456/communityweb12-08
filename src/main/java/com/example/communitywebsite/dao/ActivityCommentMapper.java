package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.ActivityComment;

import java.util.List;

public interface ActivityCommentMapper {
    //    通过时间排序得到前5条数据
    List<ActivityComment> getFiveActivity(int aid);
    //    得到所有的记录
    List<ActivityComment> getAll(int aid);
//    添加评论
    int addComment(ActivityComment comment);
//    统计该活动的评论数
    int countByAid(int aid);
}
