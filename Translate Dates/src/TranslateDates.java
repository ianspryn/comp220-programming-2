import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TranslateDates {
	
	public static void main(String[] args) throws IOException{
		File dates = new File("dates.txt");
		Scanner scnDates = new Scanner(dates);
		File translatedFile = new File("translated.txt");
		PrintWriter write = new PrintWriter(translatedFile);
		
		while(scnDates.hasNextLine()){
			
			Scanner date = new Scanner(scnDates.nextLine());
			date.useDelimiter("-");
			
			int month = date.nextInt();
			int day = date.nextInt();
			int partialYear = date.nextInt();
			
			write.println((partialYear < 40 ? 2000 + partialYear : 1900 + partialYear) + "/" + month + "/" + day);
			
			date.close();
		}
		
		scnDates.close();
		write.close();
	}

}



/*
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TranslateDates {

	public static void main(String args[]) throws FileNotFoundException {

		String inputFileName = "dates.txt";
		String outputFileName = "translated.txt";
			 
		Scanner lineParser = new Scanner(inputFileName);
		
		
		File f = new File(inputFileName);
		Scanner fileIn = new Scanner (f);
		
		
		
		
		
		while (lineParser.hasNextLine()) {
			
			fileIn = new Scanner(lineParser.nextLine());
			fileIn.useDelimiter("-");
			
			String newDate = "";
			String month = "";
			String day = "";
			String year = "";
			
			int scan = fileIn.nextInt();
			month = Integer.toString(scan);
			scan = fileIn.nextInt();
			day = Integer.toString(scan);
			scan = fileIn.nextInt();
			if (scan < 40) {
				year = "20" + Integer.toString(scan);
			} else {
				year = "19" + Integer.toString(scan);
			}
			
			newDate = year + "/" + month + "/" + day; 
			
			fileOut.printf(newDate);
			
			
			
		}
		fileIn.close();
		fileOut.close();
		}
		

	}

*/