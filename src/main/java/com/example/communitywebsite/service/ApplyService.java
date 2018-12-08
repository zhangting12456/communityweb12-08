package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.Apply;
import com.example.communitywebsite.dao.ApplyMapper;
import com.example.communitywebsite.dao.OrdinaryUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyService {
    @Autowired
    private ApplyMapper applyMapper;
    @Autowired
    private OrdinaryUserMapper ordinaryUserMapper;
    public boolean addApply(String applyReasons,String applyDate,String username){
        int uid = ordinaryUserMapper.getByName(username).getUid();
        Apply apply = new Apply();
        apply.setApplyDate(applyDate);
        apply.setApplyReasons(applyReasons);
        apply.setApplyResult(1);
        apply.setUid(uid);
        int n = applyMapper.addApply(apply);
        if(n == 0){
            return false;
        }else{
           return true;
        }
    }
//    审核通过
    public List<Apply> getApplyByAdoptName(String name){
        return applyMapper.selectApplyByadoptName(name);
    }
//    审核未通过
    public List<Apply> getApplyByNoPass(String name){
        return applyMapper.selectApplyByNoPass(name);
    }
//    待审核
    public List<Apply> getApplyByWait(String name){
        return applyMapper.selectApplyByWait(name);
    }
}
