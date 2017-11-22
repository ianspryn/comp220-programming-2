import java.util.Random;

public class NoisyCaesarCipher extends CaesarCipher{
	private Random randGen;
	private double noiseProb; // probability of generating a random character when encrypting

	public NoisyCaesarCipher(int shiftAmount, double noiseProb) {
		super(shiftAmount);

		randGen = new Random();
		this.noiseProb = noiseProb;
		//we need to save this noiseProb for later, so that's why we're saving it to noiseProb
	}

	@Override
	public char encrypt(char c) {
		if (randGen.nextDouble() < noiseProb) {
			//return a random lower-case letter
			return (char) (randGen.nextInt(NUM_LETTERS) + 'a');
		} else {
			//call superclass implementation
			return super.encrypt(c);
		}
	}

	@Override
	//because we overrode member variables, we need to add equals
	public boolean equals(Object obj) {
		if ( !(obj instanceof NoisyCaesarCipher)) {
			return false;
		}

		NoisyCaesarCipher other = (NoisyCaesarCipher) obj;

		//check the super member variables and those I added
		return super.equals(other) && this.noiseProb == other.noiseProb;
	}

	@Override
	public int hashCode() {
		//hash code should account for superclass variables as well as my own layer
		return super.hashCode() ^ Double.valueOf(noiseProb).hashCode();

	//^ is XOR?
	}
}
