package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.Liuyan;

import java.util.List;

public interface LiuyanMapper {
    int insert(Liuyan liuyan);
    List<Liuyan> selectByCid(int cid);
}
