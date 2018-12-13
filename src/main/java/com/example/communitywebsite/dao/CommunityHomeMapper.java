package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.CommunityHome;

import java.util.List;

public interface CommunityHomeMapper {
    List<CommunityHome> getAll();
    CommunityHome getOneById(int id);
    CommunityHome getCommHomeProfile(int id);
    List<CommunityHome> getAllByClass(String classification);
    int addCommunity(CommunityHome communityHome);
    CommunityHome getOneByCommunity(String communityname);
    int countByCommunityname(String name);
    int countByCommunityurl(String url);
    CommunityHome getCommunityByUrl(String url);
}
