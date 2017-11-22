import java.util.Random;

public class DiceGame {
	protected final int numPlayers;
	private final int numDice;
	//you have to set the 2 above in the constructor, and after that you can't change it
	private Random randGen;
	
	public DiceGame(int numPlayers, int numDice){
		this.numPlayers = numPlayers;
		this.numDice = numDice;
		randGen = new Random();
	}
	
	/**
	 * @return the sum of the values from the simulated dice roll
	 */
	public int rollDice() {
		int sum = 0;
		for(int dieNum=0; dieNum<numDice; dieNum++){
			sum += randGen.nextInt(6) + 1;
		}
		return sum;
	}
}
