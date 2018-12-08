package com.example.communitywebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
//    @RequestMapping("/{path}")
//    public String index(HttpServletRequest request, @PathVariable String path)
//    {
////        String servletpath = request.getServletPath();
////        String requestUrl =  request.getRequestURI();
////        System.out.println("---------servletpath="+servletpath+"------requestUrl="+requestUrl)；
//        return path;
//    }
    @RequestMapping("/login.html")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/register.html")
    public String toRegister(){
        return "register";
    }

//    @Autowired
//    private OrdinaryUserService userService;
//    @RequestMapping("/test")
//    @ResponseBody
//    public List<OrdinaryUser> getAll() {
//        List<OrdinaryUser> list = userService.getAll();
//        return list;
//    }
//    @Autowired
//    private ActivityService activityService;
//    @RequestMapping("/test")
//    @ResponseBody
//    public Msg getAll() {
//        List<Activity> list = activityService.getAll();
//        List<Activity> list1 = activityService.getFiveActivity();
//        Activity list2 = activityService.getOneById(1);
//        return Msg.success().add("list",list).add("list1",list1).add("list2",list2);
//    }
}
