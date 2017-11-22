import java.util.ArrayList;

public class BuggyReferencePassing {
	public static void fillRange(int start, int end, boolean reset,
				ArrayList<Integer> vals){
	    
	    if(reset){
	        vals = new ArrayList<>();
	    }
	    
	    for(int i=start; i<=end; i++){
	        vals.add(i);
	    }
	}
	
	public static void main(String[] args){
	    ArrayList<Integer> theList = new ArrayList<>();
	    theList.add(5);
	
	    fillRange(1, 3, true, theList);
	    System.out.println(theList.size());
	}

}
