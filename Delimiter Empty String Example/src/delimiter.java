import java.io.*;
import java.util.*;

public class delimiter {

	public static void main(String args[]) throws FileNotFoundException {
		File f = new File("input.txt");
		Scanner in = new Scanner(f);
		in.useDelimiter("");
		int i = 0;
		while (in.hasNext()) {
			System.out.println(i + " '" + in.next() + "'");
			i++;
		}
		in.close();
	}
}


//On windows, a new line is represented by 2 line feeds, hence the double enter at 5 and 6