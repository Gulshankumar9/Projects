/**
 * 
 */
package org.example;

import java.io.StringWriter;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

/**
 * 
 */
public class ObjectToXmlConverterService {

	public String convertObjectToXml(Student student) throws Exception {

		JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

		StringWriter writer = new StringWriter();

		Marshaller marshaller = jaxbContext.createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		marshaller.marshal(student, writer);

		String xmlData = writer.toString();

		writer.close();
		
		System.out.println("jakarta code executed");

		return xmlData;

	}
}
