 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.PrintWriter;
 import java.util.Scanner;

 /**
7 This program reads a file with numbers, and writes the numbers to
another
8 file, lined up in a column and followed by their total.
 */
 public class CharCounter
 {
 public static void main(String[] args) throws FileNotFoundException
 {
 // Prompt for the input and output file names

	 String inputFileName = "in.txt";
	 
 Scanner console = new Scanner(System.in);
 
 System.out.print("Output file: ");
 String outputFileName = console.next();

 // Construct the Scanner and PrintWriter objects for reading and


 File inputFile = new File(inputFileName);
 Scanner in = new Scanner(inputFile);
 PrintWriter out = new PrintWriter(outputFileName);

 // Read the input and write the output

 //count the number of letters/digits/whitespace/other/junk/idc/whatevz/i'm bored
 
 int letters = 0;
 int digits = 0;
 int whitespace = 0;
 int others = 0;
 
 in.useDelimiter("");
 
 while(in.hasNext()) {
	 char scan = in.next().charAt(0);
	 
	 if (Character.isLetter(scan)) {
		 letters++;
	 } else if(Character.isDigit(scan)) {
		 digits++;
	 } else if (Character.isWhitespace(scan)) {
		 whitespace++;
	 } else {
		 others++;
	 }
 }
 
 out.printf("letters: " + letters + "\n");
 out.printf("digits: " + digits + "\n");
 out.printf("whitespace: " + whitespace + "\n");
 out.printf("others: " + others);

 in.close();
 out.close();
 }
 }