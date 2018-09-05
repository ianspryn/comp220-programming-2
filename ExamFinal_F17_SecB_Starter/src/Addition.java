
public class Addition extends Expression {
	Expression first;
	Expression second;
	
	public Addition(Expression first, Expression second) {
		this.first = first;
		this.second = second;
	}
	
	@Override
	public double getValue() {
		return first.getValue() + second.getValue();
	}
	@Override
	public String toString() {
		return first.toString() + "+" + second.toString();
	}
}
