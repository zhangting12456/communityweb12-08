package com.example.communitywebsite.dao;


import com.example.communitywebsite.bean.InformationSupport;

public interface InformationSupportMapper {
    int countByAid(int aid);
    int selectByAidAndUid(InformationSupport support);
    int deleteByAidAndUid(InformationSupport support);
    int insert(InformationSupport support);
}
