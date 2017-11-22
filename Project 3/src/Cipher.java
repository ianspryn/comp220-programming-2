
public abstract class Cipher {
	protected final static int NUM_LETTERS = 26;
	
	public abstract char encrypt(char c);
	
	public abstract char decrypt(char c);
	
	public String encrypt(String s){
		StringBuilder result = new StringBuilder();
		for(int i=0; i<s.length(); i++){
			result.append(encrypt(s.charAt(i)));
		}
		return result.toString();
	}
	
	public String decrypt(String s){
		StringBuilder result = new StringBuilder();
		for(int i=0; i<s.length(); i++){
			result.append(decrypt(s.charAt(i)));
		}
		return result.toString();
	}
	
	public abstract Cipher newCopy();
	
}