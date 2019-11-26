package adj01AccountsCRUD.Version4;

/*
 * This is a Model for Accounts.
 * Fields: 
 * - Account Id
 * - Primary Account Holder 
 *       - First Name
 *       - Last Name
 */
public class Account {
	private int accountId;
	private Person primaryAccountHolder;  // has-a relationship
    
	public Account(int accountId) {
		this.accountId = accountId;
		this.primaryAccountHolder = new Person();
	}
	
	public Account(int accountId, Person accountHolder) {
		this.accountId = accountId;
		this.primaryAccountHolder = new Person(accountHolder);
	}
	
	public Account(Account account) {
		this.accountId = account.getAccountId();
		this.primaryAccountHolder = new Person(account.getPrimaryAccountHolder());
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setPrimaryAccountHolder(Person primaryAccountHolder) {
		this.primaryAccountHolder = primaryAccountHolder;
	}
	
	public Person getPrimaryAccountHolder() {
		return this.primaryAccountHolder;
	}

	
}

