import java.io.*;
import java.util.*;

public class GameOfLife {
	
	public static String readFileContents (String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner file = new Scanner(f);
		file.useDelimiter("\\z");
		return file.next();
	}

	public static void main(String args[]) throws IOException {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the starting board file: ");
		String fileInName = console.next();
		System.out.print("Enter the number of generations: ");
		int numGenerations = console.nextInt();
		System.out.print("Enter the output file: ");
		String fileOutName = console.next();
		console.close();
		PrintWriter fileOut = new PrintWriter(fileOutName);
		
		Board board = new Board(readFileContents(fileInName));
		BoardSequence boardsequence = new BoardSequence(board);
		boardsequence.runMoreSteps(numGenerations);
		
		fileOut.print(boardsequence.toString());
		if (boardsequence.findCycle() != -1) {
			System.out.println("Cycle detected on generation " + boardsequence.findCycle());
		} else {
			System.out.println("No cycles detected");
		}
		fileOut.close();
	}

}
