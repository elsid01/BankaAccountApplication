
package adj01AccountsCRUD.Version3;

import java.util.Arrays;

public class AccountDAO implements AccountDAOI {
	final int SIZE = 500;
	Account[] accounts = new Account[SIZE];
	int last = -1;
	
	public void addAccount(Account account) {
		last++;
		accounts[last] = account;
	}
	
	public void updateAccount(int index, Account account) {
		accounts[index] = account;
	}
	public void deleteAccount(int index) {
		accounts[index].setAccountId(9999);
		accounts[index].setPrimaryAccountHolder(new Person());
		last--;
	}
	public Account showAccount(int index) {
		return accounts[index];
	}	
	public int findAccount(Account account) { //linear search
		int i = 0;
		int index = -1;
		while(i<=last  && (accounts[i].getAccountId()!=account.getAccountId())) {
			i++;
		}
		if (i<=last) index = i;
		return index;
	}	
	public boolean isAccountsEmpty() {
		return last<0?true:false;
	}
	public boolean isAccountsFull() {
		return last==SIZE-1?true:false;
	}
	
	
}
