
public class Professor extends ClassMember {
	
	private String office;

	public Professor(String firstName, String lastName, String email, String office) {
		super(firstName, lastName, email);
		this.office = office;
	}
	
	public String getContactInfo() {
		return "Prof. " + super.getContactInfo() + "\n" + office;
	}

}
