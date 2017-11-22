import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ScoresTest {

	/*
	 Test Scores Constructor
	 */
	@Test public void emptyString() {
		Assert.assertEquals(0, (new Scores("")).getNumScores());
	}
	@Test public void oneValue() {
		Assert.assertEquals(1, (new Scores("1")).getNumScores());
	}
	@Test public void twoValues() {
		Assert.assertEquals(2, (new Scores("0 1")).getNumScores());
	}
	@Test public void twoValuesTwoSapces() {
		Assert.assertEquals(2, (new Scores("0  1")).getNumScores());
	}
	@Test public void twoValuesTab() {
		Assert.assertEquals(2, (new Scores("0\t1")).getNumScores());
	}
	@Test public void twoValuesNewLine() {
		Assert.assertEquals(2, (new Scores("0\n1")).getNumScores());
	}
	@Test public void badDelimiter() {
		boolean threwException = false;
		
		try {
			new Scores("2_3");
		} catch (IllegalArgumentException iae) {
			threwException = true;
		}
		
		Assert.assertEquals(true, threwException);
	}
	@Test public void DelimiterTab() {
		boolean threwException = false;
		
		try {
			new Scores("2\t3");
		} catch (IllegalArgumentException iae) {
			threwException = true;
		}
		
		Assert.assertEquals(false, threwException);
	}
	@Test public void DelimiterNewLine() {
		boolean threwException = false;
		
		try {
			new Scores("2\n3");
		} catch (IllegalArgumentException iae) {
			threwException = true;
		}
		
		Assert.assertEquals(false, threwException);
	}
	@Test public void letters() {
		boolean threwException = false;
		
		try {
			new Scores("a b c");
		} catch (IllegalArgumentException iae) {
			threwException = true;
		}
		
		Assert.assertEquals(true, threwException);
	}
	/*
	 Test getMax()
	 */
	@Test public void emptyStringMax() {
		Assert.assertEquals(Integer.MIN_VALUE, (new Scores("")).getMax());
	}
	@Test public void oneValueMax() {
		Scores score = new Scores("1");
		Assert.assertEquals(1, (new Scores("1")).getMax());
	}
	@Test public void twoValuesMax() {
		Assert.assertEquals(1, (new Scores("0 1")).getMax());
	}
	@Test public void negativeValuesMax() {
		Assert.assertEquals(-2, (new Scores("-5 -2")).getMax());
	}
}
