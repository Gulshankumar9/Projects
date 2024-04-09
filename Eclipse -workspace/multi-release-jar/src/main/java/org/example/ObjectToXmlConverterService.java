/**
 * 
 */
package org.example;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

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
		
		System.out.println("javax code executed");

		return xmlData;

	}
}
