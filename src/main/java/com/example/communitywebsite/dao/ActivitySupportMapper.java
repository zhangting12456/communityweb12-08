package com.example.communitywebsite.dao;


import com.example.communitywebsite.bean.ActivitySupport;

public interface ActivitySupportMapper {
    int countByAid(int aid);
    int selectByAidAndUid(ActivitySupport support);
    int deleteByAidAndUid(ActivitySupport support);
    int insert(ActivitySupport support);
}
