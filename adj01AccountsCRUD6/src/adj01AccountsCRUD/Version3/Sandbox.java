 package adj01AccountsCRUD.Version3;

public class Sandbox {

	public static void main(String[] args) {
//		samplePerson();
//		sampleObject();
//		sampleNewPerson();
		accountsTest();
		
	}

	private static void accountsTest() {
		AccountDAO a = new AccountDAO();
		a.addAccount(new Account(1001,new Person("Boby","Bob")));
		a.addAccount(new Account(3001,new Person("Boby","BobX")));
		a.addAccount(new Account(2001,new Person("Boby","BobY")));
		a.findAccount(new Account(1001,new Person()));

	}

	private static void sampleNewPerson() {
		Person primaryAccountHolder = new Person(); //using default constructor
		System.out.println(primaryAccountHolder.toString());
		
		Person primaryAccountHolderB = new Person("Marcial"); //using another constructor
		System.out.println(primaryAccountHolderB.toString());

		Person primaryAccountHolderC = new Person("Victor", "Zenin");
		System.out.println(primaryAccountHolderC.toString());

		Person xPerson = new Person();
		xPerson.setFirstName("Jorge");
		xPerson.setLastName("Barbosa");
		Person primaryAccountHolderD = new Person(xPerson);
		System.out.println(primaryAccountHolderD.toString());
		
		
		Person primaryAccountHolderE = new Person(new Person("David", "Washington"));
		System.out.println(primaryAccountHolderE.toString());
		

	}

	private static void sampleObject() {
		Object test = new Object();
		test.equals("text");
		test.toString();
		
		
		
	}

	private static void samplePerson() {
		Person primaryAccountHolder = new Person();
		Person secondaryAccountHolder = new Person("Marcial", "Cordon");
		
		System.out.println(primaryAccountHolder.toString());
		System.out.println(primaryAccountHolder.getFirstName()+" "+primaryAccountHolder.getLastName());
		
		System.out.println(secondaryAccountHolder.toString());
		System.out.println(secondaryAccountHolder.getFirstName()+" "+secondaryAccountHolder.getLastName());

		secondaryAccountHolder.toString();
		
		Person accountHolder;
		
		
	}

}
