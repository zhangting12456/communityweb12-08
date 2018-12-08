package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.Msg;
import com.example.communitywebsite.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplyController {
    @Autowired
    private ApplyService applyService;
    @RequestMapping("/addapply")
    @ResponseBody
    public Msg addApply(HttpServletRequest request){
        String  username = (String) request.getSession().getAttribute("username");
        String applyReasons = request.getParameter("applyReason");
        String date = request.getParameter("date");
//        System.out.println(username+"-----"+applyReasons+"----"+date);
        if(applyReasons!="" && date!=""){
            boolean b = applyService.addApply(applyReasons,date,username);
            if(b){
                return Msg.success();
            }else{
                return Msg.fail();
            }
        }else{
            return Msg.fail();
        }
    }
}
