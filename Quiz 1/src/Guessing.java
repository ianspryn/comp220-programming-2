import java.util.Random;
import java.util.Scanner;

public class Guessing {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scnr = new Scanner(System.in);
		
		// target is between 1 and 100, inclusive
		// This is the secret number we want the user to guess
		final int target = rand.nextInt(100) + 1;
		
		boolean guessCorrect = false;
		
		while(!guessCorrect) {
			System.out.println("Guess a number: ");
			int userGuess = scnr.nextInt();
			
			if (target > userGuess) {
				System.out.println("That is too low");
			} else if (target < userGuess) {
				System.out.println("That is too high");
			} else {
				System.out.println("That is correct!");
				guessCorrect = true;
			}
		}
		
		scnr.close();

	}

}
