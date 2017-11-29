import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;


public class UnorderedPairTest {
	@Test
	public void constructor(){
		UnorderedPair<String> ps = new UnorderedPair<>("hello", "world");
		UnorderedPair<Integer> pi = new UnorderedPair<>(3, 5);
		UnorderedPair<UnorderedPair<Double>> ppd = new UnorderedPair<>(
				new UnorderedPair<Double>(1.0, -4.3),
				new UnorderedPair<Double>(2.9, -1.1));
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void containsSimple(){
		UnorderedPair<String> ps = new UnorderedPair<>("hello", "world");
		UnorderedPair<Integer> pi = new UnorderedPair<>(3, 5);
		
		Assert.assertTrue(ps.contains(new String("hello")));
		Assert.assertTrue(ps.contains(new String("world")));
		Assert.assertTrue(!ps.contains(new String("Hello")));
		
		Assert.assertTrue(pi.contains(3));
		Assert.assertTrue(pi.contains(5));
		Assert.assertTrue(!pi.contains(0));
	}
	
	@Test
	public void containsArrayList(){
		ArrayList<Double> first = new ArrayList<Double>();
		first.add(1.3);
		first.add(3.9);
		first.add(-10.0);
		
		ArrayList<Double> firstCopy = new ArrayList<Double>();
		firstCopy.addAll(first);
		
		ArrayList<Double> second = new ArrayList<Double>();
		second.add(12.2);
		
		ArrayList<Double> secondCopy = new ArrayList<Double>();
		secondCopy.addAll(second);
		
		ArrayList<Double> other = new ArrayList<>();
		ArrayList<Double> another = new ArrayList<>();
		another.add(-10.0);
		another.add(3.9);
		another.add(1.3);
		
		UnorderedPair<ArrayList<Double>> p = new UnorderedPair<>(first, second);
		
		Assert.assertTrue(p.contains(first));
		Assert.assertTrue(p.contains(firstCopy));
		Assert.assertTrue(p.contains(second));
		Assert.assertTrue(p.contains(secondCopy));
		
		Assert.assertTrue(! p.contains(other));
		Assert.assertTrue(! p.contains(another));
	}
	
	@Test
	public void equalsSimple(){
		UnorderedPair<String> ps = new UnorderedPair<>("hello", "world");
		UnorderedPair<String> ps2 = new UnorderedPair<>("hello", "world");
		UnorderedPair<String> psReverse = new UnorderedPair<>("world", "hello");
		
		UnorderedPair<String> psOther = new UnorderedPair<>("not", "world");
		UnorderedPair<String> psAnother = new UnorderedPair<>("hello", "goodbye");

		
		UnorderedPair<Integer> pi = new UnorderedPair<>(3, 5);
		UnorderedPair<Integer> pi2 = new UnorderedPair<>(3, 5);
		UnorderedPair<Integer> piReverse = new UnorderedPair<>(5, 3);
		
		///////// Things unequal
		
		// Different types
		Assert.assertTrue(! ps.equals(new String("oops")));
		Assert.assertTrue(! pi.equals(new String("oops")));
		
		// Different kind of UnorderedPair
		Assert.assertTrue(! ps.equals(pi));
		Assert.assertTrue(! pi.equals(ps));
		
		// Different values
		Assert.assertTrue(! ps.equals(psOther));
		Assert.assertTrue(! ps.equals(psAnother));
		Assert.assertTrue(! psOther.equals(psAnother));
		
		
		///////// Things equal
		Assert.assertTrue(ps.equals(ps));
		Assert.assertTrue(ps.equals(ps2));
		Assert.assertTrue(ps.equals(psReverse));
		Assert.assertTrue(psReverse.equals(ps));
		
		
		Assert.assertTrue(pi.equals(pi));
		Assert.assertTrue(pi.equals(pi2));
		Assert.assertTrue(pi.equals(piReverse));
		Assert.assertTrue(piReverse.equals(pi));
		
	}
	
	@Test
	public void equalsArrayList(){
		ArrayList<Double> first = new ArrayList<Double>();
		first.add(1.3);
		first.add(3.9);
		first.add(-10.0);
		
		ArrayList<Double> firstCopy = new ArrayList<Double>();
		firstCopy.addAll(first);
		
		ArrayList<Double> second = new ArrayList<Double>();
		second.add(12.2);
		
		ArrayList<Double> secondCopy = new ArrayList<Double>();
		secondCopy.addAll(second);
		
		ArrayList<Double> other = new ArrayList<>();
		ArrayList<Double> another = new ArrayList<>();
		another.add(-10.0);
		another.add(3.9);
		another.add(1.3);
		
		UnorderedPair<ArrayList<Double>> p1 = new UnorderedPair<>(first, second);
		UnorderedPair<ArrayList<Double>> p2 = new UnorderedPair<>(second, first);
		UnorderedPair<ArrayList<Double>> p3 = new UnorderedPair<>(secondCopy, firstCopy);
		
		UnorderedPair<ArrayList<Double>> pOther = new UnorderedPair<>(first, firstCopy);
		UnorderedPair<ArrayList<Double>> pAnother = new UnorderedPair<>(secondCopy, another);
		
		UnorderedPair<Double> pDouble = new UnorderedPair<>(3.4, 3.2);
		
		// Should be equal
		Assert.assertTrue(p1.equals(p2));
		Assert.assertTrue(p2.equals(p3));
		Assert.assertTrue(p3.equals(p1));
		
		// Should not be equal
		Assert.assertTrue(! p1.equals(pOther));
		Assert.assertTrue(! pOther.equals(p1));
		Assert.assertTrue(! p2.equals(pAnother));
		Assert.assertTrue(! pAnother.equals(p3));
		
		// Different types
		Assert.assertTrue(! p1.equals(new String("nope")));
		Assert.assertTrue(! p1.equals(pDouble));
		Assert.assertTrue(! pDouble.equals(p1));
		
	}
	
	@Test
	public void hashCodeArrayList(){
		ArrayList<Double> first = new ArrayList<Double>();
		first.add(1.3);
		first.add(3.9);
		first.add(-10.0);
		
		ArrayList<Double> firstCopy = new ArrayList<Double>();
		firstCopy.addAll(first);
		
		ArrayList<Double> second = new ArrayList<Double>();
		second.add(12.2);
		
		ArrayList<Double> secondCopy = new ArrayList<Double>();
		secondCopy.addAll(second);
		
		ArrayList<Double> other = new ArrayList<>();
		ArrayList<Double> another = new ArrayList<>();
		another.add(-10.0);
		another.add(3.9);
		another.add(1.3);
		
		UnorderedPair<ArrayList<Double>> p1 = new UnorderedPair<>(first, second);
		UnorderedPair<ArrayList<Double>> p2 = new UnorderedPair<>(firstCopy, secondCopy);
		UnorderedPair<ArrayList<Double>> p3 = new UnorderedPair<>(secondCopy, firstCopy);
		
		// Should be equal
		Assert.assertEquals(p1.hashCode(), p2.hashCode());
		
		// This next check assures that the hash code
		//  does not regard order of the items in ordered pair
		//  as important. Each item's hash code contributes
		//  to the pair's hash code in the same way.
		Assert.assertEquals(p1.hashCode(), p3.hashCode());
				
	}
	
	@Test
	public void hashCodeNonTrivial(){
		UnorderedPair<Integer> p1 = new UnorderedPair<>(3, 7);
		UnorderedPair<Integer> p2 = new UnorderedPair<>(3, 8);
		
		// While not strictly required to be different,
		//  the hash codes for p1 and p2 should be different
		//  in order to work effectively with HashMap, etc.
		Assert.assertTrue(p1.hashCode() != p2.hashCode());
	}
	
}
