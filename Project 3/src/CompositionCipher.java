import java.util.ArrayList;
import java.util.Collections;

public class CompositionCipher extends Cipher {

	private ArrayList<Cipher> ciphers;
	
	public CompositionCipher() {
		ciphers = new ArrayList<Cipher>();
	}
	
	public CompositionCipher(CompositionCipher other) {
		this.ciphers = new ArrayList<Cipher>();
		for (Cipher cipher : other.ciphers) {
			this.ciphers.add(cipher.newCopy());
		}
	}

	@Override
	public char encrypt(char c) {
		for (Cipher cipher : ciphers) {
			c = cipher.encrypt(c);
		}
		return c;
	}

	@Override
	public char decrypt(char c) {
		Collections.reverse(ciphers);
		for (Cipher cipher : ciphers) {
			c = cipher.decrypt(c);
		}
		Collections.reverse(ciphers);
		return c;
	}

	@Override
	public Cipher newCopy() {
		return new CompositionCipher(this);
	}
	
	public void add(Cipher theCipher) {
		ciphers.add(theCipher);
	}
}
