package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.Msg;
import com.example.communitywebsite.bean.OrdinaryUser;
import com.example.communitywebsite.service.OrdinaryUserService;
import com.example.communitywebsite.utils.CurrentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginRegController {
    @Autowired
    private OrdinaryUserService ordinaryUserService;
//    用户登录
    @RequestMapping("/userlogin")
    @ResponseBody
    public Msg userLogin(OrdinaryUser ordinaryUser, HttpServletRequest request){
        HttpSession session = request.getSession();
        String verCode = request.getParameter("vrifyCode");
        String sessionCode =(String) request.getSession().getAttribute("vrifyCode");
        String password = DigestUtils.md5DigestAsHex(ordinaryUser.getPassword().getBytes());
//        System.out.println(verCode+"========"+sessionCode);
//        System.out.println(ordinaryUser.toString());
        if(verCode.equals(sessionCode)){
            if(ordinaryUser.getUsername()!=null && ordinaryUser.getPassword()!=null){
                String dbPassword = ordinaryUserService.userLogin(ordinaryUser.getUsername());
                if(dbPassword != null){
                    if(dbPassword.equals(password)){
                        session.setAttribute("username",ordinaryUser.getUsername());
                        session.setAttribute("headimage",ordinaryUser.getHeadImage());
                        return Msg.success().add("info","登录成功");
                    }else{
                        return Msg.fail().add("info","密码错误");
                    }
                }else{
                    return Msg.fail().add("info","用户不存在");
                }
            }else{
                return Msg.fail().add("info","登录信息不能为空");
            }
        }else{
            return Msg.fail().add("info","验证码错误");
        }

    }
//    用户注册
    @RequestMapping("/userregister")
    @ResponseBody
    public Msg userRegister(OrdinaryUser ordinaryUser){
        if(ordinaryUser.getUsername()!=null && ordinaryUser.getPassword()!=null && ordinaryUser.getEmail()!=null
        && ordinaryUser.getPhone()!=null){
            String password = ordinaryUser.getPassword();
            String Md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            ordinaryUser.setPassword(Md5Password);
            CurrentTime currentTime = new CurrentTime();
            ordinaryUser.setCreateDate(currentTime.getStringDate());
            boolean b = ordinaryUserService.userRegister(ordinaryUser);
            if(b){
                return Msg.success().add("info","注册成功");
            }else{
                return Msg.fail().add("info","注册失败");
            }
        }else{
                return Msg.fail().add("info","注册失败");
        }
    }
//    通过id用户修改信息
//    @RequestMapping("/updatepassword")
//    @ResponseBody
//    public Msg  updatePassword(HttpServletRequest request){
//        int id = Integer.parseInt(request.getParameter("id"));
//        boolean b = ordinaryUserService.updatePassword(id);
//        return Msg.success();
//    }

}
