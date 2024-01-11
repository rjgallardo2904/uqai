package com.uqai.VehicleMaintenanceBack.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class CalendarDay {
    public static String calcularMantenimiento(String dateRequest) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int baseDayMaint=84;
        String stringDat=addDate(dateRequest,-baseDayMaint);
        Date datefinalMainte= sdf.parse(stringDat);
        Date datEnd= sdf.parse(dateRequest);
        int extraDay=dayAditional(datefinalMainte,datEnd);
        baseDayMaint= baseDayMaint+extraDay;
        stringDat=addDate(dateRequest,-baseDayMaint);
        return stringDat;
    }
    private static String addDate(String dateRequest, int dayAdd) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        Date dateBegin=sdf.parse(dateRequest);
        c.setTime(dateBegin);
        c.add(Calendar.DATE, dayAdd);  // number of days to add
        String dt = sdf.format(c.getTime());
        return dt;
    }
    private static int dayAditional(Date datebegin, Date dateEnd){
        AtomicInteger dayAd= new AtomicInteger(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Stream<String> listHolyDay = Arrays.stream(HolyDay.listHoliday);
        listHolyDay.forEach((e)->{
            try {
                Date dateConvert= sdf.parse(e);
                if(dateConvert.after(datebegin) && dateConvert.before(dateEnd)){
                    dayAd.getAndIncrement();
                }
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Displaying elements in Stream

        return dayAd.get();
    }
}
