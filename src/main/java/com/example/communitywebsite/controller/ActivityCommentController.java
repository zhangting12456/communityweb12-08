package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.ActivityComment;
import com.example.communitywebsite.bean.Msg;
import com.example.communitywebsite.dao.OrdinaryUserMapper;
import com.example.communitywebsite.service.ActivityCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ActivityCommentController {
    @Autowired
    private ActivityCommentService activityCommentService;
    @Autowired
    private OrdinaryUserMapper ordinaryUserMapper;
    @RequestMapping("/addactivityComment")
    @ResponseBody
    public Msg addActivityComment(HttpServletRequest request){
        String username = request.getParameter("username");
//        System.out.println(username);
        int uid = ordinaryUserMapper.getByName(username).getUid();
        String comment = request.getParameter("comment");
        int aid = Integer.parseInt(request.getParameter("aid"));
        String date = request.getParameter("date");
        ActivityComment comment1 = new ActivityComment(0, aid,comment,uid,date,username,null);
        System.out.println(comment1);
        boolean b = activityCommentService.addComment(comment1);
        if(b){
            return Msg.success();
        }else{
            return  Msg.fail();
        }
    }
    @RequestMapping("/getAllactivitycomment")
    @ResponseBody
    public Msg getAllActivityCommment(HttpServletRequest request,int aid){
        List<ActivityComment> list = activityCommentService.getAllByAid(aid);
        return Msg.success().add("list",list);
    }
}
