package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.OrdinaryUser;
import com.example.communitywebsite.service.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Upload {
    @Autowired
    private OrdinaryUserService userService;
    @PostMapping("/updateImg")
    @ResponseBody
    public Map updateImg(String username, @RequestParam(value = "portraitPath", required = false) MultipartFile file,
                         HttpServletRequest request) throws IOException {
//        String path="F:\\JetBrains\\apache-tomcat\\webapps\\ROOT\\upload\\img";
        String path = "D:\\file-tomcat\\apache-tomcat-8.5.35\\webapps\\ROOT\\image";
        //文件名
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        //存入数据库的路径
        String imgPath="/image/"+fileName;
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        file.transferTo(new File(dir+"\\"+fileName));
        System.out.println(username);
//        User user=new User();
//        user.setId(id);
//        user.setPortraitPath(imgPath);
//        User result=userService.update(user);
//        result.setPortraitPath(imgPath);
//        request.getSession().setAttribute("user", result);
        OrdinaryUser user = new OrdinaryUser();
        user.setUsername(username);
        user.setHeadImage(imgPath);
        userService.updateHeadImage(user);
        Map map=new HashMap();
        map.put("portraitPath",imgPath);
        return map;
    }

}
