import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ParseAddress {

	public static void main(String args[]) throws FileNotFoundException {
		File addressesFile = new File("addresses.txt");
		Scanner scanAddresses = new Scanner(addressesFile);
		// Scanner scanAddressesLine = new Scanner (addressesFile);
		
		
		
		while (scanAddresses.hasNextLine()) {
			String[] address = scanAddresses.nextLine().split(", ");
			String city = address[0];
			
			address = address[1].split(" ");
			String zip = address[address.length - 1];
			
			String state = String.join(" ", Arrays.copyOfRange(address, 0, address.length - 1));
			
			System.out.println(city + " " + state + " " + zip);
			
			
			/*scanAddresses.useDelimiter(", ");
			
			address.add(scanAddresses.next());
			
			scanAddresses.useDelimiter("[ \n]");
			scanAddresses.next();

			String state = scanAddresses.next();
			if(!scanAddresses.hasNextInt()) {
				state += " " + scanAddresses.next();
			}
			address.add(state);
			System.out.println("OMGGGGG " + state);
			address.add(scanAddresses.next().trim());

			
			
			
			
			
			System.out.println(Arrays.toString(address.toArray()).append("\n"));
			address.clear();*/
		}
	}

}