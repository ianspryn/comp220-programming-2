public class Credentials {
	
	private String username;
	private String password;
	//	In a real application, we would
	//  store a hashed version of the password, so the
	//  password itself isn't on our system.

	public Credentials(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public String getUsername(){
		return username;
	}
	
	
	//Taking care of a problem where if it is not a credentials object, it would accidently return false
	@Override // There is already an equals method, but I want to use mine instead
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Credentials)) {
			//takes a variable on the left and a class on the right,
			//and it will be true if you have an Credentials object
			return false;
		}
		
		//Time to check the actual member variables
		
		//get a Credentials reference to obj
		//We're saying, "give me a Credentials reference to obj!"
		//So you always want to use instanceof before you do a cast
		Credentials other = (Credentials) obj;
		
		if (other.username.equals(this.username) && other.password.equals(this.password)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	//objects that are .equals MUST have the same hashCode
	//different objects ideally return different hashCodes
	//It's good to spread out these hashCodes so the hashCodes work better
	//Apparently people discovered this is a good formula
	public int hashCode() {
		int result = 17;
		result = 37 * result + username.hashCode();
		result = 37 * result + password.hashCode();
		//for each member variable, multiple the previous result by 37 and add the hash?
		return result;
		//what??!
		/*
		 you have to do this. Because of the comment right above
		 */
	}
}
