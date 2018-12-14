package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.*;
import com.example.communitywebsite.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class CommHomeController {
    @Autowired
    private CommunityHomeService communityHomeService;
    @Autowired
    private OrdinaryUserService ordinaryUserService;
    @Autowired
    private CommunityProfileService profileService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private InformationService informationService;
//    首页展示
    @GetMapping("/index.html")
    public String Display(Model model, HttpServletRequest request){
           List<Activity> activities = activityService.getFiveActivity();
           List<Information> information = informationService.getFiveInformation();
           System.out.println(information);
           model.addAttribute("information",information);
           model.addAttribute("activities",activities);
        if(request.getParameter("id")==null) {
            List<CommunityHome> community = communityHomeService.getAll();
            model.addAttribute("community", community);
        }else{
            int id = Integer.parseInt(request.getParameter("id"));
            List<CommunityHome> community = communityHomeService.getAllByClass(id);
            model.addAttribute("community", community);
        }
            return "index";
    }
    @GetMapping("/getallcommunity")
    public Msg getAll(){
//        System.out.println("dasdas");
        List<CommunityHome> community = communityHomeService.getAll();
        return Msg.success().add("communtity",community);
    }
    @RequestMapping("/getonecommunity/{id}")
    public CommunityHome getOneById(@PathVariable int id){
        return communityHomeService.getOneById(id);
    }

    @RequestMapping("/create_community.html")
    public String toCreateCommunity(HttpServletRequest request,Model model){
        String username = (String) request.getSession().getAttribute("username");
        if(!username.equals(null)) {
            OrdinaryUser ordinaryUser = ordinaryUserService.getOneByName(username);
            model.addAttribute("user",ordinaryUser);
            return "create_community";
        }else{
            return "index";
        }
    }
    @RequestMapping("/createcommunity")
    @ResponseBody
    public Msg createCommunity(@RequestParam(value = "logo", required = false) MultipartFile file,
                               HttpServletRequest request)throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String newfileName;
        String path = "D:\\file-tomcat\\apache-tomcat-8.5.35\\webapps\\ROOT\\image";
        try{
            newfileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        }catch (Exception e){
             return Msg.fail().add("info","信息不能为空");
        }
        String communityname = request.getParameter("communityname");
        String createname = request.getParameter("createname");
        String communityurl = request.getParameter("communityurl");
        String createdate = request.getParameter("createdate");
        String classification = request.getParameter("classification");
        String modula = request.getParameter("modulaData");
        String historytitle = request.getParameter("historytitle");
        String historycontext = request.getParameter("historycontext");
        System.out.println(historycontext+"=="+historytitle);
        String imgPath = "/image/"+newfileName;
        String logo = imgPath;
        if(fileName!="" && communityname!="" && createname!="" && createdate!="" &&
              communityurl!="" && classification!="" && modula!=""){
            File dir = new File(path);
            if(!dir.exists()){
                dir.mkdirs();
            }
            file.transferTo(new File(dir+"\\"+newfileName));
            int  template = Integer.parseInt(request.getParameter("template"));
            CommunityProfile profile;
            boolean bName = communityHomeService.countByCounmmityname(communityname);
            boolean bUrl =communityHomeService.countByCounmmityurl(communityurl);
            if(bName && bUrl){
                CommunityHome communityHome = new CommunityHome(0,communityname,createname,communityurl,createdate,
                        classification,modula,logo,template,null);

//            System.out.println(communityHome);
                boolean b = communityHomeService.addCommunity(communityHome);
                int  cid = communityHomeService.getOneByCommuntiyname(communityname).getId();
//                System.out.println(cid);
                OrdinaryUser user = new OrdinaryUser(0,createname,"","","",cid,
                        "","","","",0);
                boolean bUpdate = ordinaryUserService.updatePowerByName(user);
                CommunityProfile communityProfile = new CommunityProfile(0,cid,historytitle,historycontext);
                boolean b1 = profileService.addCommunityProfile(communityProfile);
//                System.out.println(b1);
                if(b){
                    return Msg.success().add("info","创建成功");
                }else{
                    return Msg.fail().add("info","创建失败");
                }
            }else{
                return Msg.fail().add("info","社团名和URL已存在");
            }
        }else{
            return Msg.fail().add("info","信息不能为空");
        }
    }
}
