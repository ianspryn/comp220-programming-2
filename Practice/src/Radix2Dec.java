import java.util.Scanner;
public class Radix2Dec {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.println("Enter the radix:");
      int radix = scnr.nextInt();
      scnr.nextLine();
      System.out.println("Enter the string:");
      String number = scnr.nextLine();
      if (!number.matches("[0123456789abcdef]+")) {
    	  System.out.println("Wrong kind of numbers bub (aka, NOT IN HEXADECIMAL FORM)");
      } else {
      System.out.println(radix2dec(radix, number));
      }
   }
   
   public static int radix2dec(int power, String str){
	   double decimal = 0;
	   for (int i = 0; i < str.length(); i++) {
		   double d = str.charAt(i) - '0';
		   decimal += d * Math.pow(power, str.length() - i - 1);
	   }
	   return (int) decimal;
	}
}