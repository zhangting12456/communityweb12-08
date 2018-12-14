package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.CommunityUser;
import com.example.communitywebsite.bean.Msg;
import com.example.communitywebsite.service.CommunityUserService;
import com.example.communitywebsite.service.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommunityUserController {
    @Autowired
    private CommunityUserService communityUserService;

    @Autowired
    private OrdinaryUserService userService;
    @PostMapping("/joincommunity")
    @ResponseBody
    public Msg joinCommunity(HttpServletRequest request){
        String name = request.getParameter("name");
        int uid = userService.getOneByName(name).getUid();
        int cid = Integer.parseInt(request.getParameter("cid"));
//       System.out.println(name+"========"+cid+"======="+uid);
        CommunityUser communityUser = new CommunityUser(0,cid,uid,null,null);
        boolean b = communityUserService.selectByCidUid(communityUser);
        if(b){
            boolean b1 = communityUserService.insert(communityUser);
            if(b1){
                return Msg.success().add("info","加入成功");
            }else{
                return Msg.fail().add("info","加入失败");
            }
        }
        return Msg.fail().add("info","已经加入");
    }

}
