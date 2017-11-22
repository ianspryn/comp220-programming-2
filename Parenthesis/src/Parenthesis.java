import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Parenthesis {
	
	public static boolean isBalanced(String filename) throws IOException {
		
		String content = new Scanner(new File(filename)).useDelimiter("\\Z").next();
		
		Stack<Character> stack = new Stack<Character>();
		
		char c;
		for (int i = 0; i < content.length(); i++) {
			c = content.charAt(i);
			
			if (c == '(') {
				stack.push(c);
			} else if (c == '{') {
				stack.push(c);
			}else if (c == '[') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == '}') {
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == ']') {
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
		
	}
	
	
}