
public abstract class Expression implements Comparable<Expression> {
	
	public abstract double getValue();

	@Override
	public int compareTo(Expression other) {
		return this.compareTo(other);
	}

}
