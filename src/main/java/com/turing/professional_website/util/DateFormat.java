package com.turing.professional_website.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jack
 * @date 2019-04-17-11:04
 */
public class DateFormat {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getNowTime(){
        return simpleDateFormat.format(new Date());
    }

}
