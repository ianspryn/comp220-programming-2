import java.util.*;

import org.junit.Assert;
import org.junit.Test;
public class LinkedList<E> {
	//you could use any other single capital letter instead of E

	// NOTE: we use inner class with public
	//   members. Only LinkedList can see this class.
	class Node {
		public E data;
		public Node next;
	}

	// null if the list is empty
	private Node first;

	// Constructs an empty list
	public LinkedList(){
		first = null;
	}

	// Gets the item at the front of the list
	// TODO: Write the getFirst method with the instructor
	E getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
		//will give a null pointer exception if the NOde is empty. So, WE CHECK ABOVE
	}
	// prepends element to the front of the list
	void addFirst(E value) {
		Node newNode = new Node();
		newNode.data = value;
		
		//lhs: arrow/reference to change
		//rhs: where it should point
		newNode.next = first; 
		//assignment statements don't make new nodes: they'll just move the arrow around
		first = newNode;
		//the one you want to change is on the left of the equal sign and the new one is on the right
		//seriously, don't do a LinkedList node without drawing a diagram
	}

	// removes the first element in the list,
	//  returning the data therein
	public E removeFirst(){
		E data = getFirst();
		//left hand side: the arrow reference to change
		//right hand side: where it shold point
		//see 12-1-17 notes for the node graph list thingy at the very top
		first = first.next;
		return data;
	}


	// returns an iterator at the start of the linked list
	public ListIterator<E> iterator(){
		return new LinkedListIterator();
	}


	class LinkedListIterator implements ListIterator<E> {

		// The most recent node visited, null if none yet
		private Node position;

		// The Node before position, null if it does not exist
		private Node previous;

		// true if there was a call to next
		//  without a subsequent call to remove
		private boolean isAfterNext;


		public LinkedListIterator(){
			// TODO: complete this constructor with the instructor
			position = null;
			previous = null;
			isAfterNext = false;
		}

		@Override
		public boolean hasNext() {
			// TODO: complete this method with the instructor
			//what's keeping track of my current position?
			
			//if we crank up a new iterator, and the position is null, and we call .next(),
			//it'll crash
			if (position == null) {
				
				//nothing visited yet; check if there is a first item
				if (first == null) {
					return false;
				} else {
					return true;
				}
				
				//OR REALLY CLEAN CODE: return (first != null);
			}
			if (position.next == null) {
				//position is the last thing
				return false;
			} else {
				return true;
			}
			//REALLY CLEAN CODE: return position.next != null;
		}

		@Override
		public E next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			previous = position;
			if (position == null) {
				position = first;
			} else {
				position = position.next;
			}
			
			//REALLY CLEAN CODE: position = (position == null ? first : position.next);
			
			isAfterNext = true;
			
			return position.data;
			// TODO: complete this method
			
			// NOTE: Which member variables need to change?
			// NOTE: What should they change to? DRAW A DIAGRAM
		}

		@Override
		public void set(E element) {
			// TODO: complete this method with the instructor
			if (!isAfterNext) {
				throw new IllegalStateException();
			}
			
			position.data = element;
		}

		@Override
		public void remove() {
			// NOTE: What are the different cases to consider?
			//       Don't worry about what to do for them yet, just list the cases
			
			//If position is not valid, or isAfterNext is false (Previous is not valid)
			// remove something from the middle of the list
			//				"				start		"
			//				"				end			"
			
			if (!isAfterNext) {
				throw new IllegalStateException();
			}
			
			if (position == first) {
				position = null;
				removeFirst();
			} else {
				position = previous;
				previous = null;
			}
			isAfterNext = false;
		}

		
		/**
		  Adds an element after the most recently visited node
	       and moves the iterator past the inserted element. 
	       @param element the element to add 
	    */
		@Override
		public void add(E element) {
			if (position == null){
				addFirst(element);
				position = first;
			} else {
				// NOTE: I recommend drawing a diagram to figure out what references need to be altered
				
				/*
				Node node = new Node();
				node.next = position.next;
				position.next = node;
				node.data = element;
				MITCHELL */
				
				//make the new node and set its data
				Node newNode = new Node();
				newNode.data = element;
				
				//place the node in the list
				newNode.next = position.next;
				position.next = newNode;
				//the right hand is where am I pointing at
				//the left hand is what am I pointing with
				
				//move position of ListIterator so you get Romeo and not Juliet
				//aka, advance the iterator
				position = newNode;
				//or position = postition.next;
			}
			
			isAfterNext = false;
		}
	}
	
	//WOLFE WORK
	static class LengthLexOrder implements Comparator<String> {

		@Override
		public int compare(String first, String second) {
			if(first.length() < second.length()){
				return -1;
			}
			else if(first.length() > second.length()){
				return 1;
			}
			else{
				// Strings are the same length
				// Check the contents to see 
				//   which is first in alphabetic order
				return first.compareTo(second);
			}
		}
		
	}

	//
	public static void main(String[] args) {
		LinkedList<String> lol = new LinkedList<String>();
		ListIterator<String> iter = lol.iterator();
		iter.add("123");
		iter.add("321");
		Comparator<String> comp = new LengthLexOrder();
		System.out.println("MAX" + lol.max(comp));		
		tryAndCatch();
	}
	
	//friendly user input example
	//4a
	public static void tryAndCatch() throws IllegalArgumentException {
		Scanner scnr = new Scanner(System.in);
		boolean isGoodInput = false;
		while (!isGoodInput) {
			try {
				System.out.println("YO ENTER SOME TEXT");
				String blah = scnr.nextLine();
				foo(blah);
				isGoodInput = true;
			} catch (IllegalArgumentException IAE) {
				throw new IllegalArgumentException();
			}
		}
	}
	
	//check string for blank or just spaces
	//4
	public static void foo (String s) throws IllegalArgumentException {
		if (s == "") {
			throw new IllegalArgumentException("OH NOEZ IT'S EMPTY");
		}
		String noSpace = s.replaceAll("\\s+","");
		if (noSpace.equals("")) {
			throw new IllegalArgumentException("THERE ARE ONLY SPACES");
		} 
		System.out.println("YAY it wasn't empty and it didn't contain just spaces");
	}
	
	
	
	//part 1a
	public E max(Comparator<E> comp) {
			if (this.size() < 1) {
				throw new NoSuchElementException();
			}
			ListIterator<E> iter = this.iterator();
			E max = iter.next();
			while (iter.hasNext()) {
				E next = iter.next();
				if (comp.compare(next, max) > 0) {
					max = next;
				}
			}
			return max;
		}
	
	//part 1a
	public E min(Comparator<E> comp) {
		if (this.size() < 1) {
			throw new NoSuchElementException();
		}
		ListIterator<E> iter = this.iterator();
		E min = iter.next();
		while (iter.hasNext()) {
			E next = iter.next();
			if (comp.compare(next, min) < 0) {
				min = next;
			}
		}
		return min;
	}

	//2 Copy cosntructor
	public LinkedList(LinkedList<E> E) {
		ListIterator<E> iter = E.iterator();
		ListIterator<E> iterNew = this.iterator();
		if (!iter.hasNext()) {
			throw new NoSuchElementException();
		}
		while (iter.hasNext()) {
			iterNew.add(iter.next());
			iterNew.next();
		}
	}
	
	//check if a collection as duplicates
	//3
	public static <T> boolean hasDuplicates(Collection<T> items) {
		Iterator<T> iter1 = items.iterator();
		int pos = 0;
		int pos2 = 0;
		while (iter1.hasNext()) {
			Iterator<T> iter2 = items.iterator();
			T obj1 = iter1.next();
			pos++;
			while (iter2.hasNext()) {
				pos++;
				if (pos == pos2) {
					if (iter2.hasNext()) {
						iter2.next();
					}
				}
				if (obj1.equals(iter2.next())) {
					return true;
				}
			}
			pos2 = 0;
			iter1.next();
		}
		return false;
	}

	public int size() {
		// iterative version
		int count = 0;
		ListIterator<E> iter = iterator();
		
		while(iter.hasNext()) {
			count++;
			iter.next();
		}
		return count;
	}
	
	public int size2(){
		// recursive version
		return sizeRecursive(first);		
	}
	
	//we need some argument to keep track of where we are for the recursion
	//returns the number of NDOes in the list starting at n
	private int sizeRecursive(Node n) {
		if (n == null) {
			//base case
			return 0;
		} else {
			return 1 + sizeRecursive(n.next);
			//how many nodes are there from n onward?
		}
	}
}
