package com.imcs.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.imcs.entity.Customer;

public class XMLOperations {

	public void marshall(Customer customer) throws JAXBException{
		JAXBContext context=JAXBContext.newInstance(Customer.class);
		Marshaller marshaller=context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		File file=new File("customer.xml");
		marshaller.marshal(customer, System.out);
		marshaller.marshal(customer, file);
		
	}
	
	public void unmarshall() throws JAXBException{
		JAXBContext context=JAXBContext.newInstance(Customer.class);
		Unmarshaller unmarshaller=context.createUnmarshaller();
		File file=new File("customer.xml");
		Customer customer=(Customer) unmarshaller.unmarshal(file);
		System.out.println(customer);
	}
}
