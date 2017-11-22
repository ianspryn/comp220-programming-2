import java.util.ArrayList;

/**
 * @author WOLFEBD
 * The Vigenere cipher rotates through several Caesar ciphers,
 * using each Caesar cipher to encrypt one letter.
 */
public class VigenereCipher extends Cipher {
	
	private ArrayList<CaesarCipher> subCiphers;
	
	// These variables keep track of which
	//  CaesarCipher to use for the next encrypt
	//  or decrypt operation, respectively.
	private int nextIndexForEncrypt;
	private int nextIndexForDecrypt;
	
	
	public VigenereCipher(Iterable<Integer> shiftAmounts){
		nextIndexForEncrypt = 0;
		nextIndexForDecrypt = 0;
		
		subCiphers = new ArrayList<>();
		for(Integer amt : shiftAmounts){
			subCiphers.add(new CaesarCipher(amt));
		}
	}
	
	public VigenereCipher(VigenereCipher other){
		this.subCiphers = new ArrayList<CaesarCipher>();
		for (CaesarCipher subCipher : other.subCiphers) {
			this.subCiphers.add(new CaesarCipher(subCipher) );
		}
		nextIndexForEncrypt = other.nextIndexForEncrypt;
		nextIndexForDecrypt = other.nextIndexForDecrypt;
	}
	
	@Override
	public char encrypt(char c) {
		char res = subCiphers.get(nextIndexForEncrypt).encrypt(c);
		nextIndexForEncrypt = (nextIndexForEncrypt + 1) % subCiphers.size();
		return res;
	}

	@Override
	public char decrypt(char c) {
		char res = subCiphers.get(nextIndexForDecrypt).decrypt(c);
		nextIndexForDecrypt = (nextIndexForDecrypt + 1) % subCiphers.size();
		return res;
	}

	// Returns a new object, a deep copy of the current object
	@Override
	public Cipher newCopy() {
		return new VigenereCipher(this);
	}

}