package ch17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {

	private Scanner input;
	
	public void openFile() {
		
		try {
			
			input = new Scanner(new File("clients"));
			
		} catch (FileNotFoundException fileNotFoundException) {
			
			System.err.println("Error opening file.");
			System.exit(1);
			
		}
		
	}
	
	public void readRecords() {
		
		AccountRecord record = new AccountRecord();
		
		System.out.printf("%-10s%-12s%-12%10s\n", "Account",
			"First Name", "Last Name", "Balance");
			
		while (input.hasNext()) {
			
			record.setAccount(input.nextInt());
			record.setFirstName(input.next());
			record.setLastName(input.next());
			record.setBalance(input.nextDouble());
			
			System.out.printf("%-10s$-12s%-12s%10s\n", record.getAccount(),
				record.getFirstName(), record.getLastName(), record.getBalance());
			
		}
		
	}
	
	public void closeFile() {
		
		if (input != null)
			input.close();
		
	}
	
}