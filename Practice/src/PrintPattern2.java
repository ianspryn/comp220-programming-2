import java.util.Scanner;

public class PrintPattern2 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a number.");
		int userDigit = scnr.nextInt();
		scnr.close();
		
		System.out.println("(a)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < 2 * userDigit - 1; j++) {
				if (j > i - 1 && j < 2 * userDigit - 1 - i) {
					System.out.print("# ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		System.out.println("(b)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < 2 * userDigit - 1; j++) {
				if (j >= userDigit - 1 - i && j <= userDigit - 1 + i) {
					System.out.print("# ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		System.out.println("(c)");
		for (int i = 0; i < 2 * userDigit - 1; i++) {
			for (int j = 0; j < 2 * userDigit - 1; j++) {
				if ((i <= userDigit - 1 && j >= userDigit - 1 - i && j <= userDigit + i - 1)
						|| (i > userDigit - 1 && j > i - userDigit && j < 2 * userDigit - 1 - (i - (userDigit - 1)))) {
					System.out.print("# ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		System.out.println("(d)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(j + 1 + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(e)");
		int count = 0;
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < userDigit; j++) {
				if (j < count) {
					System.out.print("  ");
				} else {
					System.out.print(j + 1 + " ");
				}
			}
			count++;
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(f)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = userDigit; j > 0; j--) {
				if (j < i + 2) {
					System.out.print(j + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(g)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = userDigit; j > 0; j--) {
				if (j > i) {
					System.out.print(j - i + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("(h)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < 2 * userDigit - 1; j++) {
				if (j >= userDigit - 1 - i && j <= userDigit - 1 + i) {
					if (j <= userDigit - 1) {
						System.out.print(j - (userDigit - 2) + i + " ");
					} else {
						System.out.print(i - (j - userDigit) + " ");
					}
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(i)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < 2 * userDigit - 1; j++) {
				if (j > i - 1 && j < 2 * userDigit - 1 - i) {
					if (j < userDigit) {
						System.out.print(j + 1 - i + " ");
					} else {
						System.out.print(-j + 2 * userDigit - (1 + i) + " ");
						//j - ((j + 1) - (userDigit - (j - userDigit)) + i)
					}
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(j)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < 2 * userDigit - 1; j++) {
					if (j < userDigit && j < i + 1) {
						System.out.print(j + 1 + " ");
					} else if (j >= userDigit && j > 2 * userDigit - 3 - i) {
						System.out.print(2 * userDigit - 1 - j + " ");
					}
					else {
					System.out.print("  ");
					}
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(k)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < 2 * userDigit - 1; j++) {
				if (j < userDigit && j < userDigit - i) {
					System.out.print(j + 1 + " ");
				} else if (j >= userDigit && j > userDigit - 2 + i) {
					System.out.print(2 * userDigit - 1 - j + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("(l)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < 2 * userDigit - 1; j++) {
				if (j >= userDigit - 1 - i && j <= userDigit - 1 + i) {
					if (j < userDigit) {
						System.out.print(Math.abs(userDigit - (j + 2 + 2 * i)) % 10 + " ");
					}
					else {
						System.out.print((Math.abs((userDigit + 2 * i) - j)) % 10 + " ");
					}
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}
