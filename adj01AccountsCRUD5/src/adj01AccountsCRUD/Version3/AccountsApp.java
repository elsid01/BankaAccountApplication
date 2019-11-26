package adj01AccountsCRUD.Version3;

public class AccountsApp {
	
	public static void main(String[] args) {
		
		AccountDAO accounts = new AccountDAO();
		
		Person accountHolder = new Person();		
		accountHolder.setFirstName("Boby");
		accountHolder.setLastName("Brown");
		
		Account account = new Account(1001,accountHolder);
		
		accounts.addAccount(account);
		
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
