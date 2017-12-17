import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Misc {
	
	public static <E extends Comparable<E>> int countLess(E val, Collection<E> items) {
		Iterator<E> iter = items.iterator();
		int count = 0;
		if (!iter.hasNext()) {
			throw new NoSuchElementException();
		}
		E current = null;
		while (iter.hasNext()) {
			current = iter.next();
			if (current.compareTo(val) < 0) {
				count++;
			}
		}
		return count;
	}
	
	public static <T> Map<T, Integer> combine(Map<T, Integer> first, Map<T, Integer> second) {
		HashMap<T, Integer> map = new HashMap<>();

		map.putAll(first);
		map.putAll(second);
		return map;
	}
	
	/*
	 * isAlphaOrder should return true if the characters in str are in alphabetic order
	 * 
	 */
	public static boolean isAlphaOrder(String str){
		boolean sorted = false;
		if (str.length() == 1) {
			return true;
		}	        
		if (str.charAt(str.length() - 1) > str.charAt(str.length() - 2)) {
			sorted = isAlphaOrder(str.substring(0, str.length() - 2));
			return sorted;
		}
		return false;
	}
	
	
	/* Returns a matrix from a string of whitespace delimited doubles
	 * See the exam instructions for details.
	 */
	public static ArrayList< ArrayList<Double> > readMatrix(String bigString){
		Scanner scnr = new Scanner(bigString);
		//ArrayList<ArrayList<Double>> mat = new ArrayList<>();
		ArrayList<Double> array1 = new ArrayList<>();
		ArrayList<ArrayList<Double>> array2 = new ArrayList<>();
		
		while(scnr.hasNextLine()) {
			Scanner line = new Scanner(scnr.nextLine());
			while (line.hasNextDouble()) {
				array1.add(line.nextDouble());
			}
			array2.add(array1);
			array1.clear();
		}
		return array2;
	}
}
