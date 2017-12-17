
public class Dbl extends Expression {
	
	double value;
	
	public Dbl(Double value) {
		this.value = value;
	}
	
	@Override
	public double getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}
