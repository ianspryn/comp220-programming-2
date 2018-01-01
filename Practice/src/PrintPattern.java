import java.util.Scanner;

//#                    # # # # # # # #      # # # # # # # #                    #
//# #                  # # # # # # #          # # # # # # #                  # #
//# # #                # # # # # #              # # # # # #                # # #
//# # # #              # # # # #                  # # # # #              # # # #
//# # # # #            # # # #                      # # # #            # # # # #
//# # # # # #          # # #                          # # #          # # # # # #
//# # # # # # #        # #                              # #        # # # # # # #
//# # # # # # # #      #                                  #      # # # # # # # #
//     (a)                   (b)                  (c)                  (d)
//    
//# # # # # # #    # # # # # # #    # # # # # # #    # # # # # # #    # # # # # # #
//#           #      #                        #        #       #      # #       # #
//#           #        #                    #            #   #        #   #   #   #
//#           #          #                #                #          #     #     #
//#           #            #            #                #   #        #   #   #   #
//#           #              #        #                #       #      # #       # #
//# # # # # # #    # # # # # # #    # # # # # # #    # # # # # # #    # # # # # # #
//     (e)               (f)             (g)              (h)              (i)
public class PrintPattern {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a number.");
		int userDigit = scnr.nextInt();
		
		System.out.println("(a)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("# ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//b
		//a sloppy method for b
//		for (int i = userDigit; i > 0; i--) {
//			for (int j = 0; j < i; j++) {
//				System.out.print("# ");
//			}
//			System.out.println();
//		}
		
		//a cleaner method for b
		System.out.println("(b)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = i; j < userDigit; j++) {
				System.out.print("# ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(c)");
		int count = 0;
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < userDigit; j++) {
				if (j < count) {
					System.out.print("  ");
				} else {
					System.out.print("# ");
				}
			}
			count++;
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(d)");
		count = userDigit - 1;
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < userDigit; j++) {
				if (j < count) {
					System.out.print("  ");
				} else {
					System.out.print("# ");
				}
			}
			count--;
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(e)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < userDigit; j++) {
				if (i > 0 && i < userDigit - 1) {
					if (j > 0 && j < userDigit - 1) {
						System.out.print("  ");
					} else {
						System.out.print("# ");
					}
				} else {
					System.out.print("# ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(f)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < userDigit; j++) {
				if (i > 0 && i < userDigit - 1) {
					if (j == i) {
						System.out.print("# ");
					} else {
						System.out.print("  ");
					}
				} else {
					System.out.print("# ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(g)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < userDigit; j++) {
				if (i > 0 && i < userDigit - 1) {
					if (j == userDigit - i - 1) {
						System.out.print("# ");
					} else {
						System.out.print("  ");
					}
				} else {
					System.out.print("# ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(h)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < userDigit; j++) {
				if (i > 0 && i < userDigit - 1) {
					if (j == i || j == userDigit - i - 1) {
						System.out.print("# ");
					} else {
						System.out.print("  ");
					}
				} else {
					System.out.print("# ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("(i)");
		for (int i = 0; i < userDigit; i++) {
			for (int j = 0; j < userDigit; j++) {
				if (i > 0 && i < userDigit - 1) {
					if (j == 0 || j == userDigit - 1 || j == i || j == userDigit - i - 1) {
						System.out.print("# ");
					} else {
						System.out.print("  ");
					}
				} else {
					System.out.print("# ");
				}
			}
			System.out.println();
		}
	}
}
