import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetPractice {
	
	public static void main(String args[]) {
		Set<Integer> a = new HashSet<Integer>();
		a.add(3);
		a.add(5);
		a.add(6);
		a.add(7);
		
		Set<Integer> b = new HashSet<Integer>();
		b.add(2);
		b.add(5);
		b.add(7);
		
		removeCommon(a, b);
		
		System.out.println("A!!" + Arrays.asList(a.toArray()));
		System.out.println("B!!" + Arrays.asList(b.toArray()));
	}

	public static void removeCommon(Set<Integer> first, Set<Integer> second) {

		ArrayList<Integer> commonElements = new ArrayList<Integer>(first);
		commonElements.retainAll(second);
		
		Iterator<Integer> firstSet = first.iterator();
		while (firstSet.hasNext())
		{
		    int element = firstSet.next();
		    boolean isCommon = false;
		    for (Integer integer : commonElements) {
		    	if (integer == element) {
		    		isCommon = true;
		    	}
		    }
		    if (isCommon) {
		    	firstSet.remove();
		    }
		}
		
		Iterator<Integer> secondSet = second.iterator();
		while (secondSet.hasNext())
		{
		    int element = secondSet.next();
		    boolean isCommon = false;
		    for (Integer integer : commonElements) {
		    	if (integer == element) {
		    		isCommon = true;
		    	}
		    }
		    if (isCommon) {
		    	secondSet.remove();
		    }
		}	
	}
}