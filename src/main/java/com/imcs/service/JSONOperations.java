package com.imcs.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.imcs.entity.Customer;

public class JSONOperations {

	public void serialize(Customer customer) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.writeValue(System.out, customer);
		File file = new File("f:\\Customer.json");
		mapper.writeValue(file, customer);

	}

	public void deserialize() throws IOException {
		byte[] jsonData = Files.readAllBytes(Paths.get("f:\\Customer.json"));
		ObjectMapper mapper = new ObjectMapper();
		Customer customer = mapper.readValue(jsonData, Customer.class);
		System.out.println(customer);
	}

}
