package com.example.communitywebsite.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
    //  时间格式转换
    public String getStringDate(){
        Date currentDate = new Date();
        SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleformat.format(currentDate);
        return dateStr;
    }
}
