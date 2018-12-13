package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.Apply;
import com.example.communitywebsite.bean.CommunityUser;
import com.example.communitywebsite.bean.Msg;
import com.example.communitywebsite.bean.OrdinaryUser;
import com.example.communitywebsite.service.ApplyService;
import com.example.communitywebsite.service.CommunityUserService;
import com.example.communitywebsite.service.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrdinaryUserController {
    @Autowired
    private OrdinaryUserService ordinaryUserService;
    @Autowired
    private CommunityUserService communityUserService;
    @Autowired
    private ApplyService applyService;
//    查询用户详细信息
    @RequestMapping("/user_detail.html")
    public String toUserDetail(HttpServletRequest request, Model model){
        String username = (String) request.getSession().getAttribute("username");
        OrdinaryUser user = ordinaryUserService.getOneByName(username);

        List<Apply> noApply = applyService.getApplyByNoPass(username);
        List<Apply> adoptApply = applyService.getApplyByAdoptName(username);
        List<Apply> waitApply = applyService.getApplyByWait(username);
        List<CommunityUser> list = communityUserService.getCommunityUser(username);
        model.addAttribute("noApply",noApply);
        model.addAttribute("waitApply",waitApply);
        model.addAttribute("adoptApply",adoptApply);
        model.addAttribute("list",list);
        model.addAttribute("user",user);
        return "user_detail";
    }
//    用户修改信息
    @RequestMapping(value="/updateuser",method= RequestMethod.POST)
    @ResponseBody
    public Msg updateUser(OrdinaryUser user,HttpServletRequest request){
        System.out.println(user);
        boolean b = false;
        if(user.getUsername()!=null || user.getPhone()!= null || user.getEmail()!=null
        || user.getHeadImage()!=null ||user.getPassword()!= null){
            user.setUsername((String) request.getSession().getAttribute("username"));
            b = ordinaryUserService.updateUser(user);
        }
        if(b) {
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }
//    退出登录
     @RequestMapping("/userout")
     @ResponseBody
       public  Msg  userOut(HttpServletRequest request){
//            request.getSession().removeAttribute("username");
         request.getSession().invalidate();
//            return "index.html";
         return Msg.success();
    }

//    @RequestMapping("/communityuser/{username}")
//    @ResponseBody
//    public Map getCommunityUser(@PathVariable String username){
//        List<CommunityUser> list = communityUserService.getCommunityUser(username);
//        Map map = new HashMap();
//        map.put("communityuser",list);
//        return map;
//    }
//
//    @RequestMapping("/userapply/{username}")
//    @ResponseBody
//    public Map getUserApply(@PathVariable String username){
//        List<Apply> list = applyService.getApplyByAdoptName(username);
//        Map map = new HashMap();
//        map.put("communityuser",list);
//        return map;
//    }
}
