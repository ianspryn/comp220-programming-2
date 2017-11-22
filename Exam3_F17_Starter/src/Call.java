
/**
 * @author WOLFEBD
 * Represents an incoming call
 * Simple class containing only a phone number
 */
public class Call {
	private final String phone;
	
	public Call(String phone){
		this.phone = phone;
	}
	
	public String getPhone(){
		return phone;
	}
}
