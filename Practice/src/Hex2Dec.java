import java.util.Scanner;

public class Hex2Dec {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a hexadecimal");
		String number = scnr.nextLine().toLowerCase();
		if (!number.matches("[0123456789abcdef]+")) {
			System.out.println("Wrong kind of numbers bub (aka, NOT IN HEXADECIMAL FORM)");
		} else {
			System.out.println(hex2dec(number));
		}
	}
	
	public static int hex2dec(String str) {
		int decimal = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case 'a':
				decimal += 10 * Math.pow(16, str.length() - i - 1);
				break;
			case 'b':
				decimal += 11 * Math.pow(16, str.length() - i - 1);
				break;
			case 'c':
				decimal += 12 * Math.pow(16, str.length() - i - 1);
				break;
			case 'd':
				decimal += 13 * Math.pow(16, str.length() - i - 1);
				break;
			case 'e':
				decimal += 14 * Math.pow(16, str.length() - i - 1);
				break;
			case 'f':
				decimal += 15 * Math.pow(16, str.length() - i - 1);
				break;
			default:
				double d = c - '0';
				decimal += d * Math.pow(16, str.length() - i - 1);					
			}
		}
		return decimal;
	}
}
