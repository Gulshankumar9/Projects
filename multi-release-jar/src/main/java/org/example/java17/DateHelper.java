package org.example.java17;

import java.time.LocalDate;
import java.util.logging.Logger;

class DateHelper {
    public static Logger LOG = Logger.getLogger(DateHelper.class.getName());
    public static boolean checkIfLeapYear(String dateStr) throws Exception {
        LOG.info("Checking for leap year using Java 9 Date Api");
        return LocalDate.parse(dateStr).isLeapYear();
    }
}