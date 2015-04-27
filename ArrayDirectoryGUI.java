/*
 * FINAL
 * AUTHOR:Sanzhar Zholdiyarov;
 * STUDENT NUMBER: 110562618;
 * CSC1022 ASSIGNMENT 1 
 * DATE CREATED: 21.03.2014;
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ArrayDirectoryGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());

		JPanel buttonsPanel = new JPanel();
		JPanel directoryPanel = new JPanel();
		JPanel changePanel = new JPanel();

		JButton addButton = new JButton("Add directory");
		JButton changeButton = new JButton("Change");
		JButton deleteButton = new JButton("Delete");

		buttonsPanel.add(addButton);
		buttonsPanel.add(deleteButton);
		buttonsPanel.add(changeButton);

		final JTextField deleteInput = new JTextField();
		final JTextField findIntput = new JTextField();
		final JTextField changeInput = new JTextField();
		deleteInput.setText("Ready to Delete?");
		findIntput.setText("Surname to change");
		changeInput.setText("Number to change");

		changePanel.add(deleteInput);
		changePanel.add(findIntput);
		changePanel.add(changeInput);

		final JTextArea directoryTextArea = new JTextArea(20, 15);
		directoryTextArea.setEditable(false);
		directoryPanel.add(directoryTextArea);

		frame.add(directoryPanel, BorderLayout.WEST);
		frame.add(buttonsPanel, BorderLayout.PAGE_START);
		frame.add(changePanel, BorderLayout.CENTER);

		directoryTextArea.setText("This is testing gui..");

		JScrollPane areaScrollPane = new JScrollPane(directoryTextArea);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		directoryPanel.add(areaScrollPane);

		final ArrayDirectory directoryTest = new ArrayDirectory();

		final JFileChooser chooser = new JFileChooser();

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				FileReader in = null;
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					try {
						in = new FileReader(selectedFile);
						Scanner sourceScanner = new Scanner(in);

						while (sourceScanner.hasNext()) {
							String surname = sourceScanner.next();
							String initials = sourceScanner.next();
							String number = sourceScanner.next();
							directoryTest.addEntry(new Entry(surname, initials,
									number));

						}
						print(directoryTextArea, directoryTest);

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane
						.showMessageDialog(
								null,
								"After successfully deleting new directory will be automatically showed",
								"Attention", JOptionPane.ERROR_MESSAGE);

				String input = deleteInput.getText();
				if (input.matches(".*\\d.*")) {
					directoryTest.deleteEntry(null, input);

					print(directoryTextArea, directoryTest);

				} else {
					directoryTest.deleteEntry(input, "");
					print(directoryTextArea, directoryTest);
				}
			}

		});
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane
						.showMessageDialog(
								null,
								"After successfully changing the number new directory will be automatically showed",
								"Attention", JOptionPane.ERROR_MESSAGE);
				String input = findIntput.getText();
				String number = changeInput.getText();
				directoryTest.changeNumber(input, number);
				print(directoryTextArea, directoryTest);
			}

		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void print(JTextArea area, ArrayDirectory directory) {
		area.setText(null);
		area.setText("Directory : ");
		for (int i = 0; i < directory.directoryLength(); i++) {
			area.append(directory.printGui(i));
		}
	}

	public static boolean checkInput(JTextField field) {
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(field.getText());
		boolean found = matcher.find();
		if (found) {
			return true;
		} else {
			return false;
		}
	}
}
