
public class CaesarCipher {
	protected final static int NUM_LETTERS = 26;
	private final int shiftAmount;
	
	CaesarCipher(int shiftAmount){
		this.shiftAmount = shiftAmount;
	}
	
	public char encrypt(char c){
		if(Character.isAlphabetic(c)){
			final char base = (Character.isLowerCase(c) ? 'a' : 'A');			
			return (char)(base + ((c - base + shiftAmount) % NUM_LETTERS));
		}
		else{
			return c;
		}
	}
	
	public String encrypt(String s){
		StringBuilder result = new StringBuilder();
		for(int i=0; i<s.length(); i++){
			result.append(encrypt(s.charAt(i)));
		}
		return result.toString();
	}
	
	public char decrypt(char c){
		if(Character.isAlphabetic(c)){
			final char base = (Character.isLowerCase(c) ? 'a' : 'A');			
			return (char)(base + ((c - base - shiftAmount + NUM_LETTERS) % NUM_LETTERS));
		}
		else{
			return c;
		}
	}
	
	public String decrypt(String s){
		StringBuilder result = new StringBuilder();
		for(int i=0; i<s.length(); i++){
			result.append(decrypt(s.charAt(i)));
		}
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj){
		if(! (obj instanceof CaesarCipher)){
			return false;
		}
		
		CaesarCipher other = (CaesarCipher) obj;
		
		return (this.shiftAmount % NUM_LETTERS) == (other.shiftAmount % NUM_LETTERS);
	}
	
	@Override
	public int hashCode(){
		return (this.shiftAmount % NUM_LETTERS);
	}
	
}
