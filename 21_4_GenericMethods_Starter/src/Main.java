import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {

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

}
