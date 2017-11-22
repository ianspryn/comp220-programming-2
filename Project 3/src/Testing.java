import java.util.Arrays;
import java.util.Scanner;

public class Testing {
	public static boolean runTest(Cipher ci, String answer){
		final String testString = "abcdefghijklmnopqrstuvwxyzABCDLMNOXYZ.$\t() {+}012389";
		assert(testString.length() == answer.length());

		// Ensure that newCopy makes a deep copy
		//  by encrypting 'x' with the deep copy
		//  (but not the original)
		Cipher deepCopy = ci.newCopy();
		deepCopy.encrypt('x');
		
		
		// Iterate through the test string, encrypting each character
		//   and checking against the corresponding answer character
		for(int i=0; i<testString.length(); i++){
			char res = ci.encrypt(testString.charAt(i));
			if(res != answer.charAt(i)){
				System.err.println("Encrypt failed for input character '" +
						testString.charAt(i) + "'. The result was '" + res + 
						"' but it should have been '" + answer.charAt(i) + "'\n");
				return false;
			}
		}

		for(int i=0; i<answer.length(); i++){
			char res = ci.decrypt(answer.charAt(i));
			if(res != testString.charAt(i)){
				System.err.println("Decrypt failed for input character '" +
						answer.charAt(i) + "'. The result was '" + res + 
						"' but it should have been '" + testString.charAt(i) + "'\n");
				return false;
			}
		}

		return true;
	}

	// Creates a cipher to be used for the given test case number
	public static Cipher getTestCipher(int caseNum){
		switch(caseNum){
		case 0:
		{
			CaesarCipher cc = new CaesarCipher(17);
			return cc;
		}

		case 1:
		{
			Integer[] shifts = {5, 3, 16};
			VigenereCipher vc = new VigenereCipher( Arrays.asList(shifts) );
			
			// Check for deep copy by changing state with an "encrypt" call
			VigenereCipher copy = new VigenereCipher(vc);
			copy.encrypt('x');
			
			return vc;
		}

		case 2:
		{
			CompositionCipher comp_cc = new CompositionCipher();
			CaesarCipher temp_cc = new CaesarCipher(18);
			comp_cc.add(temp_cc);
			
			return comp_cc;
		}

		case 3:
		{
			CompositionCipher comp_vc = new CompositionCipher();
			Integer[] shifts = {7, 6, 9};
			VigenereCipher temp_vc = new VigenereCipher( Arrays.asList(shifts) );
			comp_vc.add(temp_vc);
			
			// Check for deep copy by changing state with an "encrypt" call
			CompositionCipher copy = new CompositionCipher(comp_vc);
			copy.encrypt('x');
			
			return comp_vc;
		}

		case 4:
		{
			CompositionCipher comp_comp_cc = new CompositionCipher();
			CompositionCipher temp_comp = new CompositionCipher();
			CaesarCipher temp_cc = new CaesarCipher(4);

			temp_comp.add(temp_cc);
			comp_comp_cc.add(temp_comp);

			return comp_comp_cc;
		}

		case 5:
		{
			CompositionCipher comp_cc_cc = new CompositionCipher();
			CaesarCipher temp_cc1 = new CaesarCipher(19);
			CaesarCipher temp_cc2 = new CaesarCipher(12);

			comp_cc_cc.add(temp_cc1);
			comp_cc_cc.add(temp_cc2);

			return comp_cc_cc;
		}

		case 6:
		{
			CompositionCipher comp_vc_vc = new CompositionCipher();
			{
				Integer[] v1 = {2, 6};
				Integer[] v2 = {12, 13, 14};

				VigenereCipher temp_vc1 = new VigenereCipher(Arrays.asList(v1));
				VigenereCipher temp_vc2 = new VigenereCipher(Arrays.asList(v2));

				comp_vc_vc.add(temp_vc1);
				comp_vc_vc.add(temp_vc2);
			}
			return comp_vc_vc;
		}

		case 7:
		{
			CompositionCipher comp_vc_cc = new CompositionCipher();
			Integer[] v = {12, 13, 14};

			VigenereCipher temp_vc = new VigenereCipher(Arrays.asList(v));
			CaesarCipher temp_cc = new CaesarCipher(5);
			comp_vc_cc.add(temp_vc);
			comp_vc_cc.add(temp_cc);

			return comp_vc_cc;
		}

		case 8:
		{
			CompositionCipher comp_mix = new CompositionCipher();

			Integer[] v1 = {2, 6};
			Integer[] v2 = {12, 13, 14};

			CompositionCipher temp_comp = new CompositionCipher();
			VigenereCipher temp_vc1 = new VigenereCipher(Arrays.asList(v1));
			VigenereCipher temp_vc2 = new VigenereCipher(Arrays.asList(v2));
			CaesarCipher temp_cc1 = new CaesarCipher(19);
			CaesarCipher temp_cc2 = new CaesarCipher(8);

			temp_comp.add(temp_vc1);
			temp_comp.add(temp_cc1);

			comp_mix.add(temp_cc2);
			comp_mix.add(temp_comp);
			comp_mix.add(temp_vc2);

			return comp_mix;
		}

		default:
			throw new IllegalArgumentException("Unrecognized case number: " + caseNum);
		}
	}



	public static void main(String[] args){
		final int NUM_TEST_CASES = 9;

		int targetTestCase = -1;

		// Read the test case number (-1 through 8) from standard input
		// -1 indicates that we should run all the tests
		Scanner in = new Scanner(System.in);
		targetTestCase = in.nextInt();


		// The answers we should be getting for each test case
		String[] answers = {"rstuvwxyzabcdefghijklmnopqRSTUCDEFOPQ.$\t() {+}012389",
				"fesihvlkyonbrqeuthxwkazndcQGFTQPDTAOE.$\t() {+}012389",
				"stuvwxyzabcdefghijklmnopqrSTUVDEFGPQR.$\t() {+}012389",
				"hhlkkonnrqquttxwwazzdccgffJIIMSSWVDHG.$\t() {+}012389",
				"efghijklmnopqrstuvwxyzabcdEFGHPQRSBCD.$\t() {+}012389",
				"fghijklmnopqrstuvwxyzabcdeFGHIQRSTCDE.$\t() {+}012389",
				"ousvtzuaybzfagehflgmknlrmsQTRXZFDGMSN.$\t() {+}012389",
				"rtvuwyxzbacedfhgikjlnmoqprTSUWCEGFPRQ.$\t() {+}012389",
		"pvtwuavbzcagbhfigmhnlomsntRUSYAGEHNTO.$\t() {+}012389"};



		// If targetTestCase is negative, then we run all tests.
		// Otherwise, we just run the one specified on standard input.
		for(int currentCase=0; currentCase < NUM_TEST_CASES; currentCase++){
			if(currentCase == targetTestCase || targetTestCase < 0){
				// Run the test
				Cipher pc = getTestCipher(currentCase);
				boolean passed = runTest(pc, answers[currentCase]);

				if(passed){
					System.out.println("Passed test case " + currentCase);
				}
				else{
					System.out.println("FAILED test case " + currentCase);
				}
			}
		}

	}
}
