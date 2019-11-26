package adj01AccountsCRUD.Version3;

public class AccountsApp {
	
	public static void main(String[] args) {
		
		AccountDAO accounts = new AccountDAO();
		
		if (accounts.isAccountsEmpty())
			System.out.println("ACCOUNTS ARRAY IS EMPTY");
		else
			System.out.println("ACCOUNTS ARRAY IS NOT EMPTY");
		
	}

}
