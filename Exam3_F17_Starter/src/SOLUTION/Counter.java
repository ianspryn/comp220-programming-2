import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author WOLFEBD
 * Holds static methods for counting things
 */
public class Counter {
	/**
	 * Opens the file given by @param filename
	 * @return A map where the keys are the characters that are present
	 *   in the file and the value for each character is the
	 *   number of times that character occurred in the file.
	 */
	public static Map<Character, Integer> characterFrequencies(String filename)
	throws IOException{
		Map<Character, Integer> build = new HashMap<Character, Integer>();
		Scanner scnr = new Scanner(new File(filename));
		scnr.useDelimiter("");
		
		while(scnr.hasNext()){
			char a = scnr.next().charAt(0);
			if(!Character.isWhitespace(a)){
				if(build.containsKey(a)){
					int get = build.get(a) + 1;
					build.put(a, get);
				} else {
					build.put(a, 1);
				}
			} 
		}
		
		scnr.close();
		return build;

	}

}
