import java.util.Scanner;
public class Bin2Dec {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.println("Enter a binary number");
      String number = scnr.nextLine();
      if (!number.matches("[01]+")) {
    	  System.out.println("Wrong kind of numbers bub (aka, NOT IN BINARY FORM)");
      } else {
      System.out.println(bin2dec(number));
      }
   }
   
   public static int bin2dec(String str){
	   double decimal = 0;
	   for (int i = 0; i < str.length(); i++) {
		   double d = str.charAt(i) - '0';
		   decimal += d * Math.pow(2, str.length() - i - 1);
	   }
	   return (int) decimal;
	}
}