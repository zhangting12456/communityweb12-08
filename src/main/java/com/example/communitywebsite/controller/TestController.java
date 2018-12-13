package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.*;
import com.example.communitywebsite.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/comhome")
public class TestController {
    @Autowired
    private CommunityHomeService communityHomeService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private InformationService informationService;
    @Autowired
    private OrdinaryUserService ordinaryUserService;
    @Autowired
    private DataDownloadService dataDownloadService;
    @Autowired
    private CommunityUserService communityUserService;

    @RequestMapping("/{url}")
    public String findcomHome(Model model, HttpServletRequest request, @PathVariable String url){
        String resURL = "";
        CommunityHome chome = communityHomeService.getCommunityByUrl(url);
//       System.out.println(chome);
        List<Activity> actList = activityService.getFiveActivityById(chome.getId());
//        System.out.println(actList);
        List<Information> infoList  = informationService.getFiveInformationByCid(chome.getId());
//        System.out.println(infoList);
//        查询会长和创始人
        List<OrdinaryUser> userList = ordinaryUserService.getAllByCid(chome.getId());
        List<DataDownload> dataList = dataDownloadService.getAllByCid(chome.getId());
//       System.out.println(userList);
        int countUser = ordinaryUserService.countByCid(chome.getId());
        OrdinaryUser createUser = ordinaryUserService.getCreateUserByCid(chome.getId());
//       查询普通用户
        List<CommunityUser> listCommunityname = communityUserService.getAllByCid(chome.getId());
//        System.out.println(listCommunityname );
        if(createUser == null){

        }else{
            model.addAttribute("createUser",createUser);
        }
        String[] path = chome.getModula().split(",");
        int temp = chome.getTemplate();
        if(temp == 1){
            resURL = "community_detail";
        }else  if(temp == 2){
            resURL = "community_detail01";
        }
        model.addAttribute("item",chome);
        model.addAttribute("path",path);
        model.addAttribute("userList",userList);
        model.addAttribute("actList",actList);
        model.addAttribute("infoList",infoList);
        model.addAttribute("dataList",dataList);
        model.addAttribute("number",countUser);
        model.addAttribute("communityuser",listCommunityname);
        return resURL;
    }

}
