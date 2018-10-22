package com.example.exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws ParseException {

        Map map = new HashMap();
        map.put("s", "01");

    }
    private static String getLastDay(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
        Date date = null;
        try {
            date = df.parse(dateStr);
        }
        catch (ParseException e) {
        }
        df = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return df.format(calendar.getTime());
    }

}
