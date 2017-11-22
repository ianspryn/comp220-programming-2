
public class Main {
	public static void main(String[] args){
		final int numDice = 5;
		DiceGame justDice = new DiceGame(1, numDice);
		for(int i=0; i<5; i++){
			System.out.println("Rolling " + numDice + " dice: " + justDice.rollDice());
		}
		
		final int numPlayers = 2;
		Monopoly monopoly = new Monopoly(numPlayers, 200);
		for(int i=0; i<14; i++){
			monopoly.move();
			for(int plyr=0; plyr<numPlayers; plyr++){
				System.out.print(monopoly.getLocation(plyr) + "\t");
			}
			System.out.println();
		}
	}
}
