
public class UnorderedPair<T> {
	private T t, t2;
	
	public UnorderedPair(T first, T second) {
		this.t = first;
		this.t2 = second;
	}
	
	public boolean contains(T type) {
		return type.equals(t) || type.equals(t2);
	}
	
	@Override public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof UnorderedPair)){
			return false;
		}
		
		UnorderedPair<?> other = (UnorderedPair<?>) obj;
		if((this.t.equals(other.t) && this.t2.equals(other.t2)) ||
				(this.t.equals(other.t2) && this.t2.equals(other.t))){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override public int hashCode() {
		int result = 17;
		result = t.hashCode() * t2.hashCode();
		
		return result;
	}
}
