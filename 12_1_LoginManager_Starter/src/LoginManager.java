import java.util.ArrayList;
import java.util.HashSet;

public class LoginManager {

	//private ArrayList<Credentials> accounts;
	private HashSet<Credentials> accounts;
	
	public LoginManager(){
		accounts = new HashSet<>(); //ArrayList<>();
	}
	
	/**
	 * @param username
	 * @return true if @param username is not currently used
	 */
	public boolean usernameAvailable(String username){
		// assume it's true until we find otherwise
		boolean available = true;
		
		// enhanced for-loop
		// c refers to each thing in accounts
		
		/*
		 
		 (for int = 0 ; i < accounts.size(); i++) {
		 	Credentials c = accounts,get(i)
		 }
		 
		 */
		for(Credentials c : accounts){ //equivalent to the commented stuff above ^^^^\
			if(c.getUsername().equals(username)){
				available = false;
				break; // don't need to keep going
			}
		}
		
		return available;
	}
	
	/**
	 * @return true if acc is successfully added
	 *    to the list of accounts
	 */
	public boolean addAccount(Credentials acc){
		if(!usernameAvailable(acc.getUsername())){
			return false;
		}
		accounts.add(acc);
		return true;
	}
	
	
	public boolean isValidLogin(Credentials login){
		return accounts.contains(login);
	}
}
