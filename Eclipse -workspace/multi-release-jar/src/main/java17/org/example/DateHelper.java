package org.example;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

public class DateHelper {

	private static final Logger LOG = Logger.getLogger(DateHelper.class.getName());

	public static boolean checkIfLeapYear(String dateStr) {
		LOG.info("Checking for leap year using Java 17 date-time API");

		try {
			return LocalDate.parse(dateStr).isLeapYear();
		} catch (DateTimeParseException e) {

			LOG.warning("Invalid date format: " + dateStr);

			throw new DateTimeException("Invalid date format");// Or throw a custom exception for better control
		}
	}
}
