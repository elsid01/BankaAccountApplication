package adj01AccountsCRUD.Version4;

public class Person {
	private String firstName;
	private String lastName;

	public Person() {
		super();
		this.firstName = "";
		this.lastName = "";
	}
	
	public Person(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Person(String firstName) {
		this.firstName = firstName;
		this.lastName = "";
	}
	
	public Person(Person inputPerson) {
		this.firstName = inputPerson.getFirstName();
		this.lastName = inputPerson.getLastName();	
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	
	@Override
	public String toString() {
		String msg ="";
		msg = "[" + this.firstName + "," + this.lastName + "]";	
		return msg;
	}
}














