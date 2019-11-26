package adj01AccountsCRUD;


public class AccountArray {
	static final int SIZE = 500;
	static int[] idArray = new int[SIZE];
	static int last;
	public boolean isArrayEmpty() {
		if (this.last>0) return false;
		return true;
	}
	public void addAcount(int accountId) {
		this.last++;
		this.idArray[this.last] = accountId;
	}
	public boolean existAccountId(int accountId) {
		Arrays.sort(this.idArray);
		int result = Arrays.binarySearch(this.idArray, accountId);
		
//		if result < 0 flag = false;
//		else flag = true;
//		return flag;
		
		return result<0?false:true;
	}
	public boolean isAccountArrayFull() {
		if  (this.last==499) return true;
	  	return false;
	}
	public void initAccountArray() {
		this.last = -1;
		for(int i=0;i<this.SIZE;i++) {
			this.idArray[i] = 9999;
		}
	}



}
