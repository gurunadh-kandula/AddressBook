package com.jda.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public interface AddressBookManager {
	public void create()throws IOException;

	public void save(String filename)throws JsonGenerationException, JsonMappingException, IOException;

	public void saveAs()throws JsonGenerationException, JsonMappingException, IOException;

	public void close(String filename);

}
