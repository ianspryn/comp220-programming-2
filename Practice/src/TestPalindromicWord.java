import java.util.Scanner;

public class TestPalindromicWord {
	public static void main(String[] args) {
		System.out.println("Gimme a sentence");
		Scanner scnr = new Scanner(System.in);
		String input = scnr.nextLine().toLowerCase().replaceAll("[\\s+ ' [-] , . \" \' ? !]","");
		System.out.println("Formatted: " + input);
		
		boolean isPalindromic = true;
		for (int i = 0; i < input.length() / 2; i++) {
			if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
				isPalindromic = false;
				break;
			}
		}
		System.out.println(isPalindromic);		
	}
}
