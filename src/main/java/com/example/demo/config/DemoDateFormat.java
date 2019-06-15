package com.example.demo.config;

import java.text.*;
import java.util.Date;

public class DemoDateFormat extends java.text.DateFormat {
    private DateFormat dateFormat;

    private SimpleDateFormat format1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

    public DemoDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return dateFormat.format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        Date date = null;
        try {
            date = format1.parse(source, pos);
        } catch (Exception e) {
            date = dateFormat.parse(source, pos);
        }
        return date;
    }

    // 主要还是装饰这个方法
    @Override
    public Date parse(String source) throws ParseException {
        Date date = null;
        try {
            date = format1.parse(source);
        } catch (Exception e) {
            date = dateFormat.parse(source);
        }
        return date;
    }

    @Override
    public Object clone() {
        Object format = dateFormat.clone();
        return new DemoDateFormat((DateFormat) format);
    }
}
