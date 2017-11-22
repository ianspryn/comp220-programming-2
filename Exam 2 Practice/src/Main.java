import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		Treasure t = new Sculpture(100.0, 100.0);
		//Sculpture s = new Treasure(100.0);
		
		ArrayList<Treasure> treasures = new ArrayList<>(); 
		treasures.add(new Sculpture(100.0, 100.0)); 
		treasures.add(new Painting(25.0, 31.0, 26.0)); 
		int worthwhileCount = 0; 
		for(Treasure tr : treasures){   
			if(tr.isWorthwhile()){     
				worthwhileCount++;   
				} 
			} 
		
		
		System.out.println(treasures.get(1).getScore());
		System.out.println(t.getScore());
		System.out.println(worthwhileCount);
	}
}
