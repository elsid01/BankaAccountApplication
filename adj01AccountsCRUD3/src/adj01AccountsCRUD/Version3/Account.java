package adj01AccountsCRUD.Version3;

import java.util.Arrays;

public class Account {
	private final int SIZE = 500;
	private int[] idArray = new int[SIZE];
	private int last;

	public int getSIZE() {
		return SIZE;
	}

	public int getLast() {
		return last;
	}
	
	public void addIdArrayElement(int key) {
		this.idArray[this.last] = key;
		this.last++;
		Arrays.sort(this.idArray);
	}
	
	public void updateIdArrayElement(int index, int key) {
		this.idArray[index] = key;
		Arrays.sort(this.idArray);

	}
	
	public void deleteIdArrayElement(int index) {
		this.idArray[index]=9999;
		this.last--;
		Arrays.sort(this.idArray);
	}
	
	
	
}

// KIRSTI ARRAY ENCAPSULATION SOLUTION 
//public int[] getIdArray() {
//int[] temp = new int[SIZE];
//for(int i=0;i<=this.last;i++)
//	temp[i] = idArray[i];
//return temp;
//}

//public void setIdArray(int[] temp) {
//for(int i=0;i<=this.last;i++)
//	this.idArray[i] = temp[i];
//
//}


