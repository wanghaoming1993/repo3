package com.itcast.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public static String getPassword(String password){
     return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String a="123";
        String password = getPassword(a);
        System.out.println(password);
    }
}
