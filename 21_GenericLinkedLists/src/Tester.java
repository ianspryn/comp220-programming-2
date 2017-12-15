import org.junit.Assert;
import org.junit.Test;

public class Tester {
	@Test
	public void emptyString() {
		try {
			LinkedList.foo("");
			Assert.fail();
		} catch (IllegalArgumentException IAE) {}
	}
	@Test
	public void onlyWhiteSpace() {
		try {
			LinkedList.foo(" \t\n     ");
			Assert.fail();
		} catch (IllegalArgumentException IAE) {}
	}
	
	@Test
	public void validInput() {
		try {
			LinkedList.foo("LKUADFS & 6 ^ADFKJG 7");
		} catch (IllegalArgumentException IAE) {
			Assert.fail();
		} 
	}
}
