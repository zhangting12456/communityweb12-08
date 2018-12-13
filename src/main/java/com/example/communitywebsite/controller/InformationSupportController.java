package com.example.communitywebsite.controller;



import com.example.communitywebsite.bean.InformationSupport;
import com.example.communitywebsite.bean.Msg;
import com.example.communitywebsite.service.InformationSupportService;
import com.example.communitywebsite.service.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InformationSupportController {
    @Autowired
    private InformationSupportService supportService;
    @Autowired
    private OrdinaryUserService ordinaryUserService;
    @PostMapping("/addinfosupport")
    @ResponseBody
    public void addSupport(HttpServletRequest request){
        int aid = Integer.parseInt(request.getParameter("aid"));
        String username = request.getParameter("username");
        int uid =ordinaryUserService.getOneByName(username).getUid();
        InformationSupport support = new InformationSupport(0,aid,uid);
        boolean b = supportService.selectByAidAndUid(support);
        if(b){
           supportService.deleteByAidAndUid(support);
        }else{
            supportService.addSupport(support);
        }
    }
    @PostMapping("/countinfosupport")
    @ResponseBody
    public Msg countSupport(HttpServletRequest request){
        int aid = Integer.parseInt(request.getParameter("aid"));
        int number = supportService.countByAid(aid);
        return Msg.success().add("number",number);
    }
}
