/*
 * FINAL
 * AUTHOR:Sanzhar Zholdiyarov;
 * STUDENT NUMBER: 110562618;
 * CSC1022 ASSIGNMENT 1
 * DATE CREATED: 21.03.2014;
 * CLASS: Entry;
 * PURPOSE: Store individual entry;
 */
import java.util.Comparator;

public class Entry {

	private String surname;
	private String initials;
	private int number;

	// Constructor
	public Entry(String surname, String initials, String number) {
		this.surname = surname;
		this.initials = initials;
		this.number = Integer.parseInt(number); // Parses the string
												// argument as a signed
												// decimal integer.

	}

	/* GET methods */
	public String getSurname() {
		return surname;
	}

	public String getInitials() {
		return initials;
	}

	public int getNumber() {
		return number;
	}

	/* Method to set numbers(used to change the number) */
	public void setNumber(String changeNumber) {
		this.number = Integer.parseInt(changeNumber);
	}

	public String toString() {
		return "Entry(" + getSurname() + ", " + getInitials() + ", "
				+ String.format("%04d", getNumber()) + ")";
	}

	/* Comparator to compare entry's surname */
	public static Comparator<Entry> surnameComparator = new Comparator<Entry>() {
		public int compare(Entry e1, Entry e2) {
			return e1.getSurname().compareTo(e2.getSurname());
		}
	};

}
