import java.util.ArrayList;

public class Student extends ClassMember {
	
	private ArrayList<Double> Grades = new ArrayList<Double>();

	public Student(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		
	}
	
	public void addGrade(Double grade) {
		Grades.add(grade);
	}
	
	public double getAvgGrade() {
		
		Double gradeSum = 0.0;
		
		for (Double gradeNumber : Grades) {
			gradeSum += gradeNumber;
		}
		return gradeSum / Grades.size();
	}

}
