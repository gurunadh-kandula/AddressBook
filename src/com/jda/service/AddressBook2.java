package com.jda.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jda.utility.Utility;

public class AddressBook2 {
	Utility utility = new Utility();
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection("jdbc:mysql://localhost/Address?" + "user=guru&password=guru");

			statement = connect.createStatement();

			resultSet = statement.executeQuery("select * from Address.person");
			writeResultSet(resultSet);

		} catch (Exception e) {
			throw e;
		}
	}

	public void add() throws Exception {
		readDataBase();
		preparedStatement = connect.prepareStatement("insert into  Address.person values ( ?, ?, ?, ? , ?, ?)");
		System.out.println("Enter the first name of the person");
		preparedStatement.setString(1, utility.inputstring());
		System.out.println("Enter the last name of the person");
		preparedStatement.setString(2, utility.inputstring());
		System.out.println("enter the phonenumber");
		preparedStatement.setString(3, utility.inputstring());
		System.out.println("please enter the zip");
		preparedStatement.setString(4, utility.inputstring());
		System.out.println("please enter the city");
		preparedStatement.setString(5, utility.inputstring());
		System.out.println("please enter the state");
		preparedStatement.setString(6, utility.inputstring());
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement(
				"SELECT   FIRSTNAME , LASTNAME ,  PHONENUMBER , ZIP , CITY,STATE from Address.person");
		resultSet = preparedStatement.executeQuery();
		writeResultSet(resultSet);

	}

	public void remove() throws Exception {

		readDataBase();
		System.out.println("please enter the firstname of the person");
		String input = utility.inputstring();
		PreparedStatement preparedStmt = connect.prepareStatement("delete from Address.person where firstname=?;");
		preparedStmt.setString(1, input);
		preparedStmt.executeUpdate();

	}

	public void edit() throws Exception {
		readDataBase();
		System.out.println("please enter 1.for editing phone number 2.for editing city");
		int i = utility.inputInteger();
		if (i == 1) {
			System.out.println("please enter the firstname of the person");
			String input = utility.inputstring();

			System.out.println("please enter the new phone number");
			String input1 = utility.inputstring();
			PreparedStatement preparedStmt = connect
					.prepareStatement("update  Address.person set phonenumber=? where firstname=?;");
			preparedStmt.setString(1, input1);
			preparedStmt.setString(2, input);

			preparedStmt.executeUpdate();

		} else {
			System.out.println("please enter the firstname of the person");
			String input = utility.inputstring();
			System.out.println("please enter the city u want to edit");
			String input1 = utility.inputstring();
			PreparedStatement preparedStmt = connect
					.prepareStatement("update  Address.person set city=? where firstname=?;");
			preparedStmt.setString(1, input1);
            preparedStmt.setString(2, input);
			preparedStmt.executeUpdate();

		}

	}

	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

	public void writeResultSet(ResultSet resultSet) throws SQLException {

		while (resultSet.next()) {

			String firstname = resultSet.getString("firstname");
			String lastname = resultSet.getString("lastname");
			String phonenumber = resultSet.getString("phonenumber");
			String zip = resultSet.getString("zip");
			String city = resultSet.getString("city");
			String state = resultSet.getString("state");
			System.out.println("firstname: " + firstname);
			System.out.println("lastname: " + lastname);
			System.out.println("phonenumber: " + phonenumber);
			System.out.println("zip: " + zip);
			System.out.println("city: " + city);
			System.out.println("state: " + state);
		}
	}

}