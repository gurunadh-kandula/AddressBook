package com.jda.service;

import com.jda.utility.Utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.jda.model.*;

public class AddressBookImpl implements AddressBook {
	Utility utility = new Utility();
	public static ArrayList<Person> list = new ArrayList<Person>();
	ObjectMapper mapper = new ObjectMapper();

	private Person createUser() {
		Person person = new Person();
		Address address = new Address();
		System.out.println("Enter First Name");
		person.setFirstName(utility.inputstring());
		System.out.println("Enter Last Name");
		person.setLastName(utility.inputstring());
		System.out.println("Enter city");
		address.setCity(utility.inputstring());
		System.out.println("Enter State");
		address.setState(utility.inputstring());
		System.out.println("Enter ZipCode");
		address.setZip(utility.inputInteger());
		System.out.println("Enter Phone Number");
		person.setPhoneNumber(utility.inputstring());
		person.setAddress(address);
		return person;
	}

	public void add(String filename) throws JsonGenerationException, JsonMappingException, IOException {
		read(filename);
		list.add(createUser());
		save(filename);
		}

	static int found = 0;

	public void edit(String filename) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Enter first name of the person whose data should be modified");
		String firstName = utility.inputString();
		for (Person P : list) {
			if (firstName.equals(P.getFirstName())) {
				found++;
				System.out.println(P);
				System.out.println("1. To edit Address   " + "2. To edit Phone Number    "+"3.If this person is not the person whose data should be edited");
				int editChoice = utility.inputInteger();
				switch (editChoice) {
				case 1:
					editAddress(P);
					save(filename);
					break;
				case 2:
					editPhoneNo(P);
					save(filename);
					break;
				case 3:
					break;

				}
			}
		}
		if (found == 0)
			System.out.println("Data not found");
	}

	private void editAddress(Person P) {

		System.out.println("Enter the state");
		P.getAddress().setState(utility.inputstring());
		System.out.println("Enter the city");
		P.getAddress().setCity(utility.inputstring());
		System.out.println("Enter the ZipCode");
		P.getAddress().setZip(utility.inputInteger());
		System.out.println("Address updated");

	}

	private void editPhoneNo(Person P) {
		System.out.println("Enter the new Phone Number");
		String phoneNumber = utility.inputstring();
		P.setPhoneNumber(phoneNumber);
		System.out.println("phone number updated");

	}

	public void remove(String filename) throws Exception {
		System.out.println("Enter first name whose data is to be removed");
		String firstName = utility.inputString();
		int count = 0;
		ArrayList<Person> remove = new ArrayList<>();
		for (Person P : list) {
			if (firstName.equals(P.getFirstName())) {

				remove.add(P);
				count++;
			}
		}
		list.removeAll(remove);
		save(filename);
		if (count == 0)
			System.out.println("Data not found");
	}

	public void sortByName(String filename) throws JsonGenerationException, JsonMappingException, IOException {
		Collections.sort(list, new SortByName());
		save(filename);

	}

	public void sortByZip(String filename) throws JsonGenerationException, JsonMappingException, IOException {
		Collections.sort(list, new SortByZip());
		save(filename);

	}

	public class SortByName implements Comparator<Person> {
		public int compare(Person personOne, Person personTwo) {
			if (personOne.getLastName().equals(personTwo.getLastName()))
				return 0;
			else {
				if (personOne.getLastName().compareTo(personTwo.getLastName()) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	}

	public class SortByZip implements Comparator<Person> {
		public int compare(Person p1, Person p2) {
			if (p1.getAddress().getZip() == p2.getAddress().getZip())
				return 0;
			else {
				if (p1.getAddress().getZip() > p2.getAddress().getZip()) {
					return 1;
				} else {
					return -1;
				}
			}
		}

	}

	public void print(String filename) throws JsonParseException, JsonMappingException, IOException {
		 File newFile = new File("C:\\Users\\1023404\\eclipse-workspace\\AddressBook\\addressbooks\\"+filename + ".json");
		 if (newFile.length() == 0) 
		 System.out.println("File is empty");
		 else  
        {read(filename);
		for (Person P : list) {
			System.out.println(P.toString());
		}
        }
	}

	public void save(String filename) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\Users\\1023404\\eclipse-workspace\\AddressBook\\addressbooks\\"+filename + ".json"), list);
        System.out.println(".....AddressBook Saved....");
	}

	public void read(String filename) throws JsonParseException, JsonMappingException, IOException {

		list = mapper.readValue(new File("C:\\Users\\1023404\\eclipse-workspace\\AddressBook\\addressbooks\\"+filename + ".json"), new TypeReference<ArrayList<Person>>() {
		});

	}

	public void close(String filename) {
		list.clear();

	}

	public void saveAs(String filename) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Enter the new name");
		String newname = utility.inputstring();
		read(filename);
		save(newname);
		System.out.println("File renamed");

	}

}
