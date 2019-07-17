package com.itcast.ssm.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date=null;
        try {
             date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;

    }
}
