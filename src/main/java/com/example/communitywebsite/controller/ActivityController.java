package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.Activity;
import com.example.communitywebsite.bean.ActivityComment;
import com.example.communitywebsite.service.ActivityCommentService;
import com.example.communitywebsite.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping("")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityCommentService activityCommentService;
    @RequestMapping("/activity_detail/{aid}")
    public String toActivityDatail(Model model, HttpServletRequest request, @PathVariable int aid){
//        String servletpath = request.getServletPath();
//        String requestUrl =  request.getRequestURI();
//        System.out.println("---------servletpath="+servletpath+"------requestUrl="+requestUrl);
        List<ActivityComment> list = activityCommentService.getFiveByAid(aid);
//        System.out.println(list);
        int num = activityCommentService.countByAid(aid);
        Activity activity = activityService.getOneById(aid);
        model.addAttribute("activity",activity);
        model.addAttribute("comment",list);
        model.addAttribute("number",num);
        return "activity_detail";
    }

}
