package com.example.tankstellenbackend.application;


import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MyDateFormatter implements Formatter<LocalDate> {
    public static final String DE_DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {

        System.out.println("parsing wird aufgerufen, " + s);
        return LocalDate.parse(s, DateTimeFormatter.ofPattern(DE_DATE_FORMAT));
    }

    @Override
    public String print(LocalDate localDate, Locale locale) {
        return DateTimeFormatter.ofPattern(DE_DATE_FORMAT).format(localDate);
    }
}
