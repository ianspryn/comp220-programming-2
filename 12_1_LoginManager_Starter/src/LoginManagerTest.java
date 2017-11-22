import org.junit.Assert;
import org.junit.Test;

public class LoginManagerTest {
	@Test public void addOne(){
		LoginManager mgr = new LoginManager();
		
		boolean res = mgr.addAccount(new Credentials("bob", "12345"));
		Assert.assertEquals(true, res);
	}
	
	@Test public void addTwo(){
		LoginManager mgr = new LoginManager();
		
		boolean res = mgr.addAccount(new Credentials("bob", "12345"));
		Assert.assertEquals(true, res);
		
		res = mgr.addAccount(new Credentials("sayeh", "12345"));
		Assert.assertEquals(true, res);
	}

	@Test public void addConflict(){
		LoginManager mgr = new LoginManager();
		
		boolean res = mgr.addAccount(new Credentials("bob", "12345"));
		Assert.assertEquals(true, res);
		
		res = mgr.addAccount(new Credentials("bob", "abcd"));
		Assert.assertEquals(false, res);
	}

	@Test public void usernameFound(){
		LoginManager mgr = new LoginManager();
		
		mgr.addAccount(new Credentials("bob", "12345"));
		boolean res = mgr.usernameAvailable("bob");
		
		Assert.assertEquals(false, res);
		
		res = mgr.usernameAvailable("bob123");
		Assert.assertEquals(true, res);
	}
	
	// In a real application,
	// more tests would go here

	// We move to check the isValidLogin method...

	//This is a helper method to make 2 accounts in which you can call in other tests
	//This saves you from writing the same thing over and over
	public LoginManager makeTwoAccounts(){
		LoginManager mgr = new LoginManager();
		mgr.addAccount(new Credentials("bob", "12345"));
		mgr.addAccount(new Credentials("sayeh", "abcde"));		
		return mgr;
	}
	
	@Test public void validLogin(){
		LoginManager mgr = makeTwoAccounts();
		
		boolean res = mgr.isValidLogin(new Credentials("bob", "12345"));
		Assert.assertEquals(true, res);
	}
	
	@Test public void invalidPassword(){
		LoginManager mgr = makeTwoAccounts();
		
		boolean res = mgr.isValidLogin(new Credentials("bob", "1234"));
		Assert.assertEquals(false, res);
	}

	@Test public void invalidUsername(){
		LoginManager mgr = makeTwoAccounts();
		
		boolean res = mgr.isValidLogin(new Credentials("bob1", "12345"));
		Assert.assertEquals(false, res);
	}

}
