package com.example.communitywebsite.controller;

import com.example.communitywebsite.bean.Liuyan;
import com.example.communitywebsite.bean.Msg;
import com.example.communitywebsite.service.LiuyanService;
import com.example.communitywebsite.service.OrdinaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LiuyanController {
    @Autowired
    private LiuyanService liuyanService;
    @Autowired
    private OrdinaryUserService ordinaryUserService;
    @PostMapping("/addliuyan")
    @ResponseBody
    public Msg addLiuyan(HttpServletRequest request){
        int cid = Integer.parseInt(request.getParameter("cid"));
        String name = request.getParameter("name");
        String content = request.getParameter("data");
        String date = request.getParameter("date");
        int uid = ordinaryUserService.getOneByName(name).getUid();
        Liuyan liuyan = new Liuyan(0,cid,uid,content,date,null);
       // System.out.println(liuyan);
        boolean b = liuyanService.insertLiuyan(liuyan);
        if(b) {
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }
    @PostMapping("/selectliuyanbycid")
    @ResponseBody
    public Msg selectByCid(HttpServletRequest request){
        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Liuyan> list = liuyanService.selectByCid(cid);
        return Msg.success().add("list",list);
    }
}
