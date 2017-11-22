import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class IntervalOverlaps {

	/**
	 * @return @param n random intervals
	 * Starting points are drawn from [0, maxVal).
	 */
	public static ArrayList<Interval> randomIntervals(int n, long maxVal){
		Random randGen = new Random();
		ArrayList<Interval> result = new ArrayList<>();
		
		for(int i=0; i<n; i++){
			long start = randGen.nextLong() % maxVal;
			int length = randGen.nextInt(1200); // 1200 seconds is 20 minutes
			if(start + length > maxVal){
				// This is a safe cast because:
				// start + length > maxVal implies
				// length > maxVal - start,
				// and length was no more than 1200
				length = (int) (maxVal - start);
			}
			result.add(new Interval(i, start, start + length));
		}
		
		return result;
	}
	
	/**
	 * print a line to out for each overlapping pair,
	 *   with the ids of the two intervals
	 * Example:
	 * 1, 5
	 * 1, 10
	 * 13, 125
	 * ...
	 */
	public static void printOverlaps(ArrayList<Interval> ivs, PrintWriter out){
		// TODO: complete this method
		// TODO: Each pair should only be printed once.
		//       For example, don't include 3, 5 and 5, 3.
		for (int i = 0; i < ivs.size(); i++) {
			Interval ivOne = ivs.get(i);
			for (int j = i + 1; j < ivs.size(); j++) {
				if (ivOne.overlaps(ivs.get(j))) {
					out.println(ivOne.getId() + ", " + ivs.get(j).getId());
				}
			}			
		}
	}
	
	public static void printOverlapsQuickly(ArrayList<Interval> ivs, PrintWriter out) {
		Collections.sort(ivs);
		
		for (int i = 0; i < ivs.size(); i++) {
			//only loop j until its starting point is after i's
			Interval ivOne = ivs.get(i);
			final long bound = ivOne.getEnd();
			for (int j = i + 1; j < ivs.size() && ivs.get(j).getStart()<= bound; j++) {
				//we already know that j starts at or after i's start (because of the sorting)
				//and j starts at or before i's end (loop condition tells us that)
				//Therefore, i and j overlap
				out.println(ivOne.getId() + ", " + ivs.get(j).getId());
			}
		}			
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		final long maxVal = 259200; // number of seconds in three days
		final int numIntervals = 50000;
		ArrayList<Interval> ivs = randomIntervals(numIntervals, maxVal);
		
		long startTime, endTime;
		PrintWriter pw;
		
		pw = new PrintWriter("overlaps.txt");
		startTime = System.currentTimeMillis();
		//printOverlaps(ivs, pw);
		printOverlapsQuickly(ivs, pw);
		endTime = System.currentTimeMillis();
		pw.close();
		System.out.println("Nested loops method on " + numIntervals + " intervals (sec.): "
					+ ((endTime - startTime) / 1000.0));
		

	}

}
