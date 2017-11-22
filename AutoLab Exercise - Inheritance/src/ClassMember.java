/**
 * @author WOLFEBD
 * Represents a member of a college class
 */
public class ClassMember {
	private String firstName;
	private String lastName;
	private String email;
	
	public ClassMember(String firstName, String lastName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String getContactInfo(){
		return firstName + " " + lastName + " (" + email + ")";
	}
	
	public String getEmail(){
		return email;
	}
}
