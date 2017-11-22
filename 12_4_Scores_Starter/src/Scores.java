import java.util.ArrayList;
import java.util.Random;

public class Scores {

	// scores.get(i) are the scores for student i
	private ArrayList< ArrayList<Integer> > scores;
	
	/**
	 * Randomly creates @param numScores scores for
	 * each of @param numStudents students
	 */
	public Scores(int numStudents, int numScores){
		Random randGen = new Random();
		
		scores = new ArrayList<>();
		for(int student=0; student<numStudents; student++){
			ArrayList<Integer> studentScores = new ArrayList<>();
			scores.add(studentScores);
			// NOTE: we add to scores a reference to the object
			//  When that object changes (loop below), the
			//  reference in scores "sees" that change
			for(int assignment=0; assignment<numScores; assignment++){
				studentScores.add(randGen.nextInt(101));
			}
		}
	}
	
	public Scores(Scores other){
		//this.scores = other.scores; OMG THIS CODE SUX
		// this.scores = new ArrayList<>(other.scores); THIS CODE SUXS LESS (you still get duplicate references to each ArrayList
		this.scores = new ArrayList<>();
		for(ArrayList<Integer> otherStudentScores : other.scores) {
			scores.add(new ArrayList<>(otherStudentScores));
			//Because INteger is immutable, duplicated references to those integers are not a problem
			
		}
		//ALT FOR LOOP
		for (int i =0; i < other.scores.size(); i++) {
			ArrayList<Integer> otherStudentScores = other.scores.get(i);
			
			scores.add(new ArrayList<>(otherStudentScores));
		}
	}
	
	/**
	 * removes each student's lowest score
	 */
	public void dropLowest(){
		for(ArrayList<Integer> studentScores: scores){
			//first, find the lowest score
			int lowest = 110;
			for(Integer score : studentScores){
				if(score < lowest){
					lowest = score;
				}
			}
			
			// remove will only remove the first occurrence
			studentScores.remove(new Integer(lowest));
		}
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(ArrayList<Integer> studentScores : scores){
			for(Integer assignmentScore : studentScores){
				sb.append(assignmentScore);
				sb.append(' ');
			}
			sb.append('\n');
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		Scores rawScores = new Scores(3, 5);
		
		// copy scores, then we will adjust them
		Scores adjustedScores = new Scores(rawScores);
		adjustedScores.dropLowest();
		
		// Print results
		System.out.println("rawScores:");
		System.out.println(rawScores);
		
		System.out.println("adjustedScores:");
		System.out.println(adjustedScores);

	}

}
