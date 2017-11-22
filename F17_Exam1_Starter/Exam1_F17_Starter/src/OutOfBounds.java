import java.io.*;
import java.util.*;

public class OutOfBounds {
	
	public static void main(String args[]) throws FileNotFoundException {
		File valuesFile = new File("values.txt");
		Scanner scanValues = new Scanner(valuesFile);
		Scanner scanValuesArrayList = new Scanner(valuesFile);
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		File f = new File("counts.txt");
		PrintWriter write = new PrintWriter(f);
		
		while(scanValues.hasNextLine()){
			
			Scanner comment = new Scanner(scanValues.nextLine());
			comment.useDelimiter("// ");
			
			numbers.add(scanValues.nextInt());
			
			
			
			
		}
		
		

		
		scanValues.close();
		write.close();

	}
	
	public static void OutofBounds (int min, int max) {
		
	}
}
