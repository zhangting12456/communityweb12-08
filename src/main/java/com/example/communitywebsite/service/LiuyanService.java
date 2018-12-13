package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.Liuyan;
import com.example.communitywebsite.dao.LiuyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiuyanService {
    @Autowired
    private LiuyanMapper liuyanMapper;
    public boolean insertLiuyan(Liuyan liuyan){
        int b = liuyanMapper.insert(liuyan);
        if(b == 0){
            return false;
        }else{
            return true;
        }
    }
    public List<Liuyan> selectByCid(int cid){
        List<Liuyan> list = liuyanMapper.selectByCid(cid);
        return list;
    }
}
