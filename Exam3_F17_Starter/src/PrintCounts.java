import java.io.IOException;
import java.util.Map;

/**
 * @author WOLFEBD
 * Counts and prints the (non-whitespace) character frequencies for a file
 */
public class PrintCounts {
	public static void main(String[] args) throws IOException{
		String filename = "src/Worker.java";
		Map<Character, Integer> counts = Counter.characterFrequencies(filename);
		for(Character c : counts.keySet()){
			if(!Character.isWhitespace(c)){
				System.out.println("'" + c + "'" + " " + counts.get(c));
			}
		}
	}
}
