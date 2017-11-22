import org.junit.Assert;
import org.junit.Test;

/**
 * @author WOLFEBD
 * Tests only the overlap method of Interval
 */
public class IntervalTest {
	@Test
	public void inside(){
		Interval i1 = new Interval(0, 3, 10);
		Interval i2 = new Interval(0, 4, 6);
		
		Assert.assertTrue(i1.overlaps(i2));
		Assert.assertTrue(i2.overlaps(i1));
	}
	
	@Test
	public void outside(){
		Interval i1 = new Interval(0, 3, 10);
		Interval i2 = new Interval(0, 11, 18);
		
		Assert.assertFalse(i1.overlaps(i2));
		Assert.assertFalse(i2.overlaps(i1));
	}
	
	@Test
	public void same(){
		Interval i1 = new Interval(0, 3, 10);
		Interval i2 = new Interval(0, 3, 10);
		
		Assert.assertTrue(i1.overlaps(i2));
		Assert.assertTrue(i2.overlaps(i1));
	}
	
	@Test
	public void startSame(){
		Interval i1 = new Interval(0, 3, 10);
		Interval i2 = new Interval(0, 3, 5);
		
		Assert.assertTrue(i1.overlaps(i2));
		Assert.assertTrue(i2.overlaps(i1));
	}
	
	@Test
	public void endSame(){
		Interval i1 = new Interval(0, 3, 10);
		Interval i2 = new Interval(0, 8, 10);
		
		Assert.assertTrue(i1.overlaps(i2));
		Assert.assertTrue(i2.overlaps(i1));
	}
	
	@Test
	public void justBarely(){
		Interval i1 = new Interval(0, 3, 10);
		Interval i2 = new Interval(0, 10, 15);
		
		Assert.assertTrue(i1.overlaps(i2));
		Assert.assertTrue(i2.overlaps(i1));
	}
	
	@Test
	public void stagger(){
		Interval i1 = new Interval(0, 3, 10);
		Interval i2 = new Interval(0, 8, 15);
		
		Assert.assertTrue(i1.overlaps(i2));
		Assert.assertTrue(i2.overlaps(i1));
	}
}
