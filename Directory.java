/*
 * FINAL
 * AUTHOR:Sanzhar Zholdiyarov;
 * STUDENT NUMBER: 110562618;
 * CSC1022 ASSIGNMENT 1 
 * DATE CREATED: 21.03.2014;
 * INTERFACE: Directory;
 * PURPOSE: Manipulate entries;
 */
public interface Directory {

	public void addEntry(Entry entry);

	public void deleteEntry(String name, String number);

	public void findEntry(String name);

	public void changeNumber(String name, String changeNumber);

	public void printDirectory();

}
