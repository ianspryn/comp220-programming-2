import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;
/*
:                                                         
	  7?                                   
	     =O?=                                                 
	         ~7=          88888,                              
	            =OZ?=   DDD8Z$7ZOOZ                           
	                :O?8O8D8ZZI+==IZ8OZ                       
	                  =IZZ$Z7$ZOZZ7I=IZO8Z$                   
	                   O7=ZIZIZZZZO7ZI=IIZOOZO                
	                     ZI7I==?IIIZ7Z777+?$OOO7              
	                       Z$I+?=:=?II$77$ZII7Z$OZ            
	                        ?$Z77I===??II7$$III=I$O           
	                          7$$I+=====++++$I?+II$OZ         
	                           OI+=I+=:~====+I+7+7+?Z8        
	                            O$==7=::~=====+IIIII$ZO       
	                             ?7=?ZO7+====+??+7IIIZO       
	                             =I78Z  II$7I=??I77?I$ZO      
	                             $ZZ8$     +7$$II7I7$7$8      
	                             :88I         $Z7I7I77Z8      
	                                            IZ77$$ZO      
	                                             7Z$$$$I      
	                                              Z7$ZO       
	                                              OZZZ7       
	                                              Z$$8        
	                                             :ZZ8         
	                                         88OOO8O          
	                                          8DD88Z          
	                                             $8O8         
	                                               Z8Z
*/



/**
 * 
 * @author Ian Spryn
 * A snapshot of a Game of Life board at one point in time
 */
public class Board {
	private int numberOfRows;
	private int numberOfColumns;
	private boolean[][] cells;
	
	public Board(int numberOfRows, int numberOfColumns){
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		
		cells = new boolean[numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				cells[i][j] = false;
			}
		}
	}

	public Board(String boardInfo){
		Scanner fileIn = new Scanner(boardInfo);
		fileIn.nextLine();
		this.numberOfRows = fileIn.nextInt();
		this.numberOfColumns = fileIn.nextInt();
		fileIn.nextLine();
		
		String rowString = "";
		
		fileIn.useDelimiter("");
		
		cells = new boolean[numberOfRows][numberOfColumns];
		while (fileIn.hasNextLine()) {
			for (int row = 0; row < numberOfRows; row++) {
				rowString = fileIn.nextLine();
				for (int column = 0; column < numberOfColumns; column++) {
					cells[row][column] = !Character.isSpaceChar(rowString.charAt(column));
				}
			}
		}
		fileIn.close();
	}
	
	public int getNumRows(){
		return numberOfRows;
	}
	
	public int getNumCols(){
		return numberOfColumns;
	}
	
	public boolean getCell(int row, int col) throws IllegalArgumentException {
		try {
			return cells[row][col];
		}
		catch (ArrayIndexOutOfBoundsException AIOBE) {
			throw new IllegalArgumentException();
		}
	}
	
	public Board nextBoard(){
		Board nextCells = new Board(getNumRows(), getNumCols());
		for (int currentRow = 0; currentRow < getNumRows(); currentRow++) {
			for (int currentColumn = 0; currentColumn < getNumCols(); currentColumn++) {
				int numLiveNeighbors = Neighbors(cells, getNumRows(), getNumCols(), currentRow, currentColumn);
								
				if (numLiveNeighbors == 2) {
	                nextCells.cells[currentRow][currentColumn] = cells[currentRow][currentColumn];
	            } else if (numLiveNeighbors == 3) {
	            	nextCells.cells[currentRow][currentColumn] = true;
	            } else {
	            	nextCells.cells[currentRow][currentColumn] = false;
	            }
				nextCells.cells[0][currentColumn] = false;
				nextCells.cells[getNumRows() - 1][currentColumn] = false;
				nextCells.cells[currentRow][0] = false;
				nextCells.cells[currentRow][getNumCols() - 1] = false;
			}
		}
		return nextCells;
	}
	
	private int Neighbors(boolean[][] cells, int numberOfRows, int numberOfColumns, int currentRow, int currentColumn) {
		int numLiveNeighbors = 0;
		for(int i = currentRow - 1; i <= currentRow + 1; i++) {
	        if (i >= 0 && i < numberOfRows) {
	            for(int j = currentColumn - 1; j <= currentColumn + 1; j++) {
	                if (j >= 0 && j < numberOfColumns) {
	                    if (i != currentRow || j != currentColumn) {
	                        if (cells[i][j]) {
	                        	numLiveNeighbors++;
	                        }
	                    }
	                }
	            }
	        }
		}
		return numLiveNeighbors;
	}

	public boolean isSame(final Board other){
		return Arrays.deepEquals(cells, other.cells);
	}
	
	@Override
	public String toString(){
		String toString = "";
		for (int i = 0; i < getNumRows(); i++) {
			for (int j = 0; j < getNumCols(); j++) {
				if(getCell(i, j)) {
					toString += "X";
				} else {
					toString += ".";
				}
			}
			toString += "\n";
		}
		return toString;
	}
	
	

}
