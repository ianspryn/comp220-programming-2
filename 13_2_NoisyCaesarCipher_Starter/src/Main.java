import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String in = "This is a string; it has punctuation. The end!!!";

		ArrayList<CaesarCipher> ciphers = new ArrayList<>();
		ciphers.add(new CaesarCipher(3));
		ciphers.add(new NoisyCaesarCipher(3, 0.0));
		ciphers.add(new NoisyCaesarCipher(3, 0.1));
		ciphers.add(new NoisyCaesarCipher(3, 0.3));
		
		for(CaesarCipher cc : ciphers){
			//if cc refers to a NoisyCaesarCipher,
			//the call sequence looks like this…
			//Caesar'sCipher's encrypt(String)
			//which calls NoisyCaesarCipher's encrypt(char)
			//which may call CaesarCipher's encrypt(char) (using super.encrypt) 

			String out = cc.encrypt(in);
			System.out.println("Encrypted:  " + out);
			System.out.println("Decrypted:  " + cc.decrypt(out));
			System.out.println();
		}
	}

}
