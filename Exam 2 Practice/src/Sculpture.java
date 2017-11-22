
public class Sculpture extends Treasure{
	private double weight;

	public Sculpture(double weight, double value){
		super(value);
		this.weight = weight;
	}

	public Sculpture(Sculpture s){
		super(s.value);
		this.weight = s.weight;
	}

	@Override public double getScore(){
		score = this.value/(25000 * this.weight);

		return score;
	}

	@Override public boolean equals(Object obj){
		if(super.equals(obj)) {
			if(!(obj instanceof Sculpture)){
				return false;
			}

			Sculpture other = (Sculpture) obj;
			if(this.weight == other.weight){
				return true;
			}
			else{
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override public int hashCode(){

		Double newWeight = new Double(this.weight);


		int result = super.hashCode();
		result = 37 * result + newWeight.hashCode();

		return result;
	}

}
