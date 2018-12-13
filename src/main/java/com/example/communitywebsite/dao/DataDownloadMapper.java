package com.example.communitywebsite.dao;

import com.example.communitywebsite.bean.DataDownload;

import java.util.List;

public interface DataDownloadMapper {
    List<DataDownload> getAll();
    List<DataDownload> getAllByCid(int cid);
    List<DataDownload> getfiveByCid(int cid);
    List<DataDownload> getFive();
}
