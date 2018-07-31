package com.justcode.unmarshalling.jaxbunmarshalling;

import java.io.File;
import java.io.StringReader;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.justcode.unmarshalling.jaxbunmarshalling.generated.*;



public class XmlToJavaObjects {

	public static void main(String[] args) throws JAXBException,Exception {
		// 1. We need to create JAXContext instance
		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		// 2. Use JAXBContext instance to create the Unmarshaller.
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		SchemaFactory sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("expense.xsd"));
		unmarshaller.setSchema(schema);
		// unmarshaller.setEventHandler(new MyValidationEventHandler());

		// 3. Use the Unmarshaller to unmarshal the XML document to get an
		// instance of JAXBElement.
		/* JAXBElement<ExpenseT> unmarshalledObject =(JAXBElement<ExpenseT>) */
JAXBElement<ExpenseT> unmarshalledObject = (JAXBElement<ExpenseT>) unmarshaller.unmarshal(ClassLoader.getSystemResourceAsStream("com/justcode/unmarshalling/jaxbunmarshalling/expense.xml"));

		// 4. Get the instance of the required JAXB Root Class from the
		// JAXBElement.
		ExpenseT expenseObj = unmarshalledObject.getValue();
		UserT user = expenseObj.getUser();
		ItemListT items = expenseObj.getItems();

		// Obtaining all the required data from the JAXB Root class instance.
		System.out.println("PrintingExpense for: " + user.getUserName());
		for (ItemT item : items.getItem()) {
			System.out.println(item.getItemName());
			System.out.println(item.getAmount());
			System.out.println(item.getNumber());
			System.out.println(item.getType());
			System.out.println("Dateurchase: " + item.getPurchasedOn());
		}

	}

}
