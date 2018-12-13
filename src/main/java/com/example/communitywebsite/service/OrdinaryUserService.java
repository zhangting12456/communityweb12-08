package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.OrdinaryUser;
import com.example.communitywebsite.dao.OrdinaryUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdinaryUserService {
    @Autowired
    private OrdinaryUserMapper userMapper;
//    查询所用普通用户
    public List<OrdinaryUser> getAll(){
        List<OrdinaryUser> list = userMapper.getAll();
        return list;
    }
//    用户登录
    public String userLogin(String username){
        String password = userMapper.getByUsername(username);
        return password;
    }
//    用户注册
    public boolean userRegister(OrdinaryUser ordinaryUser){
        int n = userMapper.addUser(ordinaryUser);
        if(n == 0){
            return false;
        }else{
            return true;
        }
    }
//    通过用户名查询用户信息
    public OrdinaryUser getOneByName(String username) {
        OrdinaryUser user = userMapper.getByName(username);
        return user;
    }
//通过用户名修改用户信息
     public boolean updateUser(OrdinaryUser user){
        int n = userMapper.updateUserByName(user);
        if(n==0){
            return false;
        }else{
            return true;
        }
     }
// 同过用户名修改用户的头像
    public boolean updateHeadImage(OrdinaryUser user){
        int n = userMapper.updateHeadImageByName(user);
        if(n==0){
            return false;
        }else{
            return true;
        }
    }

    public List<OrdinaryUser> getAllByCid(int cid) {
        List<OrdinaryUser> list = userMapper.getAllByCid(cid);
        for (OrdinaryUser item :list){
            item.setPassword("");
        }
        return list;
    }
    public int countByCid(int cid){
        return userMapper.countByCid(cid);
    }

    public OrdinaryUser getCreateUserByCid(int cid){
        OrdinaryUser user = userMapper.getCreateUserByCid(cid);
        if(user == null){
            return null;
        }
        user.setPassword("");
        return user;
    }

    public  boolean  updatePowerByName(String username){
        int b = userMapper.updatePowerByName(username);
        if(b == 0){
            return false;
        }else{
            return true;
        }
    }
//    用户通过id更新数据
//    public boolean updatePassword(int id) {
//        int n = userMapper.updatePassword(i);
//    }
}
