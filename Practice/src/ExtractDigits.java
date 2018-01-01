//extract each digit from an int, in the reverse order. For example, if the int is 15423,
//the output shall be "3 2 4 5 1", with a space separating the digits.
public class ExtractDigits {
	public static void main(String[] args) {
		int n = 987654321;
		String myString = "";
		while (n > 0) {
			myString += n % 10 + " ";
			n /= 10;
		}
		System.out.print(myString);
	}
}
