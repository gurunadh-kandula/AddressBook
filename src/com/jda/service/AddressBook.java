package com.jda.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public interface AddressBook {

	public void add(String filename) throws JsonGenerationException, JsonMappingException, IOException;

	public void edit(String filename) throws JsonGenerationException, JsonMappingException, IOException;

	public void remove(String filename) throws Exception;

	public void sortByName(String filename) throws JsonGenerationException, JsonMappingException, IOException;

	public void sortByZip(String filename) throws JsonGenerationException, JsonMappingException, IOException;

	public void print(String filename) throws JsonParseException, JsonMappingException, IOException;
}
