import java.util.ArrayList;

//THis is how you tell java to implement inheritance, with the extends keyword
public class Monopoly extends DiceGame {
		public static final int numLocations = 40;
		
		private int nextPlayer;
		private ArrayList<Integer> balances; //how much money each person has
		private ArrayList<Integer> locations; //each value is in [0, 39]
		
		//if we were to create the entire game...
		//how much property, which properties, do they have houses, do they have a get-out-of-jail card?

		//WARNING DO NOT redeclare variables from superclass!!
		//like, numDice
		public Monopoly (int numPlayers, int startingBalance) {
			//Call superclass constructor
			super(numPlayers, 2);
			
			nextPlayer = 0;
			
			balances = new ArrayList<>(numPlayers);
			for (int i = 0; i < numPlayers; i++) {
				balances.add(startingBalance);
			}
			locations = new ArrayList<>(numPlayers);
			for (int i = 0; i < numPlayers; i++) {
				locations.add(0);
			}
		}
		
		public void move() {
			int diceResult = rollDice();
			
			int nextLocation = (locations.get(nextPlayer) + diceResult) % numLocations;
			locations.set(nextPlayer, nextLocation);
			
			nextPlayer = (nextPlayer + 1) % numPlayers;
			
			//other game logic would go here
		}
		
		public int getLocation (int playerIndex) {
			return locations.get(playerIndex);
		}
}