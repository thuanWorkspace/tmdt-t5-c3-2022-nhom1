package com.example.tmdtnhom1.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static String DatetoString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return dateFormat.format(date);
    }

    public static Date StringtoDate(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date addDate(Date date, int hour)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour); //minus number would decrement the days
        return cal.getTime();
    }

    public static Date currentDate(){
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
}
