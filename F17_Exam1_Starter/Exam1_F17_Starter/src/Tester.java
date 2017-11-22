import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		OutOfBounds checker = new OutOfBounds(-3, 28);
		
		// Expressions inside assert statements should
		//  be true if the code is correct
		assert(checker.tooHigh() == 0);
		assert(checker.tooLow() == 0);
		
		checker.process(-3);
		assert(checker.tooHigh() == 0);
		assert(checker.tooLow() == 0);
		
		checker.process(29);
		assert(checker.tooHigh() == 1);
		assert(checker.tooLow() == 0);
		
		checker.process(-4);
		assert(checker.tooHigh() == 1);
		assert(checker.tooLow() == 1);
		
		checker.process(-4382);
		assert(checker.tooHigh() == 1);
		assert(checker.tooLow() == 2);
		
		checker.process(-4382);
		assert(checker.tooHigh() == 1);
		assert(checker.tooLow() == 3);
		
		checker.process(15);
		assert(checker.tooHigh() == 1);
		assert(checker.tooLow() == 3);
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(29);
		numbers.add(12);
		numbers.add(-15);
		numbers.add(29);
		
		checker.process(numbers);
		assert(checker.tooHigh() == 3);
		assert(checker.tooLow() == 4);
		
		System.out.println("Passed tests");
		
	}

}
