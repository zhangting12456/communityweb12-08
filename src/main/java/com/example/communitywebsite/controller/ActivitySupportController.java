package com.example.communitywebsite.controller;


import com.example.communitywebsite.bean.ActivitySupport;
import com.example.communitywebsite.bean.Msg;
import com.example.communitywebsite.service.ActivitySupportService;
import com.example.communitywebsite.service.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ActivitySupportController {
    @Autowired
    private ActivitySupportService supportService;
    @Autowired
    private OrdinaryUserService ordinaryUserService;
    @PostMapping("/addsupport")
    @ResponseBody
    public void addSupport(HttpServletRequest request){
        int aid = Integer.parseInt(request.getParameter("aid"));
        String username = request.getParameter("username");
        int uid =ordinaryUserService.getOneByName(username).getUid();
        ActivitySupport support = new ActivitySupport(0,aid,uid);
        boolean b = supportService.selectByAidAndUid(support);
        if(b){
           supportService.deleteByAidAndUid(support);
        }else{
            supportService.addSupport(support);
        }
    }
    @PostMapping("/countsupport")
    @ResponseBody
    public Msg countSupport(HttpServletRequest request){
        int aid = Integer.parseInt(request.getParameter("aid"));
        int number = supportService.countByAid(aid);
        return Msg.success().add("number",number);
    }
}
