package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.Information;

import java.util.List;

public interface InformationMapper {
    //    通过时间排序得到前5条数据
    List<Information> getFiveInformation();
    //    得到所有的记录
    List<Information> getAll();
    //    通过id的到活动
    Information getOneById(int id);
    //    通过时间排序得到前5条数据
    List<Information> getFiveInformationByCid(int cid);
    //    得到所有的记录
    List<Information> getAllByCid(int cid);
}
