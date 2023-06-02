package com.codals.greating.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String dateToString(Date date) {
        if(date == null) {
            throw new IllegalArgumentException("인자가 잘못되었어요!!");
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String dateToDay(Date date) {
        if(date == null) {
            throw new IllegalArgumentException("인자가 잘못되었어요!!");
        }
        return new SimpleDateFormat("E", Locale.KOREA).format(date);
    }
}
