package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.ApplyResult;

public interface ApplyResultMapper {
      int slectByApplyid(int applyid);
      int insertByApplyResult(ApplyResult applyResult);
}
