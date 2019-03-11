package com.nujnay.moment.server;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String date = "2018/11/2 15:11:00";
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date2 = new Date(date);
            Date s = simpleDateFormat.parse(date);
            simpleDateFormat.format(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
