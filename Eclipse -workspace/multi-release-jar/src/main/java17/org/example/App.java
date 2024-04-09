package org.example;

import java.util.logging.Logger;

public class App {
	public static Logger LOG = Logger.getLogger(App.class.getName());

	public static void main(String[] args) throws Exception {

		String dateToCheck = args[0];

		boolean isLeapYear = DateHelper.checkIfLeapYear(dateToCheck);

		LOG.info("Date given " + dateToCheck + " is leap year: " + isLeapYear);

		Student student = new Student(17, "this is", "using", "jakarta");

		ObjectToXmlConverterService converterService = new ObjectToXmlConverterService();

		System.out.println(converterService.convertObjectToXml(student));

	}
}