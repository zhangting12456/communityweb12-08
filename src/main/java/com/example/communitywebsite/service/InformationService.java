package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.Information;
import com.example.communitywebsite.dao.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {
    @Autowired
    private InformationMapper informationMapper;
// 查询资讯
    public List<Information>  getAll(){
        return informationMapper.getAll();
    }
//    查出前5条记录
    public List<Information> getFiveInformation(){
        return informationMapper.getFiveInformation();
    }
    public Information getOneById(int id){
        return informationMapper.getOneById(id);
    }
}
