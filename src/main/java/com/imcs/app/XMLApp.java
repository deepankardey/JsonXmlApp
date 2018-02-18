package com.imcs.app;

import java.text.ParseException;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.imcs.entity.Address;
import com.imcs.entity.Customer;
import com.imcs.entity.Payment;
import com.imcs.service.XMLOperations;
import com.imcs.util.Utility;

public class XMLApp {

	public static void main(String[] args) throws ParseException, DatatypeConfigurationException, JAXBException {
		try {
			new XMLApp().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void execute()throws Exception {

		Address address=new Address();
		address.setStreet("1145 Oregon Ave");
		address.setCity("Beaumont");
		address.setState("TX");
		address.setZip(77705);
		
		Payment payment=new Payment();
		payment.setCardName("Deepankar");
		payment.setCardNumber("1234567890");
		payment.setCardType("CREDIT");
		
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(Utility.getDate("01/10/2016"));
		XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c1);
		
		payment.setDateFrom(startDate);
		
		
		Customer customer=new Customer();
		customer.setCustomerId(1);
		customer.setName("Deepankar");
		customer.setAddress(address);
		customer.setAnnualSalary(10000);
		
		GregorianCalendar c3 = new GregorianCalendar();
		c3.setTime(Utility.getDate("01/10/2016"));
		XMLGregorianCalendar dob = DatatypeFactory.newInstance().newXMLGregorianCalendar(c3);
		
		customer.setDateOfBirth(dob);
		
		customer.getPayment().add(payment);
		
		XMLOperations operations=new XMLOperations();
		System.out.println("Marshalling........");
		operations.marshall(customer);
		System.out.println("Unmarshalling.......");
		operations.unmarshall();
	}
}
