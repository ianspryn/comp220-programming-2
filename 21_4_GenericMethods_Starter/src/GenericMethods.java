import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericMethods {
	//Convert from ArrayList to Collection
	//5.a
	//find max
	public static <T extends Comparable<T>> T max(Collection<T> xs){
		
		if (xs.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		Iterator<T> blah = xs.iterator();
		
		T bestSoFar = blah.next();
		
		while(blah.hasNext()) {
			// NOTE: can call compareTo because T has that method
			T currentPosition = blah.next();
			if(currentPosition.compareTo(bestSoFar) > 0){
				// xs @ i is > bestSoFar
				bestSoFar = currentPosition;
			}
		}
		
		return bestSoFar;
	}
	
	//find max using recursive
	//1.b
	//broken
	public static <T extends Comparable<T>> T maxRecursive(Iterator<T> iter) {
		if (!iter.hasNext()) {
			throw new NoSuchElementException("AHHH FAIL");
		}
		T bestSoFar = null;
		
		if (iter.hasNext()) {
			bestSoFar = iter.next();
			T currentPosition = maxRecursive(iter);
			if (currentPosition.compareTo(bestSoFar) > 0) {
				bestSoFar = currentPosition;
			}
		}
		return bestSoFar;
	}
	
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("hello");
		strings.add("bye");
		strings.add("this is the max");
		
		Iterator<String> blah = strings.iterator();
		
		System.out.println(max(strings));
		System.out.println(maxRecursive(blah));
		
		ArrayList< NoSuchElementException > wontWork = new ArrayList<>();
		wontWork.add(new NoSuchElementException("x"));
		wontWork.add(new NoSuchElementException("y"));
		
		// Since NoSuchElementException is not Comparable,
		// the following line would cause an error:
		// max(wontWork);
	}
	

	/*
	// NOTE: type parameter comes before return type
	// NOTE: "extends Comparable<T>" is a constraint on the type
	public static <T extends Comparable<T>> T max(ArrayList<T> xs){
		if(xs.isEmpty()){
			throw new NoSuchElementException();
		}
		
		T bestSoFar = xs.get(0);
		for(int i=1; i<xs.size(); i++){
			// NOTE: can call compareTo because T has that method
			if(xs.get(i).compareTo(bestSoFar) > 0){
				// xs @ i is > bestSoFar
				bestSoFar = xs.get(i);
			}
		}
		
		return bestSoFar;
	}
	
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("hello");
		strings.add("bye");
		strings.add("this is the max");
		
		System.out.println(max(strings));
		
		ArrayList< NoSuchElementException > wontWork = new ArrayList<>();
		wontWork.add(new NoSuchElementException("x"));
		wontWork.add(new NoSuchElementException("y"));
		
		// Since NoSuchElementException is not Comparable,
		// the following line would cause an error:
		// max(wontWork);
	}
	*/
}
