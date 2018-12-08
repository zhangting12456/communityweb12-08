package com.example.communitywebsite.controller;

import com.example.communitywebsite.service.InformationCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InformationCommentController {
    @Autowired
    private InformationCommentService commentService;


}
