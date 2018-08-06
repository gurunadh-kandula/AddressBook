package com.jda.controller;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.jda.service.AddressBookImpl;
import com.jda.utility.Utility;

public class AddressBookManagerImpl implements AddressBookManager {
	Utility utility = new Utility();

	public void create() throws IOException {
		System.out.println("Please enter the name of the addressbook you want to create");
		String addressbookname = utility.inputstring();

		File file = new File("C:\\Users\\1023404\\eclipse-workspace\\AddressBook\\addressbooks\\"+addressbookname + ".json");
		file.createNewFile();
		if (file.createNewFile())
			System.out.println("New addressbook created");
		else
			System.out.println("addressbook with this name already exists");

	}

	public void read(String filename) throws JsonParseException, JsonMappingException, IOException {
		AddressBookImpl addressbookimpl = new AddressBookImpl();
		addressbookimpl.read(filename);

	}

	public void readExistingAbs() {
		File file = new File("C:\\Users\\1023404\\eclipse-workspace\\AddressBook\\addressbooks");

		for (File f : file.listFiles()) {
			if (f.isFile()) {
				System.out.println(f.getName());

			}

		}

	}

	public void save(String filename) throws JsonGenerationException, JsonMappingException, IOException {
		AddressBookImpl addressbookimpl = new AddressBookImpl();
		addressbookimpl.save(filename);

	}

	public void saveAs(String filename) throws JsonGenerationException, JsonMappingException, IOException {
		AddressBookImpl addressbookimpl = new AddressBookImpl();
		addressbookimpl.saveAs(filename);
	}

	public void close(String filename) {
		AddressBookImpl addressbookimpl = new AddressBookImpl();
		addressbookimpl.close(filename);

	}

}
