package com.jda.model;

public class Address {

	String city;
	String state;
	long zip;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZip() {
		return zip;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "\n { \"city\"  : " + city + "\n  \"state\" : " + state + "\n  \"zip\" : " + zip+"}" ;
	}

}
