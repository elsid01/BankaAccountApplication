package adj01AccountsCRUD.Version4;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AccountFile {
	static Scanner sc = new Scanner(System.in);

	public static String enterFilePath() {
		// 1. enter file path
		// 2. if filePath is invalid print error 
		// 3. repeat steps 1 and 2 until filePath is valid
				
		String filePath =null;        // "C:\\Users\\Marcial\\Documents\\javaxxx";
		char answer = ' ';
		boolean flag = false;
		do {
			System.out.println("Enter the location of the file :");
			filePath = sc.nextLine();
			Path path = Paths.get(filePath);
			if (!Files.exists(path)) {
				System.out.println("ERROR: Invalid file location");
				answer = AccountsApp.enterAnswer("Do you want to enter again Y/N:");
				flag = answer=='Y'?true:false;
				filePath = null;
			} else
				flag = false;
		} while(flag);
		
		return filePath;
	}

	public static String enterFileName(String filePath) {
		String fileName = null;
		char answer = ' ';
		boolean flag = false;
		do {
			System.out.println("Enter CSV file name including the extension :");
			fileName = sc.nextLine();
			String pathName = filePath + "\\" + fileName;
			File file = new File(pathName);
			
			if (!file.exists()) {
				System.out.println("ERROR: Invalid file name and/or location");
				answer = AccountsApp.enterAnswer("Do you want to enter again Y/N:");
				flag = answer=='Y'?true:false;
				fileName = null;
			} else
				flag = false;
		} while(flag);
		return fileName;
	}

	protected static AccountDAO readFileAccounts(String filePath, String fileName) throws FileNotFoundException {
		String fileLine = null;
		String[] data = null;
		AccountDAO accounts = new AccountDAO();
		Account account = null;
		// read the file records and add each record to the accounts array
		accounts.initAccountArray();
	
		File file = new File(filePath+"\\"+fileName);
		Scanner fileReader = new Scanner(file);
		
		while (fileReader.hasNextLine() && !accounts.isAccountsFull()) {
			fileLine = fileReader.nextLine();
			data = fileLine.split(",");		
			account = new Account( Integer.parseInt(data[0]), new Person(data[1],data[2]));
			accounts.addAccount(account);
		}
		fileReader.close();
		return accounts;
	}


}


// *************************************************
// SANDBOX
// **********************************************

//Path path = Paths.get(filePath);
//if (Files.exists(path)) {
//	System.out.println("File path exist");
//} else {
//	System.out.println("File path does not exist");
//}

//File files = new File(filePath);
//if (!files.exists()) {
//	System.out.println("File path does not exist");
//} else {
//	System.out.println("File path exist");
//}




