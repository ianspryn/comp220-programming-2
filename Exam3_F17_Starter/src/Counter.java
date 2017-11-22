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
		
		String content = new Scanner(new File(filename)).useDelimiter("\\Z").next();
		
        Map<Character, Integer> frequencies = new HashMap<>();
        
        int totalCount = 0;
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			
			int oldCount = 0;
			if (frequencies.containsKey(c)) {
				oldCount = frequencies.get(c);
			}
			
			frequencies.put(c, 1 + frequencies.getOrDefault(c, 0));
			
			
			totalCount++;
		}
        
        
        return frequencies;
	}

}
