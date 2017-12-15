import java.util.ArrayList;

public class Scores {
		
		private String name;
		private ArrayList<Integer> scores;
		
		public Scores(String name, ArrayList<Integer> scores){
			this.name = name;
			this.scores = new ArrayList<Integer>(scores);
		}
		
		public String getName(){
			return this.name;
		}
		
		public ArrayList<Integer> getTheScores(){
			return this.scores;
		}
		
		public String toString(){
			return this.getName() + " " + this.getTheScores().toString();
		}
	}