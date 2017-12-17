import java.util.NoSuchElementException;

public class LinkedList<E> {

	// NOTE: we use inner class with public
	//   members. Only LinkedList can see this class.
	class Node {
		public E data;
		public Node next;
	}

	// null if the list is empty
	private Node first;

	
	/**
	 * @return the number of items in this list that are .equals to @param target
	 */
	public int count(E target){
		ListIterator<E> iter = this.iterator();
		int count = 0;
		if (!iter.hasNext()) {
			throw new NoSuchElementException();
		}
		E value = null;
		while (iter.hasNext()) {
			value = iter.next();
			if (value.equals(target)) {
				count++;
			}
		}
		return count;		
	}
	
	// Constructs an empty list
	public LinkedList(){
		first = null;
	}

	// Gets the item at the front of the list
	public E getFirst(){
		if(first == null){
			throw new NoSuchElementException();
		}
		return first.data;
	}

	// prepends element to the front of the list
	public void addFirst(E element){
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
	}
	
	public E removeFirst(){
		if (first == null){
			throw new NoSuchElementException();
		}
		E element = first.data;
		first = first.next;
		
		return element;
	}

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
			position = null;
			previous = null;
			isAfterNext = false;
		}

		@Override
		public boolean hasNext() {
			if(position == null){
				// Nothing visited yet, so
				// next would be the first thing in the list
				return first != null;
			}
			else{
				// See if something is after position
				return position.next != null;
			}
		}

		@Override
		public E next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			isAfterNext = true;
			previous = position;
			position = (position == null ? first : position.next);

			return position.data;
		}

		@Override
		public void set(E element) {
			if (!isAfterNext) {
				throw new IllegalStateException();
			}
			position.data = element;
		}

		@Override
		public void remove() {
			if (!isAfterNext) {
				throw new IllegalStateException();
			}

			isAfterNext = false;

			if (position == first){
				removeFirst();
				position = null;
			}
			else{
				previous.next = position.next;
				position = previous;
			}

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
			}
			else{
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
			
			isAfterNext = false;
		}

	}

}
