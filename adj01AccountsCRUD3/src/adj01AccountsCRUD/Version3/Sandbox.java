package adj01AccountsCRUD.Version3;

import java.util.Arrays;

public class Sandbox {

	public static void main(String[] args) {
		Account myAccount = new Account();
		
		int[] a;
		a = myAccount.getIdArray();
		
		a[0] = 100;
		a[1] = 200;
		
		
		System.out.println(Arrays.toString(a));
	//	myAccount.setIdArray(a);
	
		int[] b = myAccount.getIdArray();
		System.out.println(Arrays.toString(b));
		
		a[3] = 300;
		b[3] = 900;
		System.out.println("a=>"+Arrays.toString(a));
		System.out.println("b=>"+Arrays.toString(b));

		int[] c = new int[500];
		c[0] = 10;
		c[1] = 20;
		System.out.println("c=>"+Arrays.toString(c));
		c = myAccount.getIdArray();
		System.out.println("c=>"+Arrays.toString(c));

		int[] d = new int[500];
		d[0] = 1000;
		d[1] = 2000;
		myAccount.setIdArray(d);
		int[] e;
		e = myAccount.getIdArray();
		System.out.println("d=>"+Arrays.toString(d));
		System.out.println("e=>"+Arrays.toString(e));

		
		
	}

}
