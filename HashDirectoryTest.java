/*
 * FINAL
 * AUTHOR:Sanzhar Zholdiyarov;
 * STUDENT NUMBER: 110562618;
 * CSC1022 ASSIGNMENT 1
 * DATE CREATED: 21.03.2014;
 * CLASS: HashDirectoryTest;
 * PURPOSE: Testing directory in list;
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HashDirectoryTest {
	public static void main(String[] args) throws FileNotFoundException {
		StopWatch time = new StopWatch();
		HashDirectory listDirectory = new HashDirectory();
		FileReader readFile = new FileReader(
				"/Users/sanzharshynar/Desktop/directoryTest/DIRECTORY.txt");
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

		listDirectory.printDirectory();
		listDirectory.findEntry("Zholdiyarov");
		listDirectory.changeNumber("Zholdiyarov", "0078");
		listDirectory.deleteEntry("Zholdiyarov", "");
	}
}
