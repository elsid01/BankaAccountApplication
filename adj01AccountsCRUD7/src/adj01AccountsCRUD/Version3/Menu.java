package adj01AccountsCRUD.Version3;

import java.util.Scanner;

public class Menu {

	protected static int enterChoice(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("Enter option:");
			choice = sc.nextInt();
			if (choice <1 || choice >5) 
				System.out.println("Invalid entry, try again");
		}while (choice <1 || choice >5);
		return choice;
	}
	
	protected static void printMainMenu() {
		System.out.println("MENU");
		System.out.println("1.Add accounts");
		System.out.println("2.Show accounts");
		System.out.println("3.Update accounts");
		System.out.println("4.Delete accounts");
		System.out.println("5.Exit");
	}

	
	
}
