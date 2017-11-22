import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.After;

public class CallCenterTest {
	
	CallCenter mgr;
	Worker alice = new Worker("alice");
	Worker bob = new Worker("bob");
	Worker chuck = new Worker("chuck");
	Worker danielle = new Worker("danielle");
	
	Call c1 = new Call("1111111");
	Call c2 = new Call("2222222");
	Call c3 = new Call("3333333");
	Call c4 = new Call("4444444");
	
	@Before
	public void setupManager(){
		mgr = new CallCenter();
	}
	
	@After
	public void printSpace(){
		System.out.println();
	}
	
	@Test
	public void oneCallThenWorker(){
		mgr.receive(c1);
		Assert.assertEquals(1, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.available(alice);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
	}
	
	@Test
	public void oneWorkerThenCall(){
		mgr.available(alice);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(1, mgr.availableWorkers());
		
		mgr.receive(c1);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
	}
	
	@Test
	public void severalCallsThenWorkers(){
	    // Create a stream to hold the output
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    PrintStream old = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);


		
		
		mgr.receive(c1);
		Assert.assertEquals(1, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.receive(c2);
		Assert.assertEquals(2, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.receive(c3);
		Assert.assertEquals(3, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.available(alice);
		Assert.assertEquals(2, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.available(bob);
		Assert.assertEquals(1, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.available(chuck);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.available(danielle);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(1, mgr.availableWorkers());
		
		
		// CHECK THE OUTPUT
	    // Put things back
	    System.out.flush();
	    System.setOut(old);
	    // Show what happened
	    String testOutput = baos.toString();
	    System.out.print(testOutput);
	    
	    String correctOutput = "alice \t is taking call from 1111111\n" +
	    		"bob \t is taking call from 2222222\n" +
	    		"chuck \t is taking call from 3333333\n";
	    
	    List<String> testTokens = Arrays.asList(testOutput.split("\\s+"));
	    List<String> correctTokens = Arrays.asList(correctOutput.split("\\s+"));
	    Assert.assertEquals(correctTokens, testTokens);
	}
	
	
	@Test
	public void severalWorkersThenCalls(){
		System.out.println("NOTE: workers' order is not important");
		mgr.available(alice);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(1, mgr.availableWorkers());
		
		mgr.available(bob);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(2, mgr.availableWorkers());
		
		mgr.available(chuck);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(3, mgr.availableWorkers());
		
		mgr.receive(c1);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(2, mgr.availableWorkers());
		
		mgr.receive(c2);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(1, mgr.availableWorkers());
		
		mgr.receive(c3);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.receive(c4);
		Assert.assertEquals(1, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
	}
	
	@Test
	public void mixOne(){
		System.out.println("NOTE: workers' order is not important");
		mgr.available(alice);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(1, mgr.availableWorkers());
		
		mgr.available(bob);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(2, mgr.availableWorkers());
		
		mgr.receive(c1);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(1, mgr.availableWorkers());
		
		mgr.available(chuck);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(2, mgr.availableWorkers());
		
		mgr.receive(c2);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(1, mgr.availableWorkers());
		
		mgr.receive(c3);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.receive(c4);
		Assert.assertEquals(1, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.available(danielle);
		Assert.assertEquals(0, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
	}
	
	@Test
	public void mixTwo(){
		System.out.println("Workers' order matters!");
		
	    // Create a stream to hold the output
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    PrintStream old = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);


		
		mgr.receive(c1);
		Assert.assertEquals(1, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.receive(c2);
		Assert.assertEquals(2, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.available(alice);
		Assert.assertEquals(1, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.receive(c3);
		Assert.assertEquals(2, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.receive(c4);
		Assert.assertEquals(3, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.available(bob);
		Assert.assertEquals(2, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		mgr.available(chuck);
		Assert.assertEquals(1, mgr.pendingCalls());
		Assert.assertEquals(0, mgr.availableWorkers());
		
		
		// CHECK THE OUTPUT
	    // Put things back
	    System.out.flush();
	    System.setOut(old);
	    // Show what happened
	    String testOutput = baos.toString();
	    System.out.print(testOutput);
	    
	    String correctOutput = "alice \t is taking call from 1111111\n" +
	    		"bob \t is taking call from 2222222\n" +
	    		"chuck \t is taking call from 3333333\n";
	    
	    List<String> testTokens = Arrays.asList(testOutput.split("\\s+"));
	    List<String> correctTokens = Arrays.asList(correctOutput.split("\\s+"));
	    Assert.assertEquals(correctTokens, testTokens);
		
	}
}
