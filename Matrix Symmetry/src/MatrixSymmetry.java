import java.io.*;
import java.util.*;

public class MatrixSymmetry {

	public static void main(String args[]) throws FileNotFoundException {
		//import txt file
		Scanner console = new Scanner(System.in);
		File matrix = new File(console.next());
		Scanner scanMatrix = new Scanner(matrix);
		
		//the number of rows is given to us in the first line, so we take that
		int numRows = scanMatrix.nextInt();
		//define the number of columns
		int numColumns = 0;
		
		//add up the total number of integers
		while (scanMatrix.hasNextInt()) {
			numColumns++;
			scanMatrix.nextInt();
		}
		
		//divide the total number of integers in the matrix but the number of rows to find the number of columns
		numColumns /= numRows;
		
		
		//restart the scanner to start scanning from the beginning
		scanMatrix.close();
		scanMatrix = new Scanner(matrix);
		//increment by one to skip past the given number of rows
		scanMatrix.nextInt();
		
		//define the matrix with the proper dimensions
		int storedMatrix[][] = new int[numRows][numColumns];
		
		//read the numbers into storedMatrix
		for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                storedMatrix[i][j] = scanMatrix.nextInt();
            }
		}
		
		//output information to the user
		System.out.println(numRows);
		System.out.println(numColumns);
		if (numRows != numColumns) {
			System.out.println("not symmetric");
		} else {
			boolean isSymmetric = true;
			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numColumns; j++) {
					if (storedMatrix[i][j] != storedMatrix[j][i]) {
						isSymmetric = false;
						break;
					}
				}
			}
			
			
			//output if it is symmetric or not
			if (isSymmetric) {
				System.out.println("symmetric");
			} else {
				System.out.println("not symmetric");
			}
			
		}
		scanMatrix.close();
	}
}
