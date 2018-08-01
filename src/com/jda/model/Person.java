package com.jda.model;

public class Person {
String firstname;
String lastname;
Address address;
String phonenumber;

public String getFirstName() {
	return firstname;
}

public void setFirstName(String firstname) {
	this.firstname = firstname;
}

public String getLastName() {
	return lastname;
}

public void setLastName(String lastname) {
	this.lastname = lastname;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public String getPhoneNumber() {
	return phonenumber;
}

public void setPhoneNumber(String phonenumber) {
	this.phonenumber = phonenumber;
}

@Override
public String toString() {
	return "\n{ \"first Name\" : " + firstname + "\n\"last Name\"  : " + lastname + "\n\"address\" : " + address + "\n\"phone Number\" : "
			+ phonenumber + "}";
}




	
}
