
public class Tester {

	/**
	 * @return 1 if shouldBeTrue is false; 0 otherwise
	 */
	public static int check(boolean shouldBeTrue, String message){
		if(!shouldBeTrue){
			System.err.println("Check failed: " + message);
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Coordinates c1 = new Coordinates(2.3, -12.8);
		Coordinates c2 = new Coordinates(2.3, -12.8);
		Coordinates c3 = new Coordinates(2.1, -12.8);
		Coordinates c4 = new Coordinates(2.3, -12.0);
		
		int numFailedTests = 0;
		
		numFailedTests += check(c1.equals(c2), "c1 equals c2");
		numFailedTests += check(c2.equals(c1), "c2 equals c1");
		numFailedTests += check(c1.hashCode() == c2.hashCode(), "Coordinate hashCodes should be equal");

		numFailedTests += check(!c1.equals(c3), "c1 is not equal to c3");
		numFailedTests += check(!c1.equals(c4), "c1 is not equal to c4");
		
		numFailedTests += check(c1.hashCode() != c3.hashCode(), "Coordinate hash codes should be different");
		
		Geocache g1 = new Geocache(c1, "id1", "no hint");
		Geocache g2 = new Geocache(c2, "id1", "no hint");
		Geocache diffCoords = new Geocache(c3, "id1", "no hint");
		Geocache diffId = new Geocache(c2, "differentId", "no hint");
		Geocache diffHint = new Geocache(c2, "id1", "different hint");
		
		numFailedTests += check(g1.equals(g2), "two equal geocaches");
		numFailedTests += check(g2.equals(g1), "two equal geocaches (reverse)");
		numFailedTests += check(!g1.equals(diffCoords), "different geocache coordinates");
		numFailedTests += check(!g1.equals(diffId), "different ids");
		numFailedTests += check(!g1.equals(diffHint), "different hints");
		
		numFailedTests += check(g1.hashCode() == g2.hashCode(), "geocache hashcodes that should be equal");
		numFailedTests += check(g1.hashCode() != diffCoords.hashCode(), "different hash codes for different geocache coordinates");
		numFailedTests += check(g1.hashCode() != diffId.hashCode(), "different hash codes for different ids");
		numFailedTests += check(g1.hashCode() != diffHint.hashCode(), "different hash codes for different hints");
		
		if(numFailedTests > 0){
			System.out.println("Failed " + numFailedTests + " tests");
		}
		else{
			System.out.println("Passed all tests!");
		}
	}

}
