
public class Painting extends Treasure{
	private double height;
	private double width;


	public Painting(double height, double width, double value){
		super(value);
		this.height = height;
		this.width = width;
	}

	public double getArea(){
		return this.height * this.width;
	}

	@Override public double getScore(){
		score = this.value/(10000 * this.getArea());

		return score;
	}

	@Override public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if(!(obj instanceof Painting)){
				return false;
			}

			Painting other = (Painting) obj;
			if(this.getArea() == other.getArea()) {
				return true;
			}
			else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override public int hashCode(){
		Double newArea = new Double(this.getArea());


		int result = super.hashCode();
		result = 37 * result + newArea.hashCode();

		return result;
	}
}
