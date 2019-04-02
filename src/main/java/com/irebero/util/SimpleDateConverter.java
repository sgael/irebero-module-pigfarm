/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irebero.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author mcpaul
 */
public class SimpleDateConverter {

    private DateFormat sdf;
    static Log LOG = LogFactory.getLog(SimpleDateConverter.class.getName());

    public SimpleDateConverter() {
        this.sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    }

    public Date getDateFormatWithStringTokenizer(String date) {
        try {
            int dd, mm, yy;
            StringTokenizer st = null;
            if (date.contains("/")) {
                st = new StringTokenizer(date.substring(0, 10), "/");
            } else if (date.contains("-")) {
                st = new StringTokenizer(date.substring(0, 10), "-");
            }

            yy = Integer.parseInt(st.nextToken());
            mm = Integer.parseInt(st.nextToken());
            dd = Integer.parseInt(st.nextToken());
            date = dd + "/" + mm + "/" + yy;
            return sdf.parse(date);

        } catch (Exception e) {
            LOG.error(e.toString());

            return null;
        }
    }

    public Date getDateFormat(String date) {
        try {
            int dd, yy;
            String mm, hrs;
            String[] dateIn = date.split("-");

            yy = Integer.parseInt(dateIn[2]);
            mm = dateIn[1];
            dd = Integer.parseInt(dateIn[0]);
            hrs = dateIn[3];
            date = dd + "-" + mm + "-" + yy;
            LOG.error(date);
            return sdf.parse(date);

        } catch (Exception e) {
            LOG.error(e.toString());
            return null;
        }
    }

    public String format(String date) {
        try {
            int dd, mm, yy;
            StringTokenizer st = new StringTokenizer(date.substring(0, 10), "-");

            yy = Integer.parseInt(st.nextToken());
            mm = Integer.parseInt(st.nextToken());
            dd = Integer.parseInt(st.nextToken());
            Date date1 = sdf.parse(dd + "/" + mm + "/" + yy);
            return sdf.format(date1);

        } catch (Exception e) {
            LOG.error(e.toString());
            return null;
        }
    }

    public String getStringFormat(Date date) {
        try {
            return sdf.format(date);
        } catch (Exception e) {
            LOG.error(e.toString());
            return null;
        }
    }

    public static Date toLocalTZReturnDate(Date dateToConvert) {
        try {
            DateFormat gmtformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            gmtformat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return DateUtils.addHours(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(gmtformat.format(dateToConvert)), 2);

        } catch (ParseException e) {
            LOG.error(e.toString());
            return null;
        }
    }

    public static Date toReturnDate(Date dateToConvert) {
        try {
            DateFormat gmtformat = new SimpleDateFormat("dd-MM-yyyy");
            return new SimpleDateFormat("dd-MM-yyyy").parse(gmtformat.format(dateToConvert));

        } catch (ParseException e) {
            LOG.error(e.toString());
            return null;
        }
    }

    public static Date toReturnDateYYYY_MM_DD(Date dateToConvert) {
        try {
            DateFormat gmtformat = new SimpleDateFormat("yyyy-MM-dd");
            return new SimpleDateFormat("yyyy-MM-dd").parse(gmtformat.format(dateToConvert));

        } catch (ParseException e) {
            LOG.error(e.toString());
            return null;
        }
    }

    public static Date toReturnDateYYYY_MM_dd_hh_mm(Date dateToConvert) {
        try {
            DateFormat gmtformat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            return new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(gmtformat.format(dateToConvert));

        } catch (ParseException e) {
            LOG.error(e.toString());
            return null;
        }
    }

    public static long toLocalTZReturnYear(Date datetToConvert) {
        try {
            DateFormat gmtformat = new SimpleDateFormat("yyyy");
            gmtformat.setTimeZone(TimeZone.getTimeZone("GMT"));

            return DateUtils.addHours(new SimpleDateFormat("yyyy").parse(gmtformat.format(datetToConvert)), 2).getTime() / 12 / 30 / 24 / 3600;

        } catch (ParseException e) {
            LOG.error(e.toString());
            return 0;
        }
    }

    public static Date addDays(Date date, int days) {
        try {
//            SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//            sd.setTimeZone(TimeZone.getTimeZone("GMT-2:00"));
            Date dateValue = date;
//            System.out.println(dateValue);
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-2:00")); // set correct timezone to calendar
            calendar.setTime(dateValue);
            calendar.add(Calendar.DAY_OF_MONTH, days);
            dateValue = calendar.getTime();
//            System.out.println(dateValue); // prints "Wed Sep 23 14:00:00 CEST 2015"
            return dateValue;
        } catch (Exception e) {
            LOG.error(e.toString());
        }
        return null;
    }

    public static Date addMonth(Date date, int days) {
        try {
//            SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//            sd.setTimeZone(TimeZone.getTimeZone("GMT-2:00"));
            Date dateValue = date;
//            System.out.println(dateValue);
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-2:00")); // set correct timezone to calendar
            calendar.setTime(dateValue);
            calendar.add(Calendar.MONTH, days);
            dateValue = calendar.getTime();
//            System.out.println(dateValue); // prints "Wed Sep 23 14:00:00 CEST 2015"
            return dateValue;
        } catch (Exception e) {
            LOG.error(e.toString());
        }
        return null;
    }

    public static Date toDateIn_yyyy_MM_dd_hh(Date d) {
        try {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh");
            return sdf.parse(new SimpleDateFormat("yyyy-MM-dd hh").format(d));
        } catch (ParseException e) {
            LOG.error(e.toString());
        }

        return null;
    }

    public DateFormat getSdf() {
        return sdf;
    }

    public void setSdf(DateFormat sdf) {
        this.sdf = sdf;
    }

}
