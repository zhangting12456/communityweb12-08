package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.InformationComment;
import com.example.communitywebsite.dao.InformationCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationCommentService {
    @Autowired
    private InformationCommentMapper commentMapper;
    public List<InformationComment> getAllById(int id){
        return commentMapper.getAllById(id);
    }
    public List<InformationComment> getFiveById(int id){
        return commentMapper.getFiveById(id);
    }
    public boolean addComment(InformationComment comment){
        int b = commentMapper.addComment(comment);
        if(b==0){
            return false;
        }else{
            return true;
        }
    }
    public int countByIid(int id){
        return commentMapper.countByIid(id);
    }
 }
