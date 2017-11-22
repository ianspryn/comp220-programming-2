import java.util.Scanner;

public class DUMBEST {

	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Hey there! Would you OH SO KINDLY tell me the raw score?");
		Double score = scnr.nextDouble();
		
		Double studentScore = score * 100;
		
		System.out.println("The score is " + studentScore + "%!!!!!!!!!!!!!");
	}

}