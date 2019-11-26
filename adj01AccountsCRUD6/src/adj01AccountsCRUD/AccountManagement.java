package adj01AccountsCRUD;

import java.util.Arrays;
import java.util.Scanner;

public class AccountManagement {
	static Scanner sc;
	static AccountArray account = new AccountArray();


	public static void main(String[] args) {
		sc = new Scanner(System.in);
		account.initAccountArray();
		mainMenu();
		sc.close();
	}
	

	private static void deleteAccounts() {
		// 1. verify array is not empty
		// 2. ask for accountId to remove
		// 3. search (accountId)
		// 4. if exist then
		//      4.1. update the record with 9999
		int accountId = 0;
		int newAccountId = 9999;
		char answer = ' ';
		int position = 0;
		if (!account.isArrayEmpty()) {
			do {
				System.out.println("DELETE ACCOUNTS");
				accountId = enterAccount("Enter account Id you want to delete :"); // -1 or a valid account id
				if (accountId!=-1){
					if (account.existAccountId(accountId)) {
						Arrays.sort(account.idArray);
						position = Arrays.binarySearch(account.idArray, accountId);
						account.updateArray(position, newAccountId);
						System.out.println("Record DELETED");
						System.out.println(Arrays.toString(account.idArray));
					} else {
						System.out.println("Record not found");
					}
				}
				answer = enterAnswer("Do you want to delte another account Y/N:");
			}while(answer=='Y');
			
		}
				
		
	}

	private static void updateAccounts() {
		// 1. verify array is not empty
		// 2. ask for accountId to update
		// 3. search(accountId)
		// 4. if exist then 
		//     4.1. ask for new valid accountId
		              // btw range
		//	   4.2. verify is not duplicate
		//	   4.3. update the record or element
		//
		int accountId = 0;
		int newAccountId = 0;
		char answer = ' ';
		int position = 0;
		if (!account.isArrayEmpty()) {
			do {
				System.out.println("UPDATE ACCOUNTS");
				accountId = enterAccount("Enter account Id you want to Update: "); // -1 or a valid account id
				if (accountId!=-1){
					if (account.existAccountId(accountId)) {
						newAccountId = enterAccount("Enter the new account id: ");
						if (newAccountId != -1) {
							// update the element
							Arrays.sort(account.idArray);
							position = Arrays.binarySearch(account.idArray, accountId);
							account.idArray[position] = newAccountId;
							System.out.println("Record UPDATED");
							System.out.println(Arrays.toString(account.idArray));
						}
							
					} else {
						System.out.println("Record not found");
					}
				}
				answer = enterAnswer("Do you want to update another account Y/N:");
			}while(answer=='Y');
			
		}
		
		
	}

	private static void showAccounts() {
		// 1. verify array is not empty
		// 2. ask for accountId to show
		// 3. search (accountID)
		// 4. if exist print the "record found"
		//	  else print "record not found"
		// 5. ask user if wants to look for another accountID
		int accountId = 0;
		char answer = ' ';
		if (!account.isArrayEmpty()) {
			do {
				accountId = enterAccount("Enter the account id : "); // -1 or a valid account id
				if (accountId!=-1){
					if (account.existAccountId(accountId)) {
						System.out.println("Record found");
					} else {
						System.out.println("Record not found");
					}
				}
				answer = enterAnswer("Do you want to look again Y/N:");
				
			}while(answer=='Y');
			
		}
		
		
	}
	
	private static void addAccounts() {
		int accountId = 0;
		if (!account.isAccountArrayFull()) {
			accountId = enterAccount("Enter new account id: "); // -1 or a valid account id
			if (accountId !=-1) {
				if (account.existAccountId(accountId)) {
					System.out.println("Error: Duplicate Account Id");
				} else {
					account.addAcount(accountId);
					System.out.println(Arrays.toString(account.idArray));
				}
					
			}
		}
	}

	private static int enterAccount(String msg) {
		int accountId = -1;
		char answer = ' ';
		boolean flag = false;
		do {
			System.out.println(msg);
			accountId = sc.nextInt();
			if (!isAccountIdValid(accountId)) {
				System.out.println("Error: Invalid account id entered");
				answer = enterAnswer("Do you want to enter again Y/N:");
				if (answer=='Y') flag = true;
				else flag = false;
				accountId = -1;
			}else 
				flag = false;
			
			
		} while (flag);
		
		return accountId;
	}

	private static boolean isAccountIdValid(int accountId) {
		if (accountId >=1000 && accountId <=5000) return true;
		return false;
	}

	private static char enterAnswer(String msg) {
		boolean answer = false;
		String response = "";
		do {
			System.out.println(msg);
			response = sc.next();
	    } while (!(response.toUpperCase().equals("Y") || response.toUpperCase().equals("N")));
		return response.toUpperCase().charAt(0);
	}

	private static void executeOperation(int choice) {
		switch (choice) {
		case 1:
			addAccounts();
			break;
		case 2:
			showAccounts();
			break;		
		case 3:
			updateAccounts();
			break;	
		case 4:
			deleteAccounts();
			break;
		default:
			System.out.println("Good bye");
		}
	}
	
	private static int enterChoice() {
		int choice = 0;
		do {
			System.out.println("Enter option:");
			choice = sc.nextInt();
			if (choice <1 || choice >5) 
				System.out.println("Invalid entry, try again");
		}while (choice <1 || choice >5);
		return choice;
	}
	
	private static void printMainMenu() {
		System.out.println("MENU");
		System.out.println("1.Add accounts");
		System.out.println("2.Show accounts");
		System.out.println("3.Update accounts");
		System.out.println("4.Delete accounts");
		System.out.println("5.Exit");
	}
	
	private static void mainMenu() {
		int choiceMain = 0;
		System.out.println("Welcome");
		do {
			printMainMenu();
			choiceMain = enterChoice();
			executeOperation(choiceMain);
		} while (choiceMain !=5);
//		System.out.println("Good bye");
	}



}
