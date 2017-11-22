
abstract public class Treasure {
	protected double value;
	protected double score;
	
	public Treasure(double value){
		this.value = value;
	}
	
	public double getValue(){
		return this.value;
	}
	
	abstract public double getScore();
	
	public boolean isWorthwhile(){
		if(this.getScore() >= 10){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(!(obj instanceof Treasure)){
			return false;
		}
		
		Treasure other = (Treasure) obj;
		if(this.getScore() == other.getScore() && this.value == other.value){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override public int hashCode(){
		Double newValue = new Double(value);
		Double newScore = new Double(score);
		
		int result = 17;
		result = 37 * result + newValue.hashCode();
		result = 37 * result + newScore.hashCode();
		
		return result;
	}
}
