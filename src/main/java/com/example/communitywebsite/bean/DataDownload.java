package com.example.communitywebsite.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataDownload {
    private int did;
    private int cid;
    private String dataname;
    private String dataurl;
    private String createdate;
    private int countdown;
}
