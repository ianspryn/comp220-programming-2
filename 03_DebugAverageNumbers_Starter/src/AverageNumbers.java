/**
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author WOLFEBD
 * Calculates the average of a set of integers from a file
 * Calculates what percentage of the numbers were above average
 */
public class AverageNumbers {

	/**
	 * @param filename containing a whitespace-delimited set of integers
	 * @return list of integers from the file
	 * @throws FileNotFoundException
	 */
	private static ArrayList<Integer> getNumbers(String filename) throws FileNotFoundException{
		File inputFile = new File(filename);
		Scanner in = new Scanner(inputFile);
		
		ArrayList<Integer> result = new ArrayList<>();
		
		while(in.hasNextInt()){
			result.add(Integer.parseInt(in.next())); 
		}
		in.close();
		
		return result;
	}
	
	/**
	 * @param numbers should not be empty
	 * @return The average of the values in numbers
	 */
	private static double average(ArrayList<Integer> numbers){
		double sum = 0;
		for(int i=0; i<numbers.size(); i++){
			sum += numbers.get(i);  
		}
		double avg = sum / numbers.size();
		return avg;
	}
	
	/**
	 * @return The percent of values in numbers that are above threshold
	 */
	private static double percentAbove(ArrayList<Integer> numbers, double threshold){
		int count = 0;
		for(int i=0; i<numbers.size(); i++){ 
			if(numbers.get(i) > threshold){
				count++;
			}
			else{
				count--;
			}
		}
		return 100.0 * (count / numbers.size()); 
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// Specify command-line arguments in Eclipse with "Run Configurations" dialog box

		String inputFilename = args[0];
		String outputFilename = args[1];
		
		ArrayList<Integer> numbers = getNumbers(inputFilename);
		
		double avg = average(numbers);
		double percentAboveAvg = percentAbove(numbers, avg);
		
		PrintWriter out = new PrintWriter(outputFilename);
		out.println("Average: " + avg);
		out.println("Percent above average: " + percentAboveAvg);
		out.close();
		
	}

}
