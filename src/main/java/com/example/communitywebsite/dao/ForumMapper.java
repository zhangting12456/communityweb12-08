package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.Forum;

import java.util.List;

public interface ForumMapper {
    Forum getOneById(int id);
    List<Forum> getAll();
    List<Forum> getFiveActivity();
}
