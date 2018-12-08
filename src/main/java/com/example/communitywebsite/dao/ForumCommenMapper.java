package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.ForumComment;

import java.util.List;

public interface ForumCommenMapper {
    List<ForumComment> getAllById(int id);
    List<ForumComment>  getFiveById(int id);
}
