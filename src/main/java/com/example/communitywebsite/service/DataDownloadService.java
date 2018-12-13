package com.example.communitywebsite.service;

import com.example.communitywebsite.bean.DataDownload;
import com.example.communitywebsite.dao.DataDownloadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDownloadService {
    @Autowired
    private DataDownloadMapper dataDownloadMapper;
    public List<DataDownload> getAll(){
        return dataDownloadMapper.getAll();
    }
    public List<DataDownload> getAllByCid(int cid){
        return dataDownloadMapper.getAllByCid(cid);
    }
    public List<DataDownload> getFive(){
        return dataDownloadMapper.getFive();
    }
    public List<DataDownload> getFiveByCid(int cid){
        return dataDownloadMapper.getfiveByCid(cid);
    }

}
