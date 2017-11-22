import java.util.ArrayList;

public class BoardSequence {

	ArrayList<Board> boards = new ArrayList<Board>();
	
	public BoardSequence(Board startingBoard) {
		boards.add(startingBoard);
	}
	
	public void runMoreSteps(int numSteps) {
		for (int i = 0; i < numSteps; i++) {
			boards.add(boards.get(boards.size() - 1).nextBoard());
		}
	}
	
	public Board boardAt(int index) throws IllegalArgumentException {
		try {
			return boards.get(index);
		} catch (IndexOutOfBoundsException AIOBE) {
			throw new IllegalArgumentException();
		}
	}
	
	public String toString() {
		String toString = "";
		for (int i = 0; i < boards.size(); i++) {
			toString += "Generation " + i + "\n";
			toString += boardAt(i);			
		}
		return toString;
	}
	
	public int findCycle() {
		for (int i = 0; i < boards.size(); i++) {
			for (int j = i + 1; j < boards.size(); j++)
			if (boards.get(i).isSame(boards.get(j))) {
				return j;
			}
		}
		return -1;
	}

}
