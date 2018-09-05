import java.util.Scanner;

public class Recursion {
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Gimme a number to find the factorial");
		System.out.println(factorial(scnr.nextInt()));
		myRecursiveMethod(scnr.nextInt());
		
	}
	
	public static int factorial(int n) {
//		System.out.println("Current number: " + n);
//		if (n == 0) {
//			return 1;
//		} else {
//			int num = n * factorial (n - 1);
//			System.out.println("int num = " + n + " * factorial(" + n + " - 1);");
//			System.out.println("num =  " + num);
//			return num;
//		}
		return (n == 0) ? 1 : n * factorial(n - 1);
	}
	

public static int myRecursiveMethod (int aVariable)
{
  System.out.println(aVariable);
  aVariable--;
  if (aVariable == 0)
    return 0;
  return myRecursiveMethod(aVariable);
}


}