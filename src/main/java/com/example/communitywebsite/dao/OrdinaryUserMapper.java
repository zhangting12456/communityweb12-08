package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.OrdinaryUser;
import java.util.List;
public interface OrdinaryUserMapper {
    List<OrdinaryUser> getAll();
//    查寻询密码
    String  getByUsername(String username);
//    通过用户名查询整条信息
    OrdinaryUser getByName(String username);
    int addUser(OrdinaryUser ordinaryUser);
    int updatePassword(OrdinaryUser ordinaryUser);
    int updateUserByName(OrdinaryUser user);
//    上传头像
    int updateHeadImageByName(OrdinaryUser user);
    List<OrdinaryUser> getAllByCid(int cid);
    int countByCid(int cid);
    OrdinaryUser getCreateUserByCid(int cid);
    int updatePowerByName(String username);
}
