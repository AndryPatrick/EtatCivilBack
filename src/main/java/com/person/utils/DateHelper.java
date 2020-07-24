package com.person.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.person.Exception.DateFnParseException;

public class DateHelper {
	static final String dateFormat = "yyyy-MM-dd";
	static final String dateFormatTime = "yyyy-MM-dd HH:mm:ss";
	
	
	public static Date strToDate(final String dataString) throws DateFnParseException {
	    Date date = null;
	    if(dataString!=null && !dataString.isEmpty()) {
	        final DateFormat format = new SimpleDateFormat(dateFormat, Locale.FRENCH);
	        try {
	            date = format.parse(dataString);
	            final Calendar calendar = Calendar.getInstance();
	            calendar.setTime(date);
	            calendar.set(Calendar.HOUR_OF_DAY,0);
	            calendar.set(Calendar.MINUTE,0);
	            calendar.set(Calendar.SECOND,0);
	            calendar.set(Calendar.MILLISECOND,0);
	
	            date = calendar.getTime();
	        } catch (final ParseException e) {
	            throw new DateFnParseException(dataString);
	        }
	
	    }
	
	    return date;
	}
	
	public static String getStrYearMonthDateNow() {
	    final DateFormat format = new SimpleDateFormat("yyyyMM", Locale.FRENCH);
	    return format.format(new Date());
	}
	
	public static String getStrDateNow() {
	    final DateFormat format = new SimpleDateFormat(dateFormat, Locale.FRENCH);
	    return format.format(new Date());
	}
	
	public static String getStrDateNow(final String dateFormatStr) {
	    final DateFormat format = new SimpleDateFormat(dateFormatStr, Locale.FRENCH);
	    return format.format(new Date());
	}
	
	public static String dateToStr(final Date date) throws DateFnParseException{
	    String datestr = null;
	    final DateFormat format = new SimpleDateFormat(dateFormat, Locale.FRENCH);
	    if(date != null) {
	        datestr = format.format(date);
	    }
	    return datestr;
	}
	
	public static String dateToStr(final Date date, final String dateFormatStr) throws DateFnParseException{
	    String datestr = null;
	    final DateFormat format = new SimpleDateFormat(dateFormatStr, Locale.FRENCH);
	    if(date != null) {
	        datestr = format.format(date);
	    }
	    return datestr;
	}
	
	public static LocalDateTime strToDateTime(final String dataString) throws DateFnParseException{
	    LocalDateTime dateTime = null;
	    if(dataString!=null && !dataString.isEmpty()) {
	        try {
	            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatTime);
	            dateTime = LocalDateTime.parse(dataString, formatter);
	        }catch (final Exception e) {
	            throw new DateFnParseException();
	        }
	
	    }
	    return dateTime;
	}
	
	public static long getTimeStampNow() {
	    try {
	        Thread.sleep(200);
	    } catch (final InterruptedException e) {
	        e.printStackTrace();
	    }
	    final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    return timestamp.getTime();
	} 
	
	/**
	 * Format "HH:mm"
	 * @param time
	 * @return
	 */
	public static LocalTime strToTime(final String time) {
	    return LocalTime.parse(time);
	}
	
	
	public static LocalDateTime DateToLocalDateTime(final Date dateToConvert) {
	    return dateToConvert.toInstant()
	            .atZone(ZoneId.systemDefault())
	            .toLocalDateTime();
	}
	
	public static Date localDateToDate(final LocalDate localDate) {
	    return Date.from(localDate.atStartOfDay()
	            .atZone(ZoneId.of("Europe/Helsinki"))
	            .toInstant());
	}
	
	public static LocalDate DateTolocaDate( Date dateToConvert) {
	    return dateToConvert.toInstant()
	            .atZone(ZoneId.of("Europe/Helsinki"))
	            .toLocalDate();
	}
	
	public static Date getFirstDateInCurrentMonth() {
	    final Calendar calendar = Calendar.getInstance();
	    calendar.add(calendar.MONTH,-1);
	    final int lastDate = calendar.getActualMaximum(Calendar.DATE);
	
	    calendar.set(Calendar.DATE, lastDate);
	    return calendar.getTime();
	}
	
	public static Date getLastDateInCurrentMonth() {
	    final Calendar calendar = Calendar.getInstance();
	    final int lastDate = calendar.getActualMaximum(Calendar.DATE);
	
	    calendar.set(Calendar.DATE, lastDate);
	    return calendar.getTime();
	}
	
	public static String localDataTimeToStr(final LocalDateTime dateTime){
	    if (dateTime!=null) {
	        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        return dateTime.format(formatter);
	    }
	    return null;
	}
	
	public static long diffBetwennTwoDates(final Date firstDate, final Date secondDate) {
	    final long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
	    final long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    return diff;
	}
	
	public static Date getToDay() {
	    final Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.HOUR_OF_DAY,0);
	    calendar.set(Calendar.MINUTE,0);
	    calendar.set(Calendar.SECOND,0);
	    calendar.set(Calendar.MILLISECOND,0);
	    return calendar.getTime();
	
	}
	
	public static boolean checkDateIsBetweenTwoDates(final Date firstDate, Date secondDate,final Date testDate) {
	    //add one day to secondDate
	    final Calendar endDate = Calendar.getInstance(); 
	    endDate.setTime(secondDate); 
	    endDate.add(Calendar.DATE, 1);
	    secondDate= endDate.getTime();
	    
	    return testDate.after(firstDate) && testDate.before(secondDate);
	}
}

