/*
 * FINAL
 * AUTHOR:Sanzhar Zholdiyarov;
 * STUDENT NUMBER: 110562618;
 * CSC1022 ASSIGNMENT 1 
 * DATE CREATED: 21.03.2014;
 * CLASS: ArrayDirectory;
 * PURPOSE: Store entries in the arrays;
 */
public class ArrayDirectory implements Directory {

	Entry[] directory;

	private String notFound = "Not in the directory";

	// Constructor to create array with size of 0
	public ArrayDirectory() {
		directory = new Entry[0];
	}

	/*
	 * Adding new entries to the array. Before adding it does binary search to
	 * find appropriate position
	 */
	@Override
	public void addEntry(Entry entry) {
		int indPosition = binarySearch(entry.getSurname()); // Find position

		/*
		 * Create new array with (size+1) and copy all the elements and than add
		 * new entry. Finally copy all to the original array.
		 */
		Entry[] directoryCopy = new Entry[directory.length + 1];
		System.arraycopy(directory, 0, directoryCopy, 0, indPosition);
		directoryCopy[binarySearch(entry.getSurname())] = entry;
		System.arraycopy(directory, indPosition, directoryCopy,
				indPosition + 1, directory.length - indPosition);
		directory = directoryCopy; // Original array
	}

	@Override
	public void deleteEntry(String name, String number) {
		if (name != null) {
			int indPosition = binarySearch(name); // binary search
			if (directory[indPosition].getSurname().equals(name)) {
				delete(indPosition); // Delete element at the position
				System.out.println("Successfully deleted");
				return;

			}
			System.out.println(notFound);

		} else if (Integer.parseInt(number) != 0) {
			for (int i = 0; i < directory.length; i++) {
				if (directory[i].getNumber() == Integer.parseInt(number)) {
					delete(i);
					System.out.println("Successfully deleted");
					return;
				}
			}

		} else {
			System.out.println(notFound);
		}
	}

	@Override
	public void findEntry(String name) {
		int indPosition = binarySearch(name); // binary search
		if (indPosition < directory.length) {
			if (directory[indPosition].getSurname().equals(name)) {
				System.out.println(name
						+ "'s number is "
						+ String.format("%04d",
								directory[indPosition].getNumber()));
			}
		} else {
			System.out.println(notFound);
		}
	}

	@Override
	public void changeNumber(String name, String changeNumber) {
		int indPosition = binarySearch(name);
		if (indPosition < directory.length) {
			if (directory[indPosition].getSurname().equals(name)) {
				directory[indPosition] = new Entry(
						directory[indPosition].getSurname(),
						directory[indPosition].getInitials(), changeNumber);
			}
		} else {
			System.out.println("Not in directory list");
		}

	}

	// Table to print
	@Override
	public void printDirectory() {
		String leftFormat = "| %-14s | %-8s | %-9s |%n";
		System.out.format("+----------------+----------+-----------+%n");
		System.out.printf("| Surname        | Initials | Ex.number |%n");
		System.out.format("+----------------+----------+-----------+%n");

		for (int i = 0; i < directory.length; i++) {
			System.out.format(leftFormat, directory[i].getSurname(),
					directory[i].getInitials(),
					String.format("%04d", directory[i].getNumber()));
		}

		System.out.format("+----------------+----------+-----------+%n");

	}

	private void delete(int index) {
		Entry[] directoryCopy = new Entry[directory.length - 1];
		System.arraycopy(directory, 0, directoryCopy, 0, index);
		System.arraycopy(directory, index + 1, directoryCopy, index,
				directoryCopy.length - index);
		directory = directoryCopy;
	}

	/* This is binary search */
	public int binarySearch(String surname) {
		if (directory.length <= 0) {
			return 0;
		}
		int last = directory.length - 1;
		int first = 0;
		int middle = 0;

		while (first <= last) {
			String currentSurname = directory[middle].getSurname();
			if (surname.compareTo(currentSurname) > 0) {
				first = middle + 1;
			} else if (surname.compareTo(currentSurname) < 0) {
				last = middle - 1;
			} else {
				return first + (last - first) / 2;
			}
			middle = first + (last - first) / 2;
		}
		return middle;
	}

	/* Special method to print directory in GUI */
	public String printGui(int i) {
		return "\n" + directory[i].getSurname() + " "
				+ directory[i].getInitials() + " "
				+ String.format("%04d", directory[i].getNumber());
	}

	/* Return directory's length */
	public int directoryLength() {
		return directory.length;
	}
}
