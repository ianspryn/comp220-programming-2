import java.util.*;

/**
 * Represents a TicTacToe board
 * Does not track whose turn it is
 * @author A BUNCH OF PEOPLE
 *
 */
public class Board {
	
	
	//boardSPaces @ 0 s the top left space
	//baordSpaces @1 is the top middle space
	private ArrayList<SpaceStatus> boardSpaces;
	
	/**
	 * @return true if all spaces are filled,
	 * 		false if there is some empty space
	 */
	public boolean isFull() {
		//check every space for EMPTY
		for (int i = 0; i < boardSpaces.size(); i++) {
			if (boardSpaces.get(i) == SpaceStatus.EMPTY) {
				//found an empty space
				//no need to keep looking; return false
				return false;
			}
		}
		//we have checked all spaces, found no empties,
		//so the board is full
		return true;
	}
	
	
	/**
	 * @return EMPTY if no one has won, HAS_X if x has won, HAS_O if O has one
	 */
	
	public SpaceStatus checkForWin() {
		//TODO: complete this method
		
		/*
		X - -
		- X -
		- - X
		*/
		if ((boardSpaces.get(0) != SpaceStatus.EMPTY) && ((boardSpaces.get(0) == boardSpaces.get(4)) && (boardSpaces.get(4) == boardSpaces.get(8)))) {
			return boardSpaces.get(0);
		}
		// TODO: check the diagonals for a win
		
		/*
		O O O
		- - -
		- - -
		*/
		
		// Check Rows
		for(int i = 0; i < 3; i++){
    		if(((boardSpaces.get(0+(i*3)) == boardSpaces.get(1+(i*3))) && (boardSpaces.get(1 + i*3) == boardSpaces.get(2+(i*3)))) && boardSpaces.get(0+(i*3)) != SpaceStatus.EMPTY){
    		    return boardSpaces.get(0+(i*3));
    		}
		}
		
		// TODO: check all columns for a win
		if ((boardSpaces.get(0) == boardSpaces.get(3)) && (boardSpaces.get(3) == boardSpaces.get(6)) && (boardSpaces.get(0) != SpaceStatus.EMPTY)) {
		    return boardSpaces.get(0);
		}
		if ((boardSpaces.get(1) == boardSpaces.get(4)) && (boardSpaces.get(4) == boardSpaces.get(7)) && (boardSpaces.get(1) != SpaceStatus.EMPTY)) {
		    return boardSpaces.get(1);
		}
		if ((boardSpaces.get(2) == boardSpaces.get(5)) && (boardSpaces.get(5) == boardSpaces.get(8)) && (boardSpaces.get(2) != SpaceStatus.EMPTY)) {
		    return boardSpaces.get(2);
		}
		
		return SpaceStatus.EMPTY;
	}
}