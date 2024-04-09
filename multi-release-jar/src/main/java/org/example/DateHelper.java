package org.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
class DateHelper {

    public static Logger LOG = Logger.getLogger(DateHelper.class.getName());

    public static boolean checkIfLeapYear(String dateStr) throws Exception {
        LOG.info("Checking for leap year using Java 1 calendar API ");

        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr));
        int year = cal.get(Calendar.YEAR);

        return (new GregorianCalendar()).isLeapYear(year);
    }
}