package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.InformationComment;

import java.util.List;

public interface InformationCommentMapper {
    List<InformationComment> getAllById(int id);
    List<InformationComment>  getFiveById(int id);
    int countByIid(int id);
    int addComment(InformationComment comment);
}
