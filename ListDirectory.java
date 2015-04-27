/*
 * FINAL
 * AUTHOR:Sanzhar Zholdiyarov;
 * STUDENT NUMBER: 110562618;
 * CSC1022 ASSIGNMENT 1
 * DATE CREATED: 21.03.2014;
 * CLASS: ListDirectory;
 * PURPOSE: Store entries in the List;
 */
import java.util.Collections;
import java.util.LinkedList;

public class ListDirectory implements Directory {

	LinkedList<Entry> linkedList = new LinkedList<Entry>();

	/* Evertime when adding new element it does sorting */
	@Override
	public void addEntry(Entry entry) {
		sort();
		linkedList.add(entry);
		System.out.println(entry.toString() + " IS ADDED TO THE LIST");
	}

	/*
	 * Method simply do iteration through all the list to delete appropriate
	 * entry
	 */
	@Override
	public void deleteEntry(String name, String number) {
		if (name != null) {
			for (int i = 0; i < linkedList.size(); i++) {
				if (linkedList.get(i).getSurname().equals(name)) {
					System.out.println(linkedList.get(i).getSurname()
							+ " is deleted");
					linkedList.remove(i);
					return;
				}
			}
			System.out.println("ENTRY DOES NOT EXIST");

		} else if (Integer.parseInt(number) != 0) {
			for (int i = 0; i < linkedList.size(); i++) {
				if (linkedList.get(i).getNumber() == Integer.parseInt(number)) {
					System.out.println(linkedList.get(i).getSurname()
							+ " is deleted");
					linkedList.remove(i);
					return;
				}
			}
			System.out.println("ENTRY DOES NOT EXIST");
		}
		sort(); // Sort after deleting
	}

	/* Method simply do iteration through all the list to find appropriate entry */
	@Override
	public void findEntry(String name) {
		for (int i = 0; i < linkedList.size(); i++) {
			if (linkedList.get(i).getSurname().equals(name)) {
				System.out.println(linkedList.get(i).getSurname()
						+ "'s number is : "
						+ String.format("%04d", linkedList.get(i).getNumber()));
				return;
			}

		}
		System.out.println("Could not find");
	}

	@Override
	public void changeNumber(String name, String changeNumber) {
		for (int i = 0; i < linkedList.size(); i++) {
			if (linkedList.get(i).getSurname().equals(name)) {
				linkedList.get(i).setNumber(changeNumber);
				return;
			}
		}
	}

	@Override
	public void printDirectory() {
		String leftFormat = "| %-14s | %-8s | %-9s |%n";
		System.out.format("+----------------+----------+-----------+%n");
		System.out.printf("| Surname        | Initials | Ex.number |%n");
		System.out.format("+----------------+----------+-----------+%n");

		for (int i = 0; i < linkedList.size(); i++) {
			System.out.format(leftFormat, linkedList.get(i).getSurname(),
					linkedList.get(i).getInitials(),
					String.format("%04d", linkedList.get(i).getNumber()));
		}

		System.out.format("+----------------+----------+-----------+%n");

	}

	/* Sorting the list of entries using comparator in "Entry" class */
	private void sort() {
		Collections.sort(linkedList, Entry.surnameComparator);
	}
}
