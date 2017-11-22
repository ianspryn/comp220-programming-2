import java.util.*;
import java.io.*;

public class AverageScores {

	

	public static void main(String[] args) {
		
		//Prompt user for input and output file names
		Scanner console = new Scanner(System.in);
		System.out.println("Enter input filename" );
		String inFileName = console.next();
		
		System.out.println("Enter output filename" );
		String outFileName = console.next();
		
		try {
			//open input file, make a Scanner
			File f = new File(inFileName);
			Scanner fileIn = new Scanner (f);
			
			PrintWriter fileOut = new PrintWriter(outFileName);
			
			//read the number of scores per person
			if (!fileIn.hasNextInt()) {
				//TODO: error handling
			}
			
			final int numScores = fileIn.nextInt();
			
			//Loop as long as there are lines to read
			while(fileIn.hasNext()) {
				//read name into string variables
				String name = fileIn.next();
				
				
				
				//add scores
				double total = 0.0;
				for (int i = 0; i < numScores; i++) {
					total += fileIn.nextDouble();
				}
				
				//compute average
				double average = total / numScores;
				
				//print results
				fileOut.printf("%s %.2f\n", name, average);
			}
			
			fileIn.close();
			fileOut.close();
			
		}
		catch (IOException ioe) {
			System.err.println("FIle error");
		}

	}

}
