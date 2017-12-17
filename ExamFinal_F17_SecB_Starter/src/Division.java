
public class Division extends Expression {
	Expression first;
	Expression second;
	
	public Division(Expression first, Expression second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public double getValue() {
		return first.compareTo(second);
	}
}
