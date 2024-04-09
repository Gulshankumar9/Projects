package org.example;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class DateHelper {

	private static final Logger LOG = Logger.getLogger(DateHelper.class.getName());

	public static boolean checkIfLeapYear(String dateStr) {

		LOG.info("Checking for leap year using Java 11 date-time API");

		LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);

		return Year.isLeap(date.getYear());
	}
}
