package com.ssit.stage.common.utils;

import com.ssit.stage.common.constant.ConstantValue;
import com.ssit.stage.common.exception.BaseException;
import com.ssit.stage.common.exception.subtype.ParamInvalidException;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author Fs
 * @since 2017/5/7 19:07
 */
public class DateTimeUtils {
    private static final Log LOGGER = LogFactory.getLog(DateTimeUtils.class);
    private static final Date dateTime = new Date();

    public static String getFirstDay(int type) {
        Date date;
        switch (type) {
            case Calendar.YEAR:
            case Calendar.MONTH:
                date = DateUtils.truncate(dateTime, type);
                break;
            case Calendar.DAY_OF_WEEK:
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dateTime);
                calendar.setFirstDayOfWeek(Calendar.MONDAY);
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                date = DateUtils.truncate(calendar.getTime(), Calendar.DATE);
                break;
            default:
                BaseException exception = new ParamInvalidException();
                LOGGER.error(exception.getLogMessage("type", String.valueOf(type)));
                throw exception;
        }
        return DateFormatUtils.format(date, ConstantValue.DEFAULT_DATE_PATTERN);
    }

    public static String getLastDay(int type) {
        Date date;
        switch (type) {
            case Calendar.YEAR:
            case Calendar.MONTH:
                date = DateUtils.addDays(DateUtils.ceiling(dateTime, type), -1);
                break;
            case Calendar.DAY_OF_WEEK:
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dateTime);
                calendar.setFirstDayOfWeek(Calendar.MONDAY);
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                date = DateUtils.truncate(calendar.getTime(), Calendar.DATE);
                break;
            default:
                BaseException exception = new ParamInvalidException();
                LOGGER.error(exception.getLogMessage("type", String.valueOf(type)));
                throw exception;
        }
        return DateFormatUtils.format(date, ConstantValue.DEFAULT_DATE_PATTERN);
    }
}
