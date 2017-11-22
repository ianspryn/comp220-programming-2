import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebPageReading {

	public static String getWebPage(String address) throws IOException {
		URL url = new URL(address);
		Scanner in = new Scanner(url.openStream());
		StringBuilder sb = new StringBuilder();
		while(in.hasNextLine()){
			sb.append(in.nextLine());
			sb.append('\n');
		}
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner consoleIn = new Scanner(System.in);
		boolean done = false;
		while(!done){
			
			System.out.print("Enter a web address, including http:// (or q to quit): ");
			String address = consoleIn.nextLine();
			
			if(address.equals("q")){
				done = true;
			}
			else{
				String s;
				try {
					
					//in the try, the first line is usually the first thing that might go wrong
					//everything else below is is stuff I'm saying "skip this if something went wrong above"
					s = getWebPage(address);
					System.out.print(s);
				} catch (MalformedURLException mue) {
					System.out.println("Please enter a valid web address");
				} catch (FileNotFoundException fnfe) {
					System.out.println("COuld not reach the web address");
				} catch (IOException e) { //Leave this one as last. It's a fail safe to catch anything not caught above
					System.out.println("Please try again");
					
					//for debugging, we probably want a little more info
					System.err.println(e.getMessage());
					e.printStackTrace(); //You don't want this in production code!
				}
				
			}
		}
		
		consoleIn.close();
	}


}
