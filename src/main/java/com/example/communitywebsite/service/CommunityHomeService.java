package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.CommunityHome;
import com.example.communitywebsite.dao.CommunityHomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityHomeService {
    @Autowired
    private CommunityHomeMapper  communityHomeMapper;
//    的到所有的社团信息
    public List<CommunityHome> getAll(){
        return communityHomeMapper.getAll();
    }
//    通过社团id查询社团详情
    public CommunityHome getOneById(int id){
        return communityHomeMapper.getOneById(id);
    }
//   通过类别查询社团详情
    public List<CommunityHome> getAllByClass(int id){
        String str[] = {"学术类","科技类","思政类","文艺类","体育类","实践类","公益类","班级类","同乡类"};
        return communityHomeMapper.getAllByClass(str[id-1]);
    }
//  通过社团名得到jilu
    public CommunityHome getOneByCommuntiyname(String communityname){
        return communityHomeMapper.getOneByCommunity(communityname);
    }
    public boolean addCommunity(CommunityHome communityHome) {
        int n = communityHomeMapper.addCommunity(communityHome);
        if(n==0){
            return false;
        }else{
            return true;
        }
    }
//    判断社团名是否存在
    public boolean countByCounmmityname(String communityname){
        int n = communityHomeMapper.countByCommunityname(communityname);
        if(n==0){
            return true;
        }else{
            return false;
        }
    }
    //    判断url是否存在
    public boolean countByCounmmityurl(String communityurl){
        int n = communityHomeMapper.countByCommunityname(communityurl);
        if(n==0){
            return true;
        }else{
            return false;
        }
    }
}


