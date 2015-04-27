/*
 * FINAL
 * AUTHOR:Sanzhar Zholdiyarov;
 * STUDENT NUMBER: 110562618;
 * CSC1022 ASSIGNMENT 1
 * DATE CREATED: 21.03.2014;
 * CLASS: ArrayDirectorTest;
 * PURPOSE: Testing directory in arrays;
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ArrayDirectoryTest {
	public static void main(String[] args) throws IOException {

		StopWatch time = new StopWatch();
		ArrayDirectory directoryTest = new ArrayDirectory();
		FileReader readFile = new FileReader(
				"/Users/Desktop/directoryTest/DIRECTORY.txt");
		Scanner source = new Scanner(readFile);
		time.start();
		while (source.hasNext()) {
			String surname = source.next();
			String initials = source.next();
			String number = source.next();
			directoryTest.addEntry(new Entry(surname, initials, number));
		}
		time.stop();
		System.out.println("Adding :" + time.getElapsedTime());

		directoryTest.findEntry("Zholdiyarov");
		directoryTest.changeNumber("Zholdiyarov", "0777");
		directoryTest.deleteEntry("Zholdiyarov", "");
		directoryTest.printDirectory();
	}
}
