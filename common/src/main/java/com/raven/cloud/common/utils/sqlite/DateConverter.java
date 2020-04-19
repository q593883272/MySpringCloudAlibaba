package com.raven.cloud.common.utils.sqlite;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<Date, String> {

    private DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String convertToDatabaseColumn(Date attribute) {
        String formatDate = null;
        try {
            formatDate = dateTimeFormat.format(attribute);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    @Override
    public Date convertToEntityAttribute(String dbData) {
        Date parseDate = null;
        try {
            parseDate = dateTimeFormat.parse(dbData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parseDate;
    }
}
