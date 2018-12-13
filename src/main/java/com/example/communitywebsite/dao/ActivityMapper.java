package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.Activity;

import java.util.List;

public interface ActivityMapper {
//    通过时间排序得到前5条数据
    List<Activity> getFiveActivity();
//    得到所有的记录
    List<Activity> getAll();
//    通过id的到活动
    Activity getOneById(int id);
//    得到社团id所有的记录
    List<Activity> getAllByCid(int id);
//    通过社团id的到前5活动
    List<Activity> getFiveActivityById(int id);
}
