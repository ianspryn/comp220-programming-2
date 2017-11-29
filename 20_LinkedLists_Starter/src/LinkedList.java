import java.util.NoSuchElementException;

import javax.xml.soap.Node;

public class LinkedList {

	// NOTE: we use inner class with public
	//   members. Only LinkedList can see this class.
	class Node {
		public Object data;
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
	Object getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
		//will give a null pointer exception if the NOde is empty. So, WE CHECK ABOVE
	}
	// prepends element to the front of the list
	// TODO: Write the addFirst method with the instructor
	void addFirst(Object value) {
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
	public Object removeFirst(){
		// TODO: complete this method
	}


	// returns an iterator at the start of the linked list
	public ListIterator iterator(){
		return new LinkedListIterator();
	}


	class LinkedListIterator implements ListIterator {
		// The most recent node visited, null if none yet
		private Node position;

		// The Node before position, null if it does not exist
		private Node previous;

		// true if there was a call to next
		//  without a subsequent call to remove
		private boolean isAfterNext;


		public LinkedListIterator(){
			// TODO: complete this constructor with the instructor
		}

		@Override
		public boolean hasNext() {
			// TODO: complete this method with the instructor
		}

		@Override
		public Object next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			
			// TODO: complete this method
			
			// NOTE: Which member variables need to change?
			// NOTE: What should they change to? DRAW A DIAGRAM
		}

		@Override
		public void set(Object element) {
			// TODO: complete this method with the instructor
		}

		@Override
		public void remove() {
			// NOTE: What are the different cases to consider?
			//       Don't worry about what to do for them yet, just list the cases

			// TODO: complete this method with the instructor
		}

		
		/**
		  Adds an element after the most recently visited node
	       and moves the iterator past the inserted element. 
	       @param element the element to add 
	    */
		@Override
		public void add(Object element) {
			if (position == null){
				addFirst(element);
				position = first;
			}
			else{
				// TODO: complete this part in groups
				// NOTE: I recommend drawing a diagram to figure out what references need to be altered

			}
			
			isAfterNext = false;
		}




	}

	public int size(){
		// iterative version
		// TODO: complete this with the instructor
	}
	
	public int size2(){
		// recursive version
		// TODO: complete this with the instructor
	}
}
