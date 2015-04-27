/*
 * FINAL
 * AUTHOR:Sanzhar Zholdiyarov;
 * STUDENT NUMBER: 110562618;
 * CSC1022 ASSIGNMENT 1
 * DATE CREATED: 21.03.2014;
 * CLASS: ListDirectoryTest;
 * PURPOSE: Testing directory in list withc hashing;
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ListDirectoryTest {

	public static void main(String[] args) throws IOException {

		StopWatch time = new StopWatch();

		ListDirectory listDirectory = new ListDirectory();

		FileReader readFile = new FileReader(
				"/Users/Desktop/directoryTest/DIRECTORY.txt");
		Scanner source = new Scanner(readFile);
		time.start();
		while (source.hasNext()) {
			String surname = source.next();
			String initials = source.next();
			String number = source.next();
			listDirectory.addEntry(new Entry(surname, initials, number));
		}
		time.stop();
		System.out.println(time.getElapsedTime());

		listDirectory.findEntry("Zholdiyarov");
		listDirectory.changeNumber("Zholdiyarov", "0777");
		listDirectory.deleteEntry("Zholdiyarov", "");
		listDirectory.printDirectory();
	}
}
