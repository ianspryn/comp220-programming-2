import java.util.Scanner;
public class Oct2Dec {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.println("Enter a octcal number");
      String number = scnr.nextLine();
      if (!number.matches("[01234567]+")) {
    	  System.out.println("Wrong kind of numbers bub (aka, NOT IN OCTAL FORM)");
      } else {
      System.out.println(oct2dec(number));
      }
   }
   
   public static int oct2dec(String str){
	   double decimal = 0;
	   for (int i = 0; i < str.length(); i++) {
		   double d = str.charAt(i) - '0';
		   decimal += d * Math.pow(8, str.length() - i - 1);
	   }
	   return (int) decimal;
	}
}