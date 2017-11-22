import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WebCrawling {

	public static void main(String[] args) {
		final int maxPages = 100000;
		
		long startTime, endTime; //timing variables
		
		List<String> urls = new LinkedList<>();
		// if you change this to ArrayList, ^^^^ it'll take ~6 seconds instead of 0.06
		urls.add("starting url");
		
		startTime = System.currentTimeMillis();
		for(int page=0; page<maxPages; page++){
			// remove the first item
			String nextUrl = urls.remove(0);
			
			// fetching and indexing would go here
			
			// add the "links" to the urls collection
			for(int i=0; i<8; i++){
				urls.add("another url");
			}
		}
		endTime = System.currentTimeMillis();
		double seconds = (endTime - startTime) / 1000.0;
		
		System.out.println("For " + maxPages + " pages, it took " + seconds);
		
		
	}

}
