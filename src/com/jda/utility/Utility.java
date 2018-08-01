package com.jda.utility;

import java.util.Scanner;

public class Utility {

	Scanner scaninput;

	public Utility() {
		scaninput = new Scanner(System.in);
	}

	public String inputString() {
		String input = scaninput.nextLine();
		return input;
	}

	public String inputstring() {
		String input = scaninput.next();
		return input;
	}

	public int inputInteger() {
		int input = scaninput.nextInt();
		return input;

	}

}
