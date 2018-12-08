package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.Apply;

import java.util.List;

public interface ApplyMapper {
    int addApply(Apply apply);
    List<Apply> selectApplyByadoptName(String username);
    List<Apply> selectApplyByWait(String username);
    List<Apply> selectApplyByNoPass(String username);
}
