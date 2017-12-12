import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class LinkedListTest {
	LinkedList emptyList = new LinkedList();
	LinkedList oneString = new LinkedList();
	LinkedList twoStrings = new LinkedList();
	//LinkedList threeStrings = new LinkedList();
	LinkedList tenStrings = new LinkedList();

	@Before
	public void setUp(){
		oneString.addFirst("one");

		{
			twoStrings.addFirst("one");
			ListIterator iter = twoStrings.iterator();
			iter.next();
			iter.add("two");
		}

		{
			ListIterator iter = tenStrings.iterator();
			iter.add("one");
			iter.add("two");
			iter.add("three");
			iter.add("four");
			iter.add("five");
			iter.add("six");
			iter.add("seven");
			iter.add("eight");
			iter.add("nine");
			iter.add("ten");
		}
	}

	@Test
	public void listConstruction(){
		boolean caught = false;
		try{
			emptyList.getFirst();
		}
		catch(NoSuchElementException e){
			caught = true;
		}
		if(!caught){
			throw new RuntimeException("emptyList had a first item!");
		}


		Assert.assertEquals("one", oneString.getFirst());


		ListIterator iter;

		iter = twoStrings.iterator();
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("one", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("two", iter.next());
		Assert.assertTrue(! iter.hasNext());

		iter = tenStrings.iterator();
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("one", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("two", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("three", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("four", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("five", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("six", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("seven", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("eight", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("nine", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("ten", iter.next());
		Assert.assertTrue(! iter.hasNext());

	}

	@Test
	public void containsEmpty(){
		Assert.assertTrue(! emptyList.contains("one") );
		Assert.assertTrue(! emptyList.contains("") );
	}

	@Test
	public void containsLengthOne(){
		LinkedList lst = oneString;
		String s = new String("one");
		Assert.assertTrue(lst.contains("one"));
		Assert.assertTrue(lst.contains(s));
		Assert.assertTrue(!lst.contains(""));
		Assert.assertTrue(!lst.contains("o"));
	}

	@Test
	public void containsLengthTwo(){
		LinkedList lst = twoStrings;
		String uno = new String("one");
		String dos = new String("two");
		String tres = new String("three");

		Assert.assertTrue(lst.contains(uno));
		Assert.assertTrue(lst.contains(dos));
		Assert.assertTrue(!lst.contains(tres));
	}

	@Test
	public void containsLengthTen(){
		LinkedList lst = tenStrings;
		String uno = new String("one");
		String dos = new String("two");
		String tres = new String("three");
		String diez = new String("ten");
		String nope = new String("nope");
		ArrayList<String> no = new ArrayList<>();

		Assert.assertTrue(lst.contains(uno));
		Assert.assertTrue(lst.contains(dos));
		Assert.assertTrue(lst.contains(tres));
		Assert.assertTrue(lst.contains(diez));
		Assert.assertTrue(!lst.contains(nope));
		Assert.assertTrue(!lst.contains(no));
	}


	@Test
	public void tailEmpty(){
		boolean caught = false;
		try {
			emptyList.tail();
		}
		catch (NoSuchElementException e){
			caught = true;
		}
		Assert.assertTrue(caught);
	}

	@Test
	public void tailLengthOne(){
		LinkedList lst = oneString;
		LinkedList tail = lst.tail();

		Assert.assertTrue(! tail.iterator().hasNext());
	}

	@Test
	public void tailLengthTwo(){
		LinkedList lst = twoStrings;
		LinkedList tail = lst.tail();

		{
			ListIterator iter = lst.iterator();
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("one", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("two", iter.next());
			Assert.assertTrue(!iter.hasNext());

		}

		{
			ListIterator iter = tail.iterator();
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("two", iter.next());
			Assert.assertTrue(!iter.hasNext());

		}
	}

	@Test
	public void tailLengthTen(){
		LinkedList lst = tenStrings;
		LinkedList tail = lst.tail();

		{
			ListIterator iter = lst.iterator();
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("one", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("two", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("three", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("four", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("five", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("six", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("seven", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("eight", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("nine", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("ten", iter.next());
			Assert.assertTrue(! iter.hasNext());
		}

		{
			ListIterator iter = tail.iterator();
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("two", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("three", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("four", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("five", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("six", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("seven", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("eight", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("nine", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("ten", iter.next());
			Assert.assertTrue(! iter.hasNext());
		}
	}
	
	@Test
	public void tailShallowCopy(){
		LinkedList lst = new LinkedList();
		lst.addFirst("dos");
		lst.addFirst("uno");
		
		LinkedList tail = lst.tail();
		
		{
			ListIterator iter = lst.iterator();
			iter.next();
			iter.next();
			iter.add("tres");
		}
		// "dos" should now point to "tres" in BOTH LISTS
		{
			ListIterator iter = lst.iterator();
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("uno", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("dos", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("tres", iter.next());
			Assert.assertTrue(!iter.hasNext());
		}

		{
			ListIterator iter = tail.iterator();
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("dos", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("tres", iter.next());
			Assert.assertTrue(!iter.hasNext());
		}
	}
	
	
	
	@Test
	public void reverseEmpty(){
		LinkedList lst = new LinkedList();
		lst.reverse();
		
		Assert.assertTrue(!lst.iterator().hasNext());
		Assert.assertEquals(0, lst.size());
	}

	@Test
	public void reverseLengthOne(){
		LinkedList lst = new LinkedList();
		lst.addFirst(new Integer(10));
		lst.reverse();
		
		Assert.assertTrue(lst.iterator().hasNext());
		Assert.assertEquals(new Integer(10), lst.getFirst());
		Assert.assertEquals(1, lst.size());
	}

	@Test
	public void reverseLengthTwo(){
		LinkedList lst = new LinkedList();
		lst.addFirst("original second");
		lst.addFirst("original first");
		lst.reverse();
		
		{
			ListIterator iter = lst.iterator();
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original second", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original first", iter.next());
			Assert.assertTrue(!iter.hasNext());
		}
	}

	@Test
	public void reverseLengthThree(){
		LinkedList lst = new LinkedList();
		lst.addFirst("original third");
		lst.addFirst("original second");
		lst.addFirst("original first");
		lst.reverse();
		
		{
			ListIterator iter = lst.iterator();
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original third", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original second", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original first", iter.next());
			Assert.assertTrue(!iter.hasNext());
		}
	}
	
	@Test
	public void reverseLengthSix(){
		LinkedList lst = new LinkedList();
		lst.addFirst("original sixth");
		lst.addFirst("original fifth");
		lst.addFirst("original fourth");
		lst.addFirst("original third");
		lst.addFirst("original second");
		lst.addFirst("original first");
		lst.reverse();
		
		{
			ListIterator iter = lst.iterator();
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original sixth", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original fifth", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original fourth", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original third", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original second", iter.next());
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals("original first", iter.next());
			Assert.assertTrue(!iter.hasNext());
		}
	}
	
	@Test
	public void sizeEmpty(){
		Assert.assertEquals(0, emptyList.size());
	}

	@Test
	public void sizeLengthOne(){
		Assert.assertEquals(1, oneString.size());
	}

	@Test
	public void sizeLengthTwo(){
		Assert.assertEquals(2, twoStrings.size());
	}

	
	@Test
	public void sizeLengthTen(){
		Assert.assertEquals(10, tenStrings.size());
	}

	@Test
	public void sizeUpdateRemoveFirst(){
		LinkedList lst = new LinkedList();
		lst.addFirst("a");
		lst.addFirst("b");
		
		Assert.assertEquals(2, lst.size());
		lst.removeFirst();
		Assert.assertEquals(1, lst.size());
		lst.removeFirst();
		Assert.assertEquals(0, lst.size());
		
		try{
			lst.removeFirst();
		}
		catch(NoSuchElementException e){
			// this is expected
		}
		Assert.assertEquals(0, lst.size());
	}

	@Test
	public void sizeUpdateAddFirst(){
		LinkedList lst = new LinkedList();
		Assert.assertEquals(0, lst.size());
		lst.addFirst("a");
		Assert.assertEquals(1, lst.size());
		lst.addFirst("b");
		Assert.assertEquals(2, lst.size());
	}
	
	@Test
	public void sizeUpdateIterAddFirst(){
		LinkedList lst = new LinkedList();
		lst.addFirst("a");
		lst.iterator().add("first!");
		Assert.assertEquals(2, lst.size());
	}

	@Test
	public void sizeUpdateIterRemoveFirst(){
		LinkedList lst = new LinkedList();
		lst.addFirst("b");
		lst.addFirst("a");
		ListIterator iter = lst.iterator();
		iter.next();
		iter.remove();
		
		Assert.assertEquals(1, lst.size());
	}
	
	@Test
	public void sizeUpdateIterRemoveFirstAndOnly(){
		LinkedList lst = new LinkedList();
		lst.addFirst("a");
		ListIterator iter = lst.iterator();
		iter.next();
		iter.remove();
		
		Assert.assertEquals(0, lst.size());
	}
	
	@Test
	public void sizeUpdateIterAddMiddle(){
		LinkedList lst = new LinkedList();
		lst.addFirst("c");
		lst.addFirst("b");
		lst.addFirst("a");
		ListIterator iter = lst.iterator();
		iter.next();
		iter.next();
		iter.add("10");
		Assert.assertEquals(4, lst.size());
		iter.add("11");
		Assert.assertEquals(5, lst.size());
		iter.next();
		iter.add("12");
		Assert.assertEquals(6, lst.size());
	}
	
	@Test
	public void sizeUpdateIterRemoveMiddle(){
		LinkedList lst = new LinkedList();
		lst.addFirst("e");
		lst.addFirst("d");
		lst.addFirst("c");
		lst.addFirst("b");
		lst.addFirst("a");
		ListIterator iter = lst.iterator();
		iter.next();
		iter.next();
		iter.remove();
		Assert.assertEquals(4, lst.size());
		iter.next();
		iter.remove();
		Assert.assertEquals(3, lst.size());
		iter.next();
		iter.remove();
		Assert.assertEquals(2, lst.size());
	}
	
	@Test
	public void sizeUpdateMix(){
		LinkedList lst = new LinkedList();
		lst.addFirst("e");
		lst.addFirst("d");
		lst.addFirst("c");
		lst.addFirst("b");
		lst.addFirst("a");
		ListIterator iter = lst.iterator();
		iter.next();
		iter.next();
		iter.remove();
		Assert.assertEquals(4, lst.size());
		iter.next();
		iter.add("X");
		Assert.assertEquals(5, lst.size());
		lst.addFirst("Y");
		Assert.assertEquals(6, lst.size());
		ListIterator iter2 = lst.iterator();
		iter2.add("Z");
		Assert.assertEquals(7, lst.size());
		lst.removeFirst();
		Assert.assertEquals(6, lst.size());
		lst.removeFirst();
		Assert.assertEquals(5, lst.size());
	}
	
	@Test
	public void sizeConstantTimeCheck(){
		LinkedList lst = new LinkedList();
		for(int i=0; i<1000111; i++){
			lst.addFirst("x");
			Assert.assertEquals(i+1, lst.size());
		}
	}

}