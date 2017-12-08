import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class DUMBEST {
   private Stack<Character> stack;
   private String parse;
   private String output = "";
   
   public DUMBEST(String parse) {
      this.parse = parse;
      stack = new Stack<Character>();
   }
   
   public String doTrans() {
      for (int i = 0; i < parse.length(); i++) {
         char c = parse.charAt(i);
         switch (c) {
            case '+':
            case '-':
               gotOper(c, 1);
               break;
            case '*':
            case '/':
            case '^':
               gotOper(c, 2);
               break;
            case '(':
               stack.push(c);
               break;
            case ')':
               gotParen();
               break;
            default:
            	for (int j = i; j < parse.length(); j++) {
	        		if (!Character.isDigit(parse.charAt(j))) {
	        			break;
	        		}
	        		output += (parse.charAt(j));
	        		i = j;
	        	}
            	output += " ";
               //output += c;
               break;
         }
      }
      while (!stack.isEmpty()) {
    	  if (stack.peek() != '(') {
    		  output += stack.pop() + " ";
    	  } else {
    		  stack.pop();
    	  }
      }
      return output;
   }
   
   public void gotOper(char opThis, int prec1) {
      while (!stack.isEmpty()) {
    	  if (stack.peek() != '(') {
    		  char c = stack.pop();
    		  if ((c == '+' || c == '-') && prec1 == 2) {
	           	 stack.push(c);
	           	 break;
	           	 } else {
	           		 output += c + " ";
	           		 }
    		  } else {
    			  break;
	         }
      }
      stack.push(opThis);
   }
   
   public void gotParen() { 
      while (!stack.isEmpty()) {
         if (stack.peek() != '('){
        	 output += stack.pop() + " ";
         } else {
        	 stack.pop();
        	 break;
         }
      }
   }
   
   public static void main(String[] args) throws IOException {
	  Scanner scnr = new Scanner(System.in);
      String parse = scnr.nextLine();
      System.out.println(new DUMBEST(parse.toLowerCase().replaceAll("\\s+", "")).doTrans());
   }
}