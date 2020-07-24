package com.person.utils;


import java.sql.Date;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Date & Time Utilities
 */
@Converter(autoApply = true)
public class DateUtils implements AttributeConverter<LocalDate, Date>
{

    private static SimpleDateFormat frDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    private static DateFormat frDateTextFormatter = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);

    /**
     * Format into FR Date format
     * @param date
     * @return
     */
    public static String toFr(Date date)
    {
        return date != null ? frDateFormatter.format(date) : "";
    }

    /**
     * Format into FR Date format
     * @param date
     * @return
     */
    public static String toFrText(Date date)
    {
        return date != null ? frDateTextFormatter.format(date) : "";
    }

    /**
     * P
     * @param dateStr
     * @return
     */
/*    public static Date fromString(String dateStr)
    {
        try {
            return frDateFormatter.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    } */

	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) {
		return localDate == null ? null : Date.valueOf(localDate);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate) {
		// TODO Auto-generated method stub
		return sqlDate == null ? null : sqlDate.toLocalDate();
	}

}
