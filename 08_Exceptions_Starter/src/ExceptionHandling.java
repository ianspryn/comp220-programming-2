
public class ExceptionHandling {

	/** @return s repeated n times
	  * @param n should be non-negative
	  */
	public static String repeat(String s, int n) {
	    if(n < 0){
	        throw new IllegalArgumentException("Cannot repeat a  string " + n + " times");
	    }
	    StringBuilder sb = new StringBuilder();
	    // TODO: finish this
	    for (int i = 0; i < n; i++) {
	    	sb.append(s);
	    	//every time it will take the string s and add it to the string builder
	    }
	    return sb.toString();
	}
	
	public static String progressBar(int width, double percent) {
		int numChars = (int)(Math.floor((width-2) * percent));
		try {
			repeat("X", numChars);
			return "[]";
		} catch (IllegalArgumentException iae) {
			System.err.println("In prgoressBar");
			return "[]";
		}
	}
		
	public static void main(String[] args){
		try{
		    System.out.println(progressBar(1, 0.6));
		}
		catch (IllegalArgumentException iae){
		    System.err.println(iae.getMessage());
		}
		
	}

}
