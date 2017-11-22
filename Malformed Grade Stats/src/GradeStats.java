import java.io.*;
import java.util.*;

public class GradeStats {

	public static void main(String args[]) throws FileNotFoundException {
		//import txt file
		File gradesFile = new File("grades.txt");
		Scanner scanGrades = new Scanner(gradesFile);
		
		//used to hold the grades from the txt file
		ArrayList<Double> grades = new ArrayList<Double>();
		
		while (scanGrades.hasNext()) {
			if (scanGrades.hasNextInt()) {
				grades.add(scanGrades.nextDouble());
			} else {
				scanGrades.next();
			}
		}
		
		scanGrades.close();
		
		//sort from min to max
		Collections.sort(grades);
		
		//find minimum
		System.out.println(grades.get(0));
		//find maximum
		System.out.println(grades.get(grades.size() - 1));
		//find average
		double average = 0;
		for (int i = 0; i < grades.size(); i++) {
			average += grades.get(i);
		}
		average /= grades.size();
		System.out.println(average);
		
		//find standard deviation
		double ss = 0;
		for (int i = 0; i < grades.size(); i++) {
			ss += Math.pow(grades.get(i) - average, 2);
		}
		double sd = Math.sqrt(ss / (grades.size() - 1));
		System.out.printf("%.1f", sd);
		
	}
}
