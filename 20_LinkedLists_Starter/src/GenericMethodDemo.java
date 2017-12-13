import java.util.ArrayList;

public class GenericMethodDemo {
	
	/**
	 * @return number of items in things that are equal to target
	 * @param things
	 * @param target
	 */
	public static <T> int countMatches(ArrayList<T> things, T target) {
		int count = 0;
		for (int i = 0; i < things.size(); i++) {
			if (target.equals(things.get(i))) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String args[]) {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("hello");
		strings.add("bye");
		strings.add("hello");
		
		System.out.println(countMatches(strings, "hello"));
	}
}


/*
 * could this be a generic method or class?
 * Most of the code would work if we change one of the types
 * Like, other ints, doubles, or even other ArrayLists
 * If so, the other code remains the same, then YAY add a type paramter <T>
 * between the modifiers and before the return type
*/
