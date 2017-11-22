import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class DemoTest {
	@Test public void oneItem(){
		final int item = 10;
		ArrayList<Integer> xs = new ArrayList<Integer>();
		xs.add(item);
		int result = Demo.findMax(xs);
		Assert.assertEquals(item, result);
	}
	@Test public void negativeNumbers() {
		//setup
		ArrayList<Integer> stuff = new ArrayList<>();
		stuff.add(-12083);
		stuff.add(-13);
		stuff.add(-1384);
		//method call
		int result = Demo.findMax(stuff);
		//check results
		Assert.assertEquals(-13, result);
	}
	@Test public void emptyArray() {
		//CHECK CORNER CASES: THE THIGNS THAT BREAK YOUR CODE
		boolean threwException = false;
		ArrayList<Integer> moreStuff = new ArrayList<>();
		
		try {
			Demo.findMax(moreStuff);
		} catch (IllegalArgumentException iae) {
			threwException = true;
		}
		
		Assert.assertEquals(true, threwException);
	}
}
