/*
 * FINAL
 * AUTHOR:Sanzhar Zholdiyarov;
 * STUDENT NUMBER: 110562618;
 * CSC1022 ASSIGNMENT 1
 * DATE CREATED: 21.03.2014;
 * CLASS: HashDirectory;
 * PURPOSE: Store entries in the List, but lists are in the array;
 */
import java.util.LinkedList;
import java.util.ListIterator;

public class HashDirectory implements Directory {

	LinkedList<Entry>[] directoryArray = new LinkedList[26];
	private int position;

	// Constructor
	public HashDirectory() {
		for (int i = 0; i < directoryArray.length; i++) {
			directoryArray[i] = new LinkedList<Entry>();
		}
	}

	/* Before adding new entry the method does hashing */
	@Override
	public void addEntry(Entry entry) {
		position(entry.getSurname());
		directoryArray[position].add(entry);
		System.out.println(entry.toString() + " added");
	}

	@Override
	public void deleteEntry(String name, String number) {
		if (name != null) {
			position(name);
			ListIterator<Entry> iterator = directoryArray[position]
					.listIterator();
			while (iterator.hasNext()) {
				Entry entry = iterator.next();
				if (entry.getSurname().equals(name)) {
					iterator.remove();
					System.out.println("Successfully deleted");
					return;
				} else {
					System.out.println("Not in the directory");
				}

			}
		} else if (Integer.parseInt(number) != 0) {
			for (int i = 0; i < directoryArray.length; i++) {
				ListIterator<Entry> iterator = directoryArray[i].listIterator();
				while (iterator.hasNext()) {
					Entry entry = iterator.next();
					if (entry.getNumber() == Integer.parseInt(number)) {
						iterator.remove();
						System.out.println("Successfully deleted");
						return;
					}
				}
			}
		}

	}

	@Override
	public void findEntry(String name) {
		position(name);
		ListIterator<Entry> iterator = directoryArray[position].listIterator();
		while (iterator.hasNext()) {
			Entry myEntry = iterator.next();
			if (myEntry.getSurname().equals(name)) {
				System.out.println(name + "'s number is "
						+ String.format("%04d", myEntry.getNumber()));
				return;
			} else {
				System.out.println("Not in the directory");
			}
		}
	}

	@Override
	public void changeNumber(String name, String changeNumber) {
		position(name);
		ListIterator<Entry> iterator = directoryArray[position].listIterator();
		while (iterator.hasNext()) {
			Entry myEntry = iterator.next();
			if (myEntry.getSurname().equals(name)) {
				myEntry.setNumber(changeNumber);
				System.out.println("Successfully changed number : "
						+ String.format("%04d", myEntry.getNumber()));
				return;
			} else {
				System.out.println("Not in the directory");
			}
		}
	}

	@Override
	public void printDirectory() {
		String leftFormat = "| %-14s | %-8s | %-9s |%n";
		System.out.format("+----------------+----------+-----------+%n");
		System.out.printf("| Surname        | Initials | Ex.number |%n");
		System.out.format("+----------------+----------+-----------+%n");
		for (int i = 0; i < directoryArray.length; i++) {
			ListIterator<Entry> iterator = directoryArray[i].listIterator();
			while (iterator.hasNext()) {
				Entry myEntry = iterator.next();
				System.out.format(leftFormat, myEntry.getSurname(),
						myEntry.getInitials(),
						String.format("%04d", myEntry.getNumber()));
			}
		}
		System.out.format("+----------------+----------+-----------+%n");

	}

	// Get the hashing
	public int position(String name) {
		return position = (int) Character.toLowerCase(name.charAt(0)) - 97;
	}

}
