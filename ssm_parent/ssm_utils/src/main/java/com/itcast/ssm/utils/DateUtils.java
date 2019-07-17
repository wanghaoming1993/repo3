package com.itcast.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {





    public static String toString(Date date, String patt){
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        String format = sdf.format(date);

        return format;
    }
}
