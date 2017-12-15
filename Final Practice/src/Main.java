import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> lol = new ArrayList<>();
		lol.add(3);
		lol.add(12);
		lol.add(2);
		lol.add(6);
		System.out.println(max(lol, 2));
		
		System.out.println(getScores("Bob 79 20 128 John 76 Jill 81 38 201 36"));
	}
	
	//10
	public static ArrayList<Scores> getScores(String s){
		ArrayList<Scores> stuScoreArray = new ArrayList<Scores>();
		
		Scanner scnr = new Scanner(s);
		ArrayList<Integer> scoresList;
		
		while(scnr.hasNext()){
			scoresList = new ArrayList<Integer>();
			String name = scnr.next();
			while(scnr.hasNextInt()){
				scoresList.add(scnr.nextInt());
			}
			Scores student = new Scores(name, scoresList);
			stuScoreArray.add(student);
		}
		
		scnr.close();
		return stuScoreArray;
	}
	
	//8
	public static Integer max(ArrayList<Integer> xs, int start){
		int max = xs.get(start);
		if(start + 1 < xs.size()){
			if(max < max(xs, start + 1)){
				max = xs.get(start + 1);
			}
		}	
		return max;
	}
}
