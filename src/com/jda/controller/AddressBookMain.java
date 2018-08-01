package com.jda.controller;

import com.jda.service.AddressBookImpl;
import com.jda.utility.Utility;

public class AddressBookMain {
	public static void main(String args[]) throws Exception {
		Utility utility = new Utility();
		int choice;
		int select;
		AddressBookManagerImpl addressbookmanagerimpl = new AddressBookManagerImpl();
		String existingfilename = " ";
		do {
			AddressBookImpl addressbookimpl = new AddressBookImpl();
			System.out.println("WELCOME TO ADDRESS BOOK APPLICATION");
			System.out.println("*********************");
			System.out.println("MAIN MENU----");
			System.out.println(
					"1.create new addressbook   2.open existing addressbooks   3.save addressbook    4.save as   5.close address book application");
			choice = utility.inputInteger();
			switch (choice) {
			case 1:
				addressbookmanagerimpl.create();
				addressbookmanagerimpl.close(existingfilename);
				break;
			case 2:
				addressbookmanagerimpl.close(existingfilename);
				System.out.println("These are the Existing AddressBooks");
				addressbookmanagerimpl.readExistingAbs();
				System.out.println("Enter the name of the address book");
				existingfilename = utility.inputstring();
                System.out.println("FUNCTIONS WHICH CAN BE PERFORMED ON THE ADDRESS BOOK");
				do {
					System.out.println("1.ADD  2.EDIT 3.DELETE 4.SORT BY NAME 5. SORT BY ZIP 6.PRINT 7.CLOSE");
					select = utility.inputInteger();
					switch (select) {
					case 1:
						addressbookimpl.add(existingfilename);
						break;
					case 2:
						addressbookimpl.edit(existingfilename);
						break;
					case 3:
						addressbookimpl.remove(existingfilename);
						break;
					case 4:
						addressbookimpl.sortByName(existingfilename);
						break;
					case 5:
						addressbookimpl.sortByZip(existingfilename);
						break;
					case 6:
						addressbookimpl.print(existingfilename);
						break;
					case 7:
						System.out.println("AddressBook  " + existingfilename + "  closed");
						System.out.println("**redirecting to back menu**");
						addressbookimpl.close(existingfilename);
						select=0;

					}

				} while (select != 0);

				break;
			case 3:
				addressbookmanagerimpl.save(existingfilename);
				break;
			case 4:
				addressbookmanagerimpl.saveAs();
				break;
			case 5:
				System.out.println("Closing address book appliaction");
				choice = 0;
				break;
			default:
				System.out.println("wrong choice");
				choice = 0;
				break;

			}

		} while (choice != 0);

	}

}