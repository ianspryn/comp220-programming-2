
public class ComparablePair<T extends Comparable<T>, S extends Comparable<S>> extends Pair<T, S> implements Comparable<ComparablePair<T,S>> {
//public class ComparablePair<T,S> extends Pair<T, S> implements Comparable<T> {
//public class ComparablePair<T,S> extends Pair<T, S> implements Comparable<ComparablePair<T,S>> {

	public ComparablePair(T first, S second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(ComparablePair<T, S> other) {
		int value = this.getFirst().compareTo(other.getFirst());
		if (value == 0) {
			return this.getSecond().compareTo(other.getSecond());
		}
		return value;
	}

}
