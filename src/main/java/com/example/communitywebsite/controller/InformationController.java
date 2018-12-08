package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.Information;
import com.example.communitywebsite.bean.InformationComment;
import com.example.communitywebsite.bean.Msg;
import com.example.communitywebsite.dao.OrdinaryUserMapper;
import com.example.communitywebsite.service.InformationCommentService;
import com.example.communitywebsite.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class InformationController {
    @Autowired
    private InformationService informationService;
    @Autowired
    private InformationCommentService commentService;
    @Autowired
    private OrdinaryUserMapper ordinaryUserMapper;
    @GetMapping("information/{id}")
    public String toInformation(@PathVariable int id, Model model){
        Information information = informationService.getOneById(id);
        List<InformationComment> list = commentService.getFiveById(id);
        int number = commentService.countByIid(id);
//        System.out.println(list);
        model.addAttribute("number",number);
        model.addAttribute("comment",list);
        model.addAttribute("information",information);
        return "information";
    }
    @PostMapping("/getAllinformationcomment")
    @ResponseBody
    public Msg getAllInformation(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("aid"));
        List<InformationComment> list = commentService.getAllById(id);
        return Msg.success().add("list",list);
    }

    @PostMapping("/addinformationComment")
    @ResponseBody
    public Msg addComment(HttpServletRequest request){
        String username = request.getParameter("username");
//        System.out.println(username);
        int uid = ordinaryUserMapper.getByName(username).getUid();
        String comment = request.getParameter("comment");
        int iid = Integer.parseInt(request.getParameter("aid"));
        String date = request.getParameter("date");
         InformationComment comment1 = new InformationComment(0,iid,comment,date,uid,username,null);
        System.out.println(comment1);
        boolean b = commentService.addComment(comment1);
        if(b){
            return Msg.success();
        }else{
            return  Msg.fail();
        }
    }
}
