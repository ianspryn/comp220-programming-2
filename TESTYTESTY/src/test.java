import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class test {
    public static int solution(int[] A) {
        // write your code in Java SE 8
    	Arrays.sort(A);
        boolean containsNumber = true;
        for (int i = 0; i < A.length; i++) {
            if (!((A[i + 1] - A[i]) == 1)) {
                return A[i] + 1;
            }
        }
        return A[A.length - 1] + 1;
    }
    
    public static ArrayList<Integer> removeNegatives(int[] array) {
		
    	ArrayList<Integer> noNegatives = new ArrayList<Integer>();
    	
    	return null;
    	
    }
    
    public static ArrayList<Integer> removeValues(int[] array) {
    	
    	ArrayList<Integer> noDuplicates = new ArrayList<Integer>();
    	int last = 0;
    	
    	for(int value: array) {
    		if (value != last) {
    			noDuplicates.add(value);
    		}
    		
    		last = value;
    	}
    	
    	return noDuplicates;
    	
    }

    public static void main(String args[]) {
    	int[] ok = new int[] {3, 2, 7, 6, 5, 4, 8, 9, 10, 13, 12};
    	
    	System.out.println(removeDuplicates(ok));
    	//System.out.println(Arrays.toString(ok));
    	System.out.println(solution(ok));
	}
    
}