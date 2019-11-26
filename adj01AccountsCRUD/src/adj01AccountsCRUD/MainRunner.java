package adj01AccountsCRUD;

import java.util.Scanner;

public class MainRunner {
	static AccountArray accountArray = new AccountArray();
	static Scanner sc;

	
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		initAccountArray();
		mainMenu();
		sc.close();
	}

	private static void mainMenu() {
		int choiceMain = 0;
		System.out.println("Welcome");
		do {
			printMainMenu();
			choiceMain = enterChoice();
			executeOperation(choiceMain);
		} while (choiceMain !=5);
		System.out.println("Good bye");
	}

	private static void executeOperation(int choice) {
		switch (choice) {
		case 1:
			addAccounts();
			break;
		case 2:
//			showAccounts();
			break;		
		case 3:
//			updateAccounts();
			break;	
		case 4:
//			deleteAccounts();
			break;
		default:
			System.out.println("ERROR: invalid choice");
		}
	}

	private static void addAccounts() {
		int accountId = 0;
		if (!isAccountArrayFull()) {
			accountId = enterAccount(); // -1 or a valid account id
			System.out.println("HELLO "+accountId);
			
		}
	}

	private static int enterAccount() {
		int accountId = -1;
		boolean answer = false;
		boolean flag = false;
		do {
			System.out.println("Enter Account ID =");
			accountId = sc.nextInt();
			if (!isAccountIdValid(accountId)) {
				System.out.println("Error: Invalid account id entered");
				answer = enterAnswer();
				if (answer) flag = true;
				else flag = false;
			}else
				flag = false;
			
		} while (flag);
		
		return accountId;
	}

	private static boolean isAccountIdValid(int accountId) {
		if (accountId >=1000 && accountId <=5000) return true;
		return false;
	}

	private static boolean enterAnswer() {
		boolean answer = false;
		String response = "";
		do {
			System.out.println("Do you want to enter again Y/N:");
			response = sc.next();
			if (response.equals("Y") || response.equals("N")) answer=false;
			else answer = true;
		}while (answer);
		return answer;
	}

	private static boolean isAccountArrayFull() {
		if  (accountArray.last==499) return true;
	  	return false;
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

	private static void initAccountArray() {
		accountArray.last = -1;
		for(int i=0;i<accountArray.SIZE;i++) {
			accountArray.idArray[i] = 9999;
		}
	}

}
