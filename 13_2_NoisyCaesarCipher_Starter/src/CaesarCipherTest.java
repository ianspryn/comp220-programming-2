import org.junit.Assert;
import org.junit.Test;

public class CaesarCipherTest {
	@Test public void testLowercase(){
		String in = "abcdefghijklmnopqrstuvwxyz";
		CaesarCipher cipher = new CaesarCipher(17);
		for(int i=0; i<in.length(); i++){
			char c = in.charAt(i);
			Assert.assertNotEquals(c, cipher.encrypt(c));
			Assert.assertEquals(c, cipher.decrypt(cipher.encrypt(c)));
		}
	}
	
	@Test public void testUppercase(){
		String in = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		CaesarCipher cipher = new CaesarCipher(17);
		for(int i=0; i<in.length(); i++){
			char c = in.charAt(i);
			Assert.assertNotEquals(c, cipher.encrypt(c));
			Assert.assertEquals(c, cipher.decrypt(cipher.encrypt(c)));
		}
	}
	
	@Test public void testOther(){
		String in = " .*()&!#$^%~`[]{};'<>\t\n";
		CaesarCipher cipher = new CaesarCipher(17);
		for(int i=0; i<in.length(); i++){
			char c = in.charAt(i);
			Assert.assertEquals(c, cipher.encrypt(c));
			Assert.assertEquals(c, cipher.decrypt(cipher.encrypt(c)));
		}
	}
	
	@Test public void testEquals(){
		CaesarCipher cipher = new CaesarCipher(17);
		CaesarCipher other = new CaesarCipher(17);
		CaesarCipher yetAnother = new CaesarCipher(43);
		CaesarCipher different = new CaesarCipher(16);
		
		Assert.assertTrue(cipher.equals(other));
		Assert.assertTrue(cipher.equals(yetAnother));
		Assert.assertTrue(! cipher.equals(different));
	}
}
