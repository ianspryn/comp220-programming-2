import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class WordFrequencies {

	// prints the n most frequent words
	// (might be more than n in the case of ties)
	public static void printPopular(Map<String, Integer> frequencies, int n){
		// TODO: complete this method
		
		//inv (inverted) @ count -- set of strings with the given count
		TreeMap<Integer, HashSet<String>> inv = new TreeMap<>();
		
		for (String word : frequencies.keySet()) {
			int count = frequencies.get(word);
			
			
			Iterator<Integer> keyInter = inv.descendingKeySet().iterator();
			int wordsPrinted = 0;
			
			while (wordsPrinted < n && keyIter.next()) {
				final int count = keyIter.next);
				Set<String> words = inv.get(count);
				
				for(String word : words) {
					System.out.println(count + "\t" + word);
					wordsPrinted++;
				}
			}
			
			
			if (! inv.containsKey(count)) {
				HashSet<String> hs = new HashSet<>();
				hs.add(word);
				//inv.put(count, word); //IT DON"T LIKE THIS CUZ CONFLICT
				inv.put(count, hs);
				//instead of the word being the key, now the count is the key
			} else {
				//inv already has a HashSet for count
				inv.get(count).add(word);
			}
			
			// "hi"   5
			// "Bye"  5
			// inv.get(t) == HashSet{"bye"} --> want HashSet{"bye", "hi"}
			
			
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(args[0]));
		
		HashMap<String, Integer> frequencies = new HashMap<>();
		
		int totalCount = 0;
		while(in.hasNext()){
			String word = in.next();
			
			// TODO: increment the count for word
			int oldCount = 0;
			if (frequencies.containsKey(word)) {
				oldCount = frequencies.get(word);
			}
			
			//frequencies.put(word, 1 + oldCount);
			frequencies.put(word, 1 + frequencies.getOrDefault(word, 0));
			//^^^ this does the same as the if loop above
			
			
			totalCount++;
		}
		
		System.out.println("Total words: " + totalCount);

		in.close();
		
		printPopular(frequencies, 100);
		
		
	}

}
