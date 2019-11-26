package adj01AccountsCRUD.Version3;

import java.util.Arrays;
import java.util.Scanner;

public class AccountsApp {
	static AccountDAO accounts = new AccountDAO();
	static AccountDAO savings = new AccountDAO();
	static AccountDAO checkings = new AccountDAO();


	static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		accounts.initAccountArray();
		mainMenu();		
		sc.close();	
		
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
			updateAccounts();
			break;	
		case 4:
			deleteAccounts();
			break;
		default:
			System.out.println("Good bye");
		}
	}

	private static void deleteAccounts() {
		int accountId = 0;
		int newAccountId = 9999;
		char answer = ' ';
		int position = 0;
		
		Account newAccount = new Account(0,new Person());

		if (!accounts.isAccountsEmpty()) {
			do {
				System.out.println("DELETE ACCOUNTS");
				accountId = enterAccount("Enter account Id you want to delete :"); // -1 or a valid account id
				if (accountId!=-1){
					
					newAccount.setAccountId(accountId);
					position = accounts.findAccount(newAccount);
					if (position!=-1) {					
						accounts.deleteAccount(position);
						System.out.println("Record DELETED");
					} else {
						System.out.println("Record not found");
					}
				}
				answer = enterAnswer("Do you want to delte another account Y/N:");
			}while(answer=='Y');	
		}	
	}

	private static void updateAccounts() {
		int accountId = 0;
		int newAccountId = 0;
		char answer = ' ';
		int position = 0;
		
		Account newAccount = new Account(0,new Person());
		if (!accounts.isAccountsEmpty()) {
			do {
				System.out.println("UPDATE ACCOUNTS");
				accountId = enterAccount("Enter account Id you want to Update: "); // -1 or a valid account id
				if (accountId!=-1){
					newAccount.setAccountId(accountId);
					position = accounts.findAccount(newAccount);
					if (position!=-1) {
						newAccountId = enterAccount("Enter the new account id: ");
						if (newAccountId != -1) {
							
//							Account currentAccount = accounts.showAccount(position);
							printAccount(accounts.showAccount(position));
							newAccount.setAccountId(newAccountId);							
							enterNames(newAccount.getPrimaryAccountHolder());
							accounts.updateAccount(position, newAccount);
							
							System.out.println("Record UPDATED");
							printAllAccountsIds(); 

						}
							
					} else {
						System.out.println("Record not found");
					}
				}
				answer = enterAnswer("Do you want to update another account Y/N:");
			}while(answer=='Y');	
		}		
	}

	private static void printAccount(Account currentAccount) {
		System.out.println(currentAccount.getAccountId());
		System.out.println(currentAccount.getPrimaryAccountHolder().getFirstName());
		System.out.println(currentAccount.getPrimaryAccountHolder().getLastName());
		
	}

	private static void addAccounts() {
		int accountId = 0;
		
		Account newAccount = new Account(0,new Person());
		
		if (!accounts.isAccountsFull()) {		
			accountId = enterAccount("Enter new account id: "); // -1 or a valid account id
			if (accountId !=-1) {
				newAccount.setAccountId(accountId);
				if (accounts.findAccount(newAccount)!=-1) {
					System.out.println("Error: Duplicate Account Id");
				} else {

					enterNames(newAccount.getPrimaryAccountHolder());

					accounts.addAccount(newAccount);
//					System.out.println(Arrays.toString(accounts.accounts));
					printAllAccountsIds();
				}
			}
		}
	}
	private static Person enterNames(Person person) {
		System.out.println("Enter First Name:");
		person.setFirstName(sc.next());
		
		System.out.println("Enter Last Name: ");
		person.setLastName(sc.next());
		
		return person;
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
//		boolean answer = false;
		String response = "";
		do {
			System.out.println(msg);
			response = sc.next();
	    } while (!(response.toUpperCase().equals("Y") || response.toUpperCase().equals("N")));
		return response.toUpperCase().charAt(0);
	}
	
	private static void mainMenu() {
		int choiceMain = 0;
		System.out.println("Welcome");
		do {
			Menu.printMainMenu();
			choiceMain = Menu.enterChoice(sc);
			executeOperation(choiceMain);
		} while (choiceMain !=5);
//		System.out.println("Good bye");
	}

	
