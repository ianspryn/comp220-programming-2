import java.util.Scanner;

public class CheckDate {

	public static void main(String args[]) {

	/*	 String inputFileName = "in.txt";
		 
		 Scanner console = new Scanner(System.in);
		 
		 System.out.print("Output file: ");
		 String outputFileName = console.next();
		 
		 Scanner lineParser = new Scanner(inputFileName);*/
		
		Scanner scnr = new Scanner ("3/5/2016\n4/28/2000");
		System.out.println(checkDateBounds(scnr));
		
	}
	
	public static boolean checkDateBounds (Scanner main) {
		
		
		Scanner in;
		
		
		
		while (main.hasNextLine()) {
			
			in = new Scanner(main.nextLine());
			in.useDelimiter("/");
			
			int scan = in.nextInt();
			if (scan > 0 && scan < 13) {
				scan = in.nextInt();
				
				if (scan > 0 && scan < 32) {
					scan = in.nextInt();
					
					if (scan > 1899 && scan < 2100) {
						//Then we have a correct date
						in.close();
					} else {
						in.close();
						return false;
					}
				} else {
					in.close();
					return false;
				}
			} else {
				in.close();
				return false;
			}
		}
		
		return true;
		
	}

}
