package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.ApplyResult;
import com.example.communitywebsite.bean.Msg;
import com.example.communitywebsite.service.ApplyResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplyResultController {
    @Autowired
    private ApplyResultService applyResultService;
    @PostMapping("/applyResult")
    @ResponseBody
    public Msg applyResult(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        ApplyResult applyResult = new ApplyResult(0,id);
        boolean b = applyResultService.selectByCid(id);
        if(b){
            boolean b1 = applyResultService.insertByApplyResult(applyResult);
            if(b1){
                return Msg.success();
            }else{
                return Msg.fail();
            }
        }else{
            return Msg.fail();
        }
    }
}
