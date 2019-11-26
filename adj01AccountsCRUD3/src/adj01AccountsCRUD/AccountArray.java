package adj01AccountsCRUD;

import java.util.Arrays;

public class AccountArray {
	final int SIZE = 500;
	int[] idArray = new int[SIZE];
	int last;
	
	public void initAccountArray() {
		this.last = -1;
		for(int i=0;i<this.SIZE;i++) {
			this.idArray[i] = 9999;
		}
	}
	
	public boolean isAccountArrayFull() {
		if  (this.last==499) return true;
	  	return false;
	}
	
	public void addAcount(int accountId) {
		this.last++;
		this.idArray[this.last] = accountId;
	}
	
	public boolean existAccountId(int accountId) {
		Arrays.sort(this.idArray);
		int result = Arrays.binarySearch(this.idArray, accountId);		
		return result<0?false:true;
	}
	
	public  boolean isArrayEmpty() {
		if (this.last>=0) return false;
		return true;
	}

	public void updateArray(int position, int newAccountId) {
		this.idArray[position] = newAccountId;
		this.last--;
	}
}
