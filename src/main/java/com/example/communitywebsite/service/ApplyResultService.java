package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.ApplyResult;
import com.example.communitywebsite.dao.ApplyResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyResultService {
    @Autowired
    private ApplyResultMapper applyResultMapper;

    public boolean selectByCid(int applyid){
        int b = applyResultMapper.slectByApplyid(applyid);
        if (b == 0 ){
            return true;
        }else{
            return false;
        }
    }

    public boolean insertByApplyResult(ApplyResult applyResult){
        int b = applyResultMapper.insertByApplyResult(applyResult);
        if(b == 0){
            return false;
        }else{
            return true;
        }
    }
}
