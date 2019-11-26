package adj01AccountsCRUD.Version3;

public interface AccountDAOI {
	public void initAccountArray();
	public void addAccount(Account account);
	public void updateAccount(int index, Account account);
	public void deleteAccount(int index);
	public Account showAccount(int index);
	public int findAccount(Account account);
	public boolean isAccountsEmpty();
	public boolean isAccountsFull();

}
