package adj01AccountsCRUD.Version3;

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
		
//		printAllAccountsIds(); 
//		printOneAccount();
		
		
		sc.close();	
		
	}
	private static void executeOperation(int choice) {
		switch (choice) {
		case 1:
//			addAccounts();
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
			System.out.println("Good bye");
		}
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

	private static void printOneAccount() {
	     System.out.println(accounts.accounts[1].getPrimaryAccountHolder());
	     if (accounts.accounts[0].getPrimaryAccountHolder() == null)
	    	 System.out.println("NO ACCOUNT AVAILABLE | EMPTY ACCOUNT");
	     else
	    	 System.out.println(accounts.accounts[0].getPrimaryAccountHolder().getFirstName());
	}

	private static void printAllAccountsIds() {
		
		for (int i=0;i<accounts.SIZE;i++) {
		    System.out.println(i + "=" + accounts.accounts[i].getAccountId());

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
