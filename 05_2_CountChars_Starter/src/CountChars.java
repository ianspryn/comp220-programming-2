import java.io.IOException;
import java.util.Scanner;
import java.net.URL;

public class CountChars {

	public static void main(String[] args) throws IOException {
		String address = "https://www.google.com";
		URL url = new URL(address);
		Scanner in = new Scanner(url.openStream());

		in.useDelimiter("");

		// TODO: count character types
		
		// TODO: print results to System.out
	}

}
