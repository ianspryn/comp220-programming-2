import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MapCombineTest {
	@Test
	public void empties(){
		Map<String, Integer> empty = new HashMap<>();
		Map<String, Integer> result = Misc.combine(empty, empty);
		Assert.assertEquals(0, result.size());
	}
	
	@Test
	public void oneEmpty(){
		Map<String, Integer> empty = new HashMap<>();
		Map<String, Integer> stuff = new HashMap<>();
		stuff.put("Hello", 10);
		stuff.put("another key", 2);
		
		Map<String, Integer> result;

		result = Misc.combine(empty, stuff);
		Assert.assertEquals(stuff, result);
		
		result = Misc.combine(stuff, empty);
		Assert.assertEquals(result, stuff);
	}
	
	@Test
	public void noOverlap(){
		Map<Double, Integer> partOne = new HashMap<>();
		partOne.put(3.2, 10);
		partOne.put(1.1, 2);
		
		Map<Double, Integer> partTwo = new HashMap<>();
		partTwo.put(100.1, 10);
		partTwo.put(99.9, 2);		
		
		Map<Double, Integer> result;

		result = Misc.combine(partOne, partTwo);
		Assert.assertEquals(4, result.size());
		Assert.assertEquals(new Integer(10), result.get(3.2));
		Assert.assertEquals(new Integer(2), result.get(1.1));
		Assert.assertEquals(new Integer(10), result.get(100.1));
		Assert.assertEquals(new Integer(2), result.get(99.9));	
	}
	
	@Test
	public void simpleOverlap(){
		Map<Double, Integer> partOne = new HashMap<>();
		partOne.put(3.2, 10);
		
		Map<Double, Integer> partTwo = new HashMap<>();
		partTwo.put(3.2, 2);
		
		Map<Double, Integer> result;

		result = Misc.combine(partOne, partTwo);
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(new Integer(12), result.get(3.2));

	}
	
	@Test
	public void fullCase(){
		Map<Double, Integer> partOne = new HashMap<>();
		partOne.put(3.2, 10);
		partOne.put(9.8, 100);
		partOne.put(77.0, 7);
		
		Map<Double, Integer> partTwo = new HashMap<>();
		partTwo.put(3.2, 2);
		partTwo.put(9.8, 42);
		partTwo.put(12.0, 12);
		partTwo.put(1.1, 19);
		
		Map<Double, Integer> result;

		result = Misc.combine(partOne, partTwo);
		Assert.assertEquals(5, result.size());
		Assert.assertEquals(new Integer(12), result.get(3.2));
		Assert.assertEquals(new Integer(142), result.get(9.8));
		Assert.assertEquals(new Integer(12), result.get(12.0));
		Assert.assertEquals(new Integer(19), result.get(1.1));
		Assert.assertEquals(new Integer(7), result.get(77.0));
	}
}
