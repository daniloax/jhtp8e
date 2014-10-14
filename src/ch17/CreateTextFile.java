package ch17;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateTextFile {
	
	private Formatter output;
	
	public void openFile() {
		
		try {
		
			output = new Formatter("clients");
			
		} catch (FileNotFoundException fileNotFoundException) {
			
			System.err.println("Error opening or creating file.");
			System.exit(1);
		
		}
		
	}
	
	public void addRecords() {
		
		AccountRecord record = new AccountRecord();
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf("%s\n%s\n%s\n%s\n\n",
			"To terminate input, type de end-of-file indicator ",
			"when you are prompted to enter input.",
			"On Unix/Linux/Mac OS X type <ctrl> d then press Enter",
			"On Windows type <ctrl> z then press Enter");
		
		System.out.printf("%s\n%s",
			"Enter account number (> 0), first name, last name an balance.",
			"?");
		
		while (input.hasNext()) {
			
			try {
			
				record.setAccount(input.nextInt());
				record.setFirstName(input.next());
				record.setLastName(input.next());
				record.setBalance(input.nextDouble());
				
				if (record.getAccount() > 0 )
					output.format("%d %s %s %.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
				
				else
					System.out.println("Account must be greater than 0.");
				
			} catch (InputMismatchException inputMismatchException) {
				
				System.err.println("Invalid input. Please try again.");
				input.nextLine();
				
			}
			
		}
		
		System.out.printf("%s %s\n%s", "Enter account number (>0),",
			"first name, last name and ballance.", "?");
		
	}
	
	public void closeFile() {
		
		if (output != null)
			output.close();
		
	}

}
