import java.util.ArrayList;

public class Demo {
	public static int findMax(ArrayList<Integer> xs){
		if (xs.size() == 0) {
			throw new IllegalArgumentException("Cannot find max of an empty ArrayList");
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<xs.size(); i++){
			if(xs.get(i) > max){
				max = xs.get(i);
			}
		}
		return max;
	}
}