//*********************************************************
//	SANDBOX
//*********************************************************
	
	private static void printOneAccount() {
	     System.out.println(accounts.accounts[1].getPrimaryAccountHolder());
	     if (accounts.accounts[0].getPrimaryAccountHolder() == null)
	    	 System.out.println("NO ACCOUNT AVAILABLE | EMPTY ACCOUNT");
	     else
	    	 System.out.println(accounts.accounts[0].getPrimaryAccountHolder().getFirstName());
	}

	private static void printAllAccountsIds() {
		
		for (int i=0;i<=accounts.last;i++) {
		    System.out.println(i + "=" + accounts.accounts[i].getAccountId());
		    System.out.println(accounts.accounts[i].getPrimaryAccountHolder().getFirstName());
		}
		
		
		
		
	}

	private static void testDataTypes() {
		int numberA = 100;
		int numberB = 0;	
		numberA = numberB;
		Person personA = new Person("AA","LA");
		Person personB = new Person("BB", "LB");
		personA = personB;
		printNumber(numberA);
		System.out.println(numberA);	
		printPerson(personA);
		System.out.println(personA.toString()); // Marcial Clooney	
		Person personC = updatePerson(personA);	
	}

	private static Person updatePerson(Person personX) {
		Person otherPerson = new Person(personX);
		otherPerson.setFirstName("MM");
		otherPerson.setLastName("CC");
		
		return otherPerson;
	}

	private static void printPerson(Person personX) {
		Person otherPerson = new Person();
		otherPerson.setFirstName(personX.getFirstName());
		otherPerson.setLastName(personX.getLastName());
		
		Person otherPersonx = new Person(personX);
		
		
		
		System.out.println(personX.toString()); // BB LB
		personX.setFirstName("Marcial");
		personX.setLastName("Clooney");
		System.out.println(personX.toString()); // Marcial Clooney
	}

	private static void printNumber(int numberA) {
		int n = 99;
		numberA = n;
		System.out.println(numberA);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	private static void testAddAccount() {
		AccountDAO accounts = new AccountDAO();
		Person inputPerson = new Person("Mark","Twain");
		Account inputAccount = new Account(1001, inputPerson);
		
		accounts.addAccount(inputAccount);
		inputAccount.setAccountId(2001);
		inputPerson.setFirstName("George");
		inputPerson.setLastName("Clooney");
		accounts.addAccount(inputAccount);
	}

	private static void testAccountDAO() {
		Person accountHolder = new Person();		
		accountHolder.setFirstName("Boby");
		accountHolder.setLastName("Brown");
		
		Account account = new Account(1001,accountHolder);
		
		accounts.addAccount(account);
//		accounts.addAccount(1001, "chris","tim");
		
		if (accounts.isAccountsEmpty())
			System.out.println("ACCOUNTS ARRAY IS EMPTY");
		else
			System.out.println("ACCOUNTS ARRAY IS NOT EMPTY");
		
		Account tempAccount = new Account(1001,new Person("TIM","ALLAN"));
		
		int position = accounts.findAccount(tempAccount);
		if (position <0) {
			System.out.println("ACCOUNT NOT FOUND");
		} else {
			accounts.updateAccount(position, tempAccount);
			System.out.println("ACCOUNT UPDATED");
			
			Account tempAccountX = accounts.showAccount(position);
			System.out.println(tempAccountX.getPrimaryAccountHolder().getFirstName());
			System.out.println(tempAccountX.getPrimaryAccountHolder().getLastName());
			System.out.println("ACCOUNT DELETE");
			accounts.deleteAccount(position);
			position = accounts.findAccount(tempAccount);
			if (position < 0) {
				System.out.println("yeah DELETED");
			} else {
				System.out.println("YEAH, LETS GO HOME, NOT DELETED");
			}

		}
		
				
	}

}

//testAccountDAO();
//testAddAccount();
//testDataTypes();
//printAllAccountsIds(); 
//printOneAccount();